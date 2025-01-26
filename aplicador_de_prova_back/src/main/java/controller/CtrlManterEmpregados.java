package controller;

import java.util.Collection;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import model.DaoDepartamento;
import model.DaoEmpregado;
import model.Departamento;
import model.Empregado;
import model.ModelException;

//
// Exemplos de Requisições:
// (POST) http://127.0.0.1:8080/prjRestExemplo01/ws/ctrlEmpregado/login/aacc
// (GET)  http://127.0.0.1:8080/prjRestExemplo01/ws/ctrlEmpregado/listarEmpregados
// (PUT)  http://127.0.0.1:8080/prjRestExemplo01/ws/ctrlEmpregado/alterarEmpregado/1/RH/RecursosHumanos
// 
// WADL disponível em http://127.0.0.1:8080/prjRestExemplo01/ws/application.wadl?
//

@Path("/Empregado")
public class CtrlManterEmpregados implements InterfaceCtrlManterEmpregados {
	@Override
	public Empregado incluirEmpregado(Empregado empregado) throws ModelException{
		DaoDepartamento daoDepartamento = new DaoDepartamento();
		// O objeto Departamento vinculado ao objeto 'empregado' recebido contém 
		// somente o id do Departamento ao qual o empregado será vinculado. Dessa
		// forma, ele é uma espécie de Data Transfer Object (DTO). Vamos pegar esse
		// vínculo para recuperar o objeto Departamente que contém o id passado.
		Departamento dtoDepartamento = empregado.getDepto();
		Departamento depto = daoDepartamento.obterDepartamento(dtoDepartamento.getId());
		if(depto == null)
			throw new ModelException("Empregado Inválido!");
		// Estabeleço o vínculo do Empregado com o objeto Departamento real
		empregado.setDepto(depto);
		DaoEmpregado daoEmpregado = new DaoEmpregado();
		// Salvo o objeto Empregado
		daoEmpregado.incluirEmpregado(empregado);
		return empregado;
	}

	@Override
	public Collection<Empregado> listarEmpregados() {
		System.out.println("listando...");
		DaoEmpregado dao = new DaoEmpregado();
		return dao.obterEmpregados();
	}

	@Override
	public Empregado listarEmpregado(int id) {
		System.out.println("-->" + id);
		DaoEmpregado dao = new DaoEmpregado();
		Empregado empregado = dao.obterEmpregado(id);
		if(empregado == null)
			throw new WebApplicationException(
				Response.status(Response.Status.BAD_REQUEST).entity("Empregado não encontrado").build());
		return dao.obterEmpregado(id);
	}

	@Override
	public Empregado alterarEmpregado(Empregado empPassado) {
		DaoEmpregado dao = new DaoEmpregado();
		Empregado empregado = dao.obterEmpregado(empPassado.getId());
		if (empregado == null)
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Empregado não encontrado").build());
		try {
			empregado.setNome(empPassado.getNome());
			empregado.setIdade(empPassado.getIdade());
		} catch (ModelException e) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build());
		}
		return dao.alterarEmpregado(empregado);
	}

	@Override
	public Empregado removerEmpregado(int id) {
		DaoEmpregado dao = new DaoEmpregado();
		Empregado empregado = dao.obterEmpregado(id);
		if (empregado == null)
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Empregado não encontrado").build());
		return dao.removerEmpregado(empregado);
	}
}
