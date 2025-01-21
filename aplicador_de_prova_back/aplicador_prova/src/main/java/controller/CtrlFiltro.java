package controller;

import java.io.IOException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.google.gson.Gson;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;
import model.Usuario;

@Provider
@PreMatching
public class CtrlFiltro implements ContainerRequestFilter {
	@Context
	private HttpServletRequest request;

	private int direcao = 1;

	public CtrlFiltro() {
		System.out.println("Filtro: " + this);
	}

	@Override
	public void filter(ContainerRequestContext ctx) throws IOException {
		System.out.println("\n\n\nInício FILTRO ");
		String path = ctx.getUriInfo().getPath();
		System.out.println("Path da Requisição: " + path);

		// Verifico se a requisição é para obter o WADL
		if (path.contains("application.wadl"))
			return;

		// Verificando se o usuário já se autenticou
		if (!path.contains("login")) {
			boolean autenticado = false;
			if (request.getCookies() != null) {
				for (Cookie biscoito : request.getCookies()) {
					if (biscoito.getName().equals("DESWEB")) {
						System.out.println("Cookie DESWEB com Base64 = " + biscoito.getValue());
						try {
							byte[] decoded = Base64.getDecoder().decode(biscoito.getValue().getBytes());
							System.out.println("Cookie DESWEB com codificacao " + new String(decoded));
							String conteudoJson = CtrlFiltro.descriptografar(decoded);
							Gson conversor = new Gson();
							Usuario usr = conversor.fromJson(conteudoJson, Usuario.class);
							System.out.println(usr.getConta());
							
							// Verificando se o tempo presente dentro do cookie faz sentido
							// no contexto do sistema (evitando cópia de conteúdo entre usuários)
							long diff = System.currentTimeMillis() - usr.getDataHoraLogin();
							if(diff < CtrlGerenciarLogin.TIMEOUT_EM_MILISEGUNDOS)								
								autenticado = true;
							else
								System.out.println("TEMPO ESTOURADO!");								
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}

			if (!autenticado) {
			//	System.out.println("Sessão não aberta!");
			//	throw new NotAuthorizedException("Não autorizado");
			}

		} else {
			System.out.println("Requisição de login.");
		}
		System.out.println("Fim FILTER " + request);
	}

	private static String IV = "AAAAAAAAAAAAAAAA";
	private static String chaveCriptografia = "0123456789abcdef";

	public static byte[] criptografar(String texto) throws Exception {
		Cipher cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveCriptografia.getBytes("UTF-8"), "AES");
		cifrador.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return cifrador.doFinal(texto.getBytes());
	}

	public static String descriptografar(byte[] cripto) throws Exception {
		Cipher decifrador = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveCriptografia.getBytes("UTF-8"), "AES");
		decifrador.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(decifrador.doFinal(cripto));
	}
}
