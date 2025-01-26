package controller;

import java.util.Collection;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Empregado;
import model.ModelException;

public interface InterfaceCtrlManterEmpregados {
	@POST
	@Path("incluir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Empregado incluirEmpregado(Empregado empregado) throws ModelException;

	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Empregado> listarEmpregados();

	@GET
	@Path("listar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Empregado listarEmpregado(@PathParam("id") int id);

	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Empregado alterarEmpregado(Empregado emp);

	@DELETE
	@Path("remover/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Empregado removerEmpregado(@PathParam("id") int id);
}
