package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import model.validacao.DisciplinaValidacao;

@Entity
public class Disciplina {
	//
    // CONSTANTES
	//
	final public static DisciplinaValidacao _ = new DisciplinaValidacao(); 
    final public static int TAMANHO_MAX_CODIGO_DISCIPLINA = 14; // Atualizado para 2, se o código deve ter 2 dígitos
    final public static int TAMANHO_MINIMO_NOME = 5;
    final public static int TAMANHO_MAXIMO_NOME = 50;
    final public static int TAMANHO_OBJETIVO_GERAL = 300;
    final public static int MAX_NUM_CREDITOS = 8;
    //
    // ATRIBUTOS
    //
    @Id @GeneratedValue
    private int         id;
    @Column(length = TAMANHO_MAX_CODIGO_DISCIPLINA, unique = true)
    private String      codigo;
    @Column(length = TAMANHO_MAXIMO_NOME)
    private String      nome;
    @Column
    private int         numCreditos;
    @Column(length = TAMANHO_OBJETIVO_GERAL)
    private String      objetivoGeral;

    //
    // ATRIBUTOS DE RELACIONAMENTO
    // 
    @OneToMany(mappedBy = "disciplina")
    private Set<Topico> conjTopicos; // relacionamento bidirecional

    // 
    // MÉTODOS
    //
    public Disciplina() {
    	super();    	
    }
    
    public Disciplina(String codigo, String nome, int numCreditos) throws ModelException {
    	super();
    	this.setCodigo(codigo);
        this.setNome(nome);
        this.setNumCreditos(numCreditos);
        this.conjTopicos = new HashSet<Topico>();
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

   public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) throws ModelException {
        _.validarCodigo(codigo);
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws ModelException {
    	_.validarNome(nome);
        this.nome = nome;
    }

    public int getNumCreditos() {
        return this.numCreditos;
    }

    public void setNumCreditos(int numCreditos) throws ModelException {
    	_.validarNumCreditos(numCreditos);
        this.numCreditos = numCreditos;
    }

    public String getObjetivoGeral() {
    	return this.objetivoGeral;
    }
    
    public void setObjetivoGeral(String objetivo) throws ModelException {
    	_.validarObjetivoGeral(objetivo);
        this.objetivoGeral = objetivo;
    }

    public Set<Topico> getConjTopicos() {
    	// Retorno uma cópia do conjunto de tópicos
		return new HashSet<Topico>(this.conjTopicos);
	}

	public void setConjTopicos(Set<Topico> conjTopicos) throws ModelException {
		_.validarConjTopicos(conjTopicos);
		this.conjTopicos = conjTopicos;
	}

	public boolean addTopico(Topico topico) throws ModelException {
		_.validarTopico(topico);
		return this.conjTopicos.add(topico);
	}
	
	public boolean removeTopico(Topico topico) throws ModelException {
		return this.conjTopicos.remove(topico);
	}
	
    @Override
    public String toString() {
        return "Disciplina{" +
                "código ='" + this.codigo + '\'' +
                ", nome='" + this.nome + '\'' +
                ", creditos=" + this.numCreditos +
                '}';
    }
}