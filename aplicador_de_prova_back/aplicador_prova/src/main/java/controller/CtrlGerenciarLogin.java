package controller;

import java.nio.charset.Charset;
import java.util.Base64;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import model.Usuario;

@Path("/ctrlLogin")
public class CtrlGerenciarLogin implements InterfaceCtrlGerenciarLogin {
	
	final public static int TIMEOUT_EM_MILISEGUNDOS = 60000;
	
	@Context
	private HttpServletRequest request;

	@Override
	public Response login(String conta) throws Exception {
		
		Usuario novoLogin = new Usuario(conta);
		Gson conversor = new Gson();
		String dadoDaAutenticacao = conversor.toJson(novoLogin);
		System.out.println("---> " + dadoDaAutenticacao);
				
		byte[] dadoAuthCripto = CtrlFiltro.criptografar(dadoDaAutenticacao);
		System.out.println("Cifrado   ---> " + new String(dadoAuthCripto, Charset.forName("US-ASCII")) + " " + dadoAuthCripto.length);		
		System.out.println("Cifrado Base64  ---> " + new String(Base64.getEncoder().encode(dadoAuthCripto)));		
		
		NewCookie cookieAuth = new NewCookie.Builder("DESWEB")
		         .path("/prjDeNovo")
		         .domain("127.0.0.1")
		         .maxAge(TIMEOUT_EM_MILISEGUNDOS/1000)
		         .value( new String(Base64.getEncoder().encode(dadoAuthCripto)) )
		         .build();

		
		NewCookie cookieRastro = new NewCookie.Builder("RASTREAR")
		         .path("/")
		         .domain("lasalle.edu.br")
		         .maxAge(10000)
		         .value( "TÔ NA ÁREA" )
		         .build();

		
		return Response
				.ok("Login da conta '" + conta + "' feito com sucesso!")
				.cookie(cookieAuth)
				.cookie(cookieRastro)
				.build();		
	}
}

