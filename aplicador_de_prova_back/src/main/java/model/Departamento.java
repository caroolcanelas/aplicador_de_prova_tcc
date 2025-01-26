package model;

import java.io.Serializable;

public class Departamento implements Serializable, Comparable<Departamento> {
	//
	//  ATRIBUTOS
	//
	private int				id;
	private String 			sigla;
	private String 			nome;
	
	//
	// MÉTODOS
	//
	public Departamento() {
	}
	
	public Departamento(int id, String s, String n) throws ModelException {
		super();
		this.setId(id);
		this.setSigla(s);
		this.setNome(n);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws ModelException {
		if(!Departamento.validarId(id))
			throw new ModelException("O Id passado é inválido: " + id);
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String s) throws ModelException {
		if(!Departamento.validarSigla(s))
			throw new ModelException("A sigla passada é inválida: " + s);
		this.sigla = s;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String n) throws ModelException {
		if(!Departamento.validarNome(n))
			throw new ModelException("O nome passado é inválido: " + n);
		this.nome = n;
	}

	@Override
	public String toString() {
		return "(Departamento)" + this.sigla + "-" + this.nome;
	}
	
	public int compareTo(Departamento outro) {
		return this.nome.compareTo(outro.nome);
	}
	
	public static boolean validarId(int id) {
		if(id > 0)
			return true;
		return false;
	}

	public static boolean validarSigla(String sigla) {
		if(sigla != null && sigla.length() == 2)
			return true;
		return false;
	}

	public static boolean validarNome(String nome) {
		if(nome != null && nome.length() > 2 && nome.length() <= 40)
			return true;
		return false;
	}
}
