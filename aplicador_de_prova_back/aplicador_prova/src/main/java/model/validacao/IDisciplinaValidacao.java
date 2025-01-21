package model.validacao;

import java.util.Set;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import model.ModelException;
import model.Topico;

public interface IDisciplinaValidacao {

	// Métodos de validação
	@GET
	@Path("validarNumCreditos/{numCreditos}")
	void validarNumCreditos(int numCreditos) throws ModelException;

	@GET
	@Path("validarCodigo/{codigo}")
	void validarCodigo(String codigo) throws ModelException;

	@GET
	@Path("validarNome/{nome}")
	void validarNome(String nome) throws ModelException;

	@GET
	@Path("validarObjetivoGeral/{objetivo}")
	void validarObjetivoGeral(String objetivo) throws ModelException;

	void validarConjTopicos(Set<Topico> conjTopicos) throws ModelException;

	void validarTopico(Topico topico) throws ModelException;
}