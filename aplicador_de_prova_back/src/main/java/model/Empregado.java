package model;

import java.io.Serializable;

public class Empregado implements Serializable, Comparable<Empregado> {
	//
	//  ATRIBUTOS
	//
	private int				id;
	private String 			nome;
	private int				idade;
	//---- Atributo de relacionamento. É através deste atributo que o objeto
	//---- Empregado sabe qual é o seu departamento
	private Departamento 	depto;
	
	//
	// MÉTODOS
	//
	public Empregado() {
	}
	
	public Empregado(int id, String n, int idade, Departamento depto) throws ModelException {
		super();
		this.setId(id);
		this.setNome(n);
		this.setIdade(idade);
		this.setDepto(depto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws ModelException {
		if(!Empregado.validarId(id))
			throw new ModelException("O Id passado é inválido: " + id);
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String n) throws ModelException {
		if(!Empregado.validarNome(n))
			throw new ModelException("O nome passado é inválido: " + n);
		this.nome = n;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws ModelException {
		if(!Empregado.validarIdade(idade))
			throw new ModelException("A idade passada é inválida: " + idade);
		this.idade = idade;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) throws ModelException {
		if(!Empregado.validarDepto(depto))
			throw new ModelException("Departamento inválido!");
		this.depto = depto;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	public int compareTo(Empregado outro) {
		return this.nome.compareTo(outro.nome);
	}
	
	public static boolean validarId(int id) {
		if(id > 0)
			return true;
		return false;
	}

	public static boolean validarIdade(int idade) {
		if(idade < 0 || idade > 150)
			return false;
		return true;
	}

	public static boolean validarNome(String nome) {
		if(nome != null && nome.length() > 2 && nome.length() <= 40)
			return true;
		return false;
	}

	public static boolean validarDepto(Departamento depto) {
		if(depto != null)
			return true;
		return false;
	}
}
