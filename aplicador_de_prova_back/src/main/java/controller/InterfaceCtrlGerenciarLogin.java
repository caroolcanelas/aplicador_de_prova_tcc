package controller;

import jakarta.ws.rs.core.Response;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public interface InterfaceCtrlGerenciarLogin {
	@POST
	@Path("login/{conta}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response login(@PathParam("conta") String conta) throws Exception;
}
