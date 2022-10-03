package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Instituicao;
import model.Relatorio;

public class RelatorioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Relatorio rel) {

		String sql = "INSERT INTO relatorio (ano_rel, mes_rel, projetos, mat_use_rel, valor_rel, num_cont_rel, qtd_vol, id_ins)"
				+ " VALUE(?,?,?,?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, rel.getAno());
			pstm.setInt(2, rel.getMes());
			pstm.setString(3, rel.getProjetos());
			pstm.setString(4, rel.getMatUsado());
			pstm.setDouble(5, rel.getValor());
			pstm.setInt(6, rel.getNumCont());
			pstm.setInt(7, rel.getQdeVol());
			pstm.setInt(8, rel.getInstituicao().getId());

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

		String sql = "DELETE FROM relatorio WHERE id_rel=?";

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

	public void update(Relatorio rel) {

		String sql = "update cliente SET ano_rel = ?, mes_rel = ?, projetos = ?, mat_use_rel = ?, valor_rel = ?, num_cont_rel = ?, qtd_vol = ?, id_ins = ? where id_rel = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, rel.getAno());
			pstm.setInt(2, rel.getMes());
			pstm.setString(3, rel.getProjetos());
			pstm.setString(4, rel.getMatUsado());
			pstm.setDouble(5, rel.getValor());
			pstm.setInt(6, rel.getNumCont());
			pstm.setInt(7, rel.getQdeVol());
			pstm.setInt(8, rel.getInstituicao().getId());
			pstm.setInt(9, rel.getId());

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

	public List<Relatorio> getRelatorios() {

		String sql = "SELECT * FROM relatorio";

		List<Relatorio> relatorios = new ArrayList<Relatorio>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Relatorio rel = new Relatorio();
				Instituicao ins = new Instituicao();

				rel.setId(rset.getInt("id_rel"));
				rel.setAno(rset.getInt("ano_rel"));
				rel.setMes(rset.getInt("mes_rel"));
				rel.setProjetos(rset.getString("projetos"));
				rel.setMatUsado(rset.getString("mat_use_rel"));
				rel.setValor(rset.getDouble("valor_rel"));
				rel.setNumCont(rset.getInt("num_cont_rel"));
				rel.setQdeVol(rset.getInt("qtd_vol"));
				ins.setId(rset.getInt("id_ins"));
				rel.setInstituicao(ins);

				relatorios.add(rel);
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
		return relatorios;
	}

	public Relatorio relById(int id) {

		String sql = "SELECT * FROM relatorio WHERE id_rel=?";

		ResultSet rset = null;

		Relatorio rel = new Relatorio();
		Instituicao ins = new Instituicao();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			rel.setId(rset.getInt("id_rel"));
			rel.setAno(rset.getInt("ano_rel"));
			rel.setMes(rset.getInt("mes_rel"));
			rel.setProjetos(rset.getString("projetos"));
			rel.setMatUsado(rset.getString("mat_use_rel"));
			rel.setValor(rset.getDouble("valor_rel"));
			rel.setNumCont(rset.getInt("num_cont_rel"));
			rel.setQdeVol(rset.getInt("qtd_vol"));
			ins.setId(rset.getInt("id_ins"));
			rel.setInstituicao(ins);

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
		return rel ;
	}
}