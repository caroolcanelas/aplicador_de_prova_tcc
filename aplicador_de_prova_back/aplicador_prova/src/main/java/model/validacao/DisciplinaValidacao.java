package model.validacao;

import java.util.Set;

import jakarta.ws.rs.Path;
import model.Disciplina;
import model.ModelException;
import model.Topico;

@Path("/validarDisciplina")
public class DisciplinaValidacao implements IDisciplinaValidacao {
	// Métodos de validação
    @Override
	public void validarNumCreditos(int numCreditos) throws ModelException {
        if(numCreditos < 0)
            throw new ModelException("A quantidade de creditos precisa ser maior ou igual a 0");
        if(numCreditos > Disciplina.MAX_NUM_CREDITOS)
            throw new ModelException("A quantidade de creditos não pode ultrapassar a " + Disciplina.MAX_NUM_CREDITOS);
    }

    @Override
	public void validarCodigo(String codigo) throws ModelException {
        if(codigo == null || codigo.length() == 0) 
            throw new ModelException("O código não pode ser nulo!");
        		
        if(codigo.length() > Disciplina.TAMANHO_MAX_CODIGO_DISCIPLINA)
            throw new ModelException("O código da disciplina não pode ser maior que " + Disciplina.TAMANHO_MAX_CODIGO_DISCIPLINA + " caracteres");
    }

    @Override
	public void validarNome(String nome) throws ModelException {
        if (nome == null || nome.length() == 0)
            throw new ModelException("O nome não pode ser nulo!");
        if (nome.length() < Disciplina.TAMANHO_MINIMO_NOME || nome.length() > Disciplina.TAMANHO_MAXIMO_NOME)
            throw new ModelException("O nome deve ter de " + Disciplina.TAMANHO_MINIMO_NOME + " a " +
            		Disciplina.TAMANHO_MAXIMO_NOME + " caracteres!");
        for (int i = 0; i < nome.length(); i++) {
            char c = nome.charAt(i);
            if( !Character.isAlphabetic(c) && !Character.isSpaceChar(c) && c != '\'')
                throw new ModelException("O caracter na posição " + i + " é inválido: " + c);
        }
    }

    @Override
	public void validarObjetivoGeral(String objetivo) throws ModelException {
    	if(objetivo == null || objetivo.length() == 0)
    		throw new ModelException("É necessário definir o conteúdo do objetivo geral da disciplina");
    }

    @Override
	public void validarConjTopicos(Set<Topico> conjTopicos) throws ModelException {
    	if(conjTopicos == null)
    		throw new ModelException("O conjunto de tópicos não pode ser nulo");
    }

    @Override
	public void validarTopico(Topico topico) throws ModelException {
    	if(topico == null)
    		throw new ModelException("O tópico não pode ser nulo");
    }
}
