package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Instituicao;
import model.Projeto;

public class ProjetoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void save(Projeto pro) {

		String sql = "INSERT INTO projetos (nome_proj, local_proj, num_cont_proj, sit_proj, freq_proj, desc_proj, id_ins)" + " VALUE(?,?,?,?,?,?,?)";

		try {
			
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pro.getNome());
			pstm.setString(2, pro.getLocal());
			pstm.setInt(3, pro.getNumCont());
			pstm.setString(4, String.valueOf(pro.getSituacao()));
			pstm.setString(5, pro.getFrequencia());
			pstm.setString(6, pro.getDescricao());
			pstm.setInt(7, pro.getInstituicao().getId());

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

		String sql = "DELETE FROM projetos WHERE id_pro=?";

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
	
	public void update(Projeto pro) {

		String sql = "update projetos SET nome_proj = ?, local_proj = ?, num_cont_proj = ?, sit_proj = ?, freq_proj = ?, desc_proj = ?, id_ins = ? where id_pro = ?";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pro.getNome());
			pstm.setString(2, pro.getLocal());
			pstm.setInt(3, pro.getNumCont());
			pstm.setString(4, String.valueOf(pro.getSituacao()));
			pstm.setString(5, pro.getFrequencia());
			pstm.setString(6, pro.getDescricao());
			pstm.setInt(7, pro.getInstituicao().getId());
			pstm.setInt(8, pro.getId());

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

	public List<Projeto> getProjetos() {

		String sql = "SELECT * FROM projetos";

		List<Projeto> projetos = new ArrayList<Projeto>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Projeto pro = new Projeto();
				Instituicao ins = new Instituicao();
				
				pro.setId(rset.getInt("id_pro"));
				pro.setNumCont(rset.getInt("num_cont_proj"));
				pro.setNome(rset.getString("nome_proj"));
				pro.setLocal(rset.getString("local_proj"));
				pro.setFrequencia(rset.getString("freq_proj"));
				pro.setDescricao(rset.getString("desc_proj"));
				pro.setSituacao(rset.getString("sit_proj").charAt(0));

				ins.setId((rset.getInt("id_ins")));
				pro.setInstituicao(ins);

				projetos.add(pro);
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
		return projetos;
	}

	public Projeto proById(int id) {

		String sql = "SELECT * FROM projetos WHERE id_pro=?";

		ResultSet rset = null;

		Projeto pro = new Projeto();
		Instituicao ins = new Instituicao();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			pro.setId(rset.getInt("id_pro"));
			pro.setNumCont(rset.getInt("num_cont_proj"));
			pro.setNome(rset.getString("nome_proj"));
			pro.setLocal(rset.getString("local_proj"));
			pro.setFrequencia(rset.getString("freq_proj"));
			pro.setDescricao(rset.getString("desc_proj"));
			pro.setSituacao(rset.getString("sit_proj").charAt(0));

			ins.setId((rset.getInt("id_ins")));
			pro.setInstituicao(ins);

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
		return pro;
	}
}