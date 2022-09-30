package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Doacao {

	private int id;
	private String tipo, descricao, docComp;
	private LocalDate data;
	private double quantMat;
	private char anonimo;
	private Colaborador colaborador;
	private Instituicao instituicao;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Doacao() {
	}

	public Doacao(int id, String tipo, String descricao, String docComp, String data, double quantMat, char anonimo,
			Colaborador colaborador, Instituicao instituicao) {
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.docComp = docComp;
		this.data = LocalDate.parse(data, formatter);
		this.quantMat = quantMat;
		this.anonimo = anonimo;
		this.colaborador = colaborador;
		this.instituicao = instituicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDocComp() {
		return docComp;
	}

	public void setDocComp(String docComp) {
		this.docComp = docComp;
	}

	public String getData() {
		return formatter.format(data);
	}

	public void setData(String date) {
		this.data = LocalDate.parse(date, formatter);
	}

	public double getQuantMat() {
		return quantMat;
	}

	public void setQuantMat(double quantMat) {
		this.quantMat = quantMat;
	}

	public char getAnonimo() {
		return anonimo;
	}

	public void setAnonimo(char anonimo) {
		this.anonimo = anonimo;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
