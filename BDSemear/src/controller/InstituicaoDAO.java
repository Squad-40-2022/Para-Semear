package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Instituicao;


public class InstituicaoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Instituicao ins) {

		String sql = "INSERT INTO INSTITUCOES(tel_ins,senha_ins,email_ins,cnpj_ins,n_res,n_fant,rs,end_ins,doc_ins,uf_ins,cid_ins,id_ins)" + " VALUE(?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, ins.getTel());
			pstm.setString(2, ins.getSenha());
			pstm.setString(3, ins.getEmail());
			pstm.setString(4, ins.getCnpj());
			pstm.setString(5, ins.getNomeResp());
			pstm.setString(6, ins.getNomeFant());
			pstm.setString(7, ins.getRazSocial());
			pstm.setString(8, ins.getEnd());
			pstm.setString(9, ins.getDoc());
			pstm.setString(10, ins.getUf());
			pstm.setString(11, ins.getCidade());
			pstm.setInt(12, ins.getId());

			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeBy(int id) {

		String sql = "DELETE FROM INSTITUICOES WHERE id_ins=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	public void update(Instituicao ins) {

		String sql = "update INSTITUICOES SET tel_ins=? senha_ins=? email_ins=? cnpj_ins=? n_res=? n_fant=? rs=? end_ins=? doc_ins=? uf_ins=? cid_ins=? id_ins=?  ";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, ins.getTel());
			pstm.setString(2, ins.getSenha());
			pstm.setString(3, ins.getEmail());
			pstm.setString(4, ins.getCnpj());
			pstm.setString(5, ins.getNomeResp());
			pstm.setString(6, ins.getNomeFant());
			pstm.setString(7, ins.getRazSocial());
			pstm.setString(8, ins.getEnd());
			pstm.setString(9, ins.getDoc());
			pstm.setString(10, ins.getUf());
			pstm.setString(11, ins.getCidade());
			pstm.setInt(12, ins.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public List<Instituicao> getInstituicoes() {

		String sql = "SELECT * FROM INSTITUICOES";

		List<Instituicao> instituicoes = new ArrayList<Instituicao>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Instituicao ins = new Instituicao();
							
				ins.setId(rset.getInt("id_ins"));
				ins.setCnpj(rset.getString("cnpj_ins"));
				ins.setRazSocial(rset.getString("rS"));
				ins.setNomeFant(rset.getString("n_fant"));
				ins.setNomeResp(rset.getString("n_res"));
				ins.setTel(rset.getString("tel_ins"));
				ins.setEnd(rset.getString("end_ins"));
				ins.setCidade(rset.getString("cid_ins"));
				ins.setUf(rset.getString("uf_ins"));
				ins.setEmail(rset.getString("email_ins"));
				ins.setSenha(rset.getString("senha_ins"));
				ins.setDoc(rset.getString("doc_ins"));
				
				instituicoes.add(ins);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instituicoes;
	}

	public Instituicao insById(int id) {

		String sql = "SELECT * FROM INSTITUICOES WHERE id_ins=?";

		ResultSet rset = null;

		Instituicao ins = new Instituicao();
		
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			ins.setId(rset.getInt("id_ins"));
			ins.setCnpj(rset.getString("cnpj_ins"));
			ins.setRazSocial(rset.getString("rS"));
			ins.setNomeFant(rset.getString("n_fant"));
			ins.setNomeResp(rset.getString("n_res"));
			ins.setTel(rset.getString("tel_ins"));
			ins.setEnd(rset.getString("end_ins"));
			ins.setCidade(rset.getString("cid_ins"));
			ins.setUf(rset.getString("uf_ins"));
			ins.setEmail(rset.getString("email_ins"));
			ins.setSenha(rset.getString("senha_ins"));
			ins.setDoc(rset.getString("doc_ins"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ins;
	}
}