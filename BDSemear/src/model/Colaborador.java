package model;

import java.time.LocalDate;

public class Colaborador {

	private int id;
	private String cpfOrCnpj, nome, sobNome, tel, end, cidade, uf, email, senha, disp;
	private char genero, volunt;
	private LocalDate nasc;
	
	public Colaborador() {
	}
	
	public Colaborador(int id, String cpfOrCnpj, String nome, String sobNome, String tel, String end, String cidade,
			String uf, String email, String senha, String disp, char genero, char volunt, LocalDate nasc) {
		this.id = id;
		this.cpfOrCnpj = cpfOrCnpj;
		this.nome = nome;
		this.sobNome = sobNome;
		this.tel = tel;
		this.end = end;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.senha = senha;
		this.disp = disp;
		this.genero = genero;
		this.volunt = volunt;
		this.nasc = nasc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}
	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobNome() {
		return sobNome;
	}
	public void setSobNome(String sobNome) {
		this.sobNome = sobNome;
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
	public String getDisp() {
		return disp;
	}
	public void setDisp(String disp) {
		this.disp = disp;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public char getVolunt() {
		return volunt;
	}
	public void setVolunt(char volunt) {
		this.volunt = volunt;
	}
	public LocalDate getNasc() {
		return nasc;
	}
	public void setNasc(LocalDate nasc) {
		this.nasc = nasc;
	}
	
}
