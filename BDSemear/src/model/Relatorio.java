package model;

public class Relatorio {

	private int id, qdeVol, numCont, mes, ano;
	private String projetos, matUsado;
	private double valor;
	private Instituicao instituicao;
	
	public Relatorio() {
	}
	
	public Relatorio(int id, int qdeVol, int numCont, int mes, int ano, String projetos, String matUsado, double valor,
			Instituicao instituicao) {
		this.id = id;
		this.qdeVol = qdeVol;
		this.numCont = numCont;
		this.mes = mes;
		this.ano = ano;
		this.projetos = projetos;
		this.matUsado = matUsado;
		this.valor = valor;
		this.instituicao = instituicao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQdeVol() {
		return qdeVol;
	}
	public void setQdeVol(int qdeVol) {
		this.qdeVol = qdeVol;
	}
	public int getNumCont() {
		return numCont;
	}
	public void setNumCont(int numCont) {
		this.numCont = numCont;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getProjetos() {
		return projetos;
	}
	public void setProjetos(String projetos) {
		this.projetos = projetos;
	}
	public String getMatUsado() {
		return matUsado;
	}
	public void setMatUsado(String matUsado) {
		this.matUsado = matUsado;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	
}
