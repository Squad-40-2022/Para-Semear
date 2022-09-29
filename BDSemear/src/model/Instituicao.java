package model;

import java.util.Date;

public class Instituicao {

	private int id;
	private String cnpj ,razSocial, nomeFant, nomeResp, tel, end, cidade, uf, email, senha, doc;
	
	public Instituicao() {
	}
	
	public Instituicao(int id, String cnpj, String razSocial, String nomeFant, String nomeResp, String tel, String end,
			String cidade, String uf, String email, String senha, String doc) {
		this.id = id;
		this.cnpj = cnpj;
		this.razSocial = razSocial;
		this.nomeFant = nomeFant;
		this.nomeResp = nomeResp;
		this.tel = tel;
		this.end = end;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.senha = senha;
		this.doc = doc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazSocial() {
		return razSocial;
	}
	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial;
	}
	public String getNomeFant() {
		return nomeFant;
	}
	public void setNomeFant(String nomeFant) {
		this.nomeFant = nomeFant;
	}
	public String getNomeResp() {
		return nomeResp;
	}
	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}

	
}
