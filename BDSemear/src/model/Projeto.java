package model;

public class Projeto {

	private int id, numCont;
	private String nome, local, frequencia, descricao;
	private char situacao;
	private Instituicao instituicao;
	
	public Projeto() {
	}
	
	public Projeto(int id, int numCont, String nome, String local, String frequencia, String descricao, char situacao,
			Instituicao instituicao) {
		this.id = id;
		this.numCont = numCont;
		this.nome = nome;
		this.local = local;
		this.frequencia = frequencia;
		this.descricao = descricao;
		this.situacao = situacao;
		this.instituicao = instituicao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumCont() {
		return numCont;
	}
	public void setNumCont(int numCont) {
		this.numCont = numCont;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public char getSituacao() {
		return situacao;
	}
	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	
}
