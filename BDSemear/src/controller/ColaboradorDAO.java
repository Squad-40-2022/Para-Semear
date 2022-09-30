package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Colaborador;

public class ColaboradorDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void save(Colaborador col) {

		String sql = "INSERT INTO colaborador(cpf_cnpj_col, nome_col, dn_col, tel_col, email_col, senha_col, uf_col, sn_col, sexo_col, end_col, vol, dis_col, cid_col)" + " VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, col.getCpfOrCnpj());
			pstm.setString(2, col.getNome());
			pstm.setDate(3, new Date(formatter.parse(col.getNasc()).getTime()));
			pstm.setString(4, col.getTel());
			pstm.setString(5, col.getEmail());
			pstm.setString(6, col.getSenha());
			pstm.setString(7, col.getUf());
			pstm.setString(8, col.getSobNome());
			pstm.setString(9, String.valueOf(col.getGenero()));
			pstm.setString(10, col.getEnd());
			pstm.setString(11, String.valueOf(col.getVolunt()));
			pstm.setString(12, col.getDisp());
			pstm.setString(13, col.getCidade());

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

		String sql = "DELETE FROM colaborador WHERE id_col=?";

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
	
	public void update(Colaborador col) {

		String sql = "update colaborador SET cpf_cnpj_col = ?,nome_col = ?, dn_col = ?, tel_col = ?, email_col = ?, senha_col = ?, uf_col = ?, sn_col = ?, sexo_col = ?, end_col = ?, vol = ?, dis_col = ?, cid_col = ? where id_col = ?";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, col.getCpfOrCnpj());
			pstm.setString(2, col.getNome());
			pstm.setDate(3, new Date(formatter.parse(col.getNasc()).getTime()));
			pstm.setString(4, col.getTel());
			pstm.setString(5, col.getEmail());
			pstm.setString(6, col.getSenha());
			pstm.setString(7, col.getUf());
			pstm.setString(8, col.getSobNome());
			pstm.setString(9, String.valueOf(col.getGenero()));
			pstm.setString(10, col.getEnd());
			pstm.setString(11, String.valueOf(col.getVolunt()));
			pstm.setString(12, col.getDisp());
			pstm.setString(13, col.getCidade());
			pstm.setInt(14, col.getId());

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

	public List<Colaborador> getColaboradores() {

		String sql = "SELECT * FROM colaborador";

		List<Colaborador> colaboradores = new ArrayList<Colaborador>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Colaborador col = new Colaborador();
				
				col.setId(rset.getInt("id_col"));
				col.setCpfOrCnpj(rset.getString("cpf_cnpj_col"));
				col.setNome(rset.getString("nome_col"));
				col.setNasc(formatter.format(rset.getDate("dn_col")));
				col.setEmail(rset.getString("email_col"));
				col.setSenha(rset.getString("senha_col"));
				col.setUf(rset.getString("uf_col"));
				col.setSobNome(rset.getString("sn_col"));
				col.setGenero(rset.getString("sexo_col").charAt(0));
				col.setTel(rset.getString("tel_col"));
				col.setEnd(rset.getString("end_col"));
				col.setVolunt(rset.getString("vol").charAt(0));
				col.setDisp(rset.getString("dis_col"));
				col.setCidade(rset.getString("cid_col"));

				colaboradores.add(col);
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
		return colaboradores;
	}

	public Colaborador colById(int id) {

		String sql = "SELECT * FROM colaborador WHERE id_col=?";

		ResultSet rset = null;

		Colaborador col = new Colaborador();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			col.setId(rset.getInt("id_col"));
			col.setCpfOrCnpj(rset.getString("cpf_cnpj_col"));
			col.setNome(rset.getString("nome_col"));
			col.setNasc(formatter.format(rset.getDate("dn_col")));
			col.setEmail(rset.getString("email_col"));
			col.setSenha(rset.getString("senha_col"));
			col.setUf(rset.getString("uf_col"));
			col.setSobNome(rset.getString("sn_col"));
			col.setGenero(rset.getString("sexo_col").charAt(0));
			col.setTel(rset.getString("tel_col"));
			col.setEnd(rset.getString("end_col"));
			col.setVolunt(rset.getString("vol").charAt(0));
			col.setDisp(rset.getString("dis_col"));
			col.setCidade(rset.getString("cid_col"));

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
		return col;
	}
}