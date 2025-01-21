package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Opcao {
	//
	// ATRIBUTOS
	//
    @Id @GeneratedValue
    private int     id;
    @Column(length = 300)
	private String  conteudo;
    @Column
	private boolean correta;

	//
	// MÉTODOS
	//
    public Opcao() {
    }
    
	public Opcao(String conteudo, boolean correta) throws ModelException {
		super();
		this.setConteudo(conteudo);
		this.setCorreta(correta);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(String conteudo) throws ModelException {
		Opcao.validarConteudo(conteudo);
		this.conteudo = conteudo;
	}

	public boolean isCorreta() {
		return this.correta;
	}

	public void setCorreta(boolean correta) throws ModelException {
		this.correta = correta;
	}

	public static void validarConteudo(String conteudo) throws ModelException {
		if (conteudo == null || conteudo.length() == 0)
			throw new ModelException("A opção precisa ter conteúdo!");
	}

	@Override
	public String toString() {
		return "Opcao{" + "conteúdo ='" + this.conteudo + '\'' + ", valor=" + this.correta + "}";
	}
}
