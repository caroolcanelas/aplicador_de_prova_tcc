package controller;

import java.util.Collection;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import model.DaoDepartamento;
import model.Departamento;
import model.ModelException;

//
// Exemplos de Requisições:
// (POST) http://127.0.0.1:8080/prjStateless/ws/ctrlDepartamento/login/aacc
// (GET)  http://127.0.0.1:8080/prjStateless/ws/ctrlDepartamento/listarDepartamentos
// (PUT)  http://127.0.0.1:8080/prjStateless/ws/ctrlDepartamento/alterarDepartamento/1/RH/RecursosHumanos
// 
// WADL disponível em http://127.0.0.1:8080/prjRestExemplo01/ws/application.wadl?
//

@Path("/ctrlDepartamento")
public class CtrlManterDepartamentos implements InterfaceCtrlManterDepartamentos {
	@Context
	private HttpServletRequest request;

	@Override
	public String login(String conta) throws Exception {
		// Criando uma sessão para este login
		HttpSession sessao = request.getSession(true);
		// Penduro na sessão qual é a conta vinculada
		sessao.setAttribute("conta", conta);
		// String cripto = criptografar("-----TESTE-----");
		// System.out.println(cripto);
		// String txt = descriptografar(cripto);
		return "Login da conta '" + conta + "' feito com sucesso!";
	}

	@Override
	public Departamento incluirDepartamento(Departamento novo) {
		System.out.println("Novo: " + novo);
		DaoDepartamento dao = new DaoDepartamento();
		dao.incluirDepartamento(novo);
		return novo;
	}

	@Override
	public Collection<Departamento> listarDepartamentos() {
		System.out.println("listando...");
		DaoDepartamento dao = new DaoDepartamento();
		return dao.obterDepartamentos();
	}

	@Override
	public Departamento listarDepartamento(int id) {
		System.out.println("-->" + id);
		DaoDepartamento dao = new DaoDepartamento();
		return dao.obterDepartamento(id);
	}

	@Override
	public Departamento alterarDepartamento(int id, String sigla, String nome) {
		DaoDepartamento dao = new DaoDepartamento();
		Departamento depto = dao.obterDepartamento(id);
		if (depto == null)
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Departamento n�o encontrado").build());
		try {
			depto.setSigla(sigla);
			depto.setNome(nome);
		} catch (ModelException e) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build());
		}
		return dao.alterarDepartamento(depto);
	}

	@Override
	public Departamento removerDepartamento(int id) {
		DaoDepartamento dao = new DaoDepartamento();
		Departamento depto = dao.obterDepartamento(id);
		if (depto == null)
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Departamento n�o encontrado").build());
		return dao.removerDepartamento(depto);
	}

	private static String IV = "AAAAAAAAAAAAAAAA";
	private static String chaveCriptografia = "0123456789abcdef";

	public static String criptografar(String texto) throws Exception {
		Cipher cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveCriptografia.getBytes("UTF-8"), "AES");
		cifrador.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(cifrador.doFinal(texto.getBytes()));
	}

	public static String descriptografar(String cripto) throws Exception {
		Cipher descifrador = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveCriptografia.getBytes("UTF-8"), "AES");
		descifrador.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(descifrador.doFinal(cripto.getBytes()), "UTF-8");
	}
}
