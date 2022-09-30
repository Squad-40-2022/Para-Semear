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
import model.Doacao;
import model.Instituicao;

public class DoacaoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void save(Doacao doa) {

		String sql = "INSERT INTO DOACAO(id_doa, tipo_doa, desc_doa, qt_doa, com_doa, data_doa, anonimo, id_col, id_ins)"
				+ " VALUE(?,?,?,?,?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, doa.getId());
			pstm.setString(2, doa.getTipo());
			pstm.setString(3, doa.getDescricao());
			pstm.setDouble(4, doa.getQuantMat());
			pstm.setString(5, doa.getDocComp());
			pstm.setDate(6, new Date(formatter.parse(doa.getData()).getTime()));
			pstm.setString(7, String.valueOf(doa.getAnonimo()));
			pstm.setInt(8, doa.getColaborador().getId());
			pstm.setInt(9, doa.getInstituicao().getId());

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

		String sql = "DELETE FROM doacao WHERE id_doa=?";

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

	public void update(Doacao doa) {

		String sql = "update doacao SET tipo_doa=?  desc_doa=?  qt_doa=?  com_doa=?  data_doa=?  anonimo=?  id_col=?  id_ins=?  where id_doa = ?";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, doa.getTipo());
			pstm.setString(2, doa.getDescricao());
			pstm.setDouble(3, doa.getQuantMat());
			pstm.setString(4, doa.getDocComp());
			pstm.setDate(5, new Date(formatter.parse(doa.getData()).getTime()));
			pstm.setString(6, String.valueOf(doa.getAnonimo()));
			pstm.setInt(7, doa.getColaborador().getId());
			pstm.setInt(8, doa.getInstituicao().getId());
			pstm.setInt(9, doa.getId());

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

	public List<Doacao> getDoacoes() {

		String sql = "SELECT * FROM doacao_instituicoes_colaboradores";

		List<Doacao> doacoes = new ArrayList<Doacao>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Colaborador col = new Colaborador();
				Instituicao ins = new Instituicao();
				Doacao doa = new Doacao();

				doa.setId(rset.getInt("id_doa"));
				doa.setTipo(rset.getString("tipo_doa"));
				doa.setDescricao(rset.getString("desc_doa"));
				doa.setDocComp(rset.getString("com_doa"));
				doa.setData(formatter.format(rset.getDate("data_doa")));
				doa.setQuantMat(rset.getInt("qt_doa"));
				doa.setAnonimo(rset.getString("anonimo").charAt(0));

				ins.setId(rset.getInt("id_ins"));
				col.setId(rset.getInt("id_col"));
				col.setNome(rset.getString("nome_col"));
				doa.setInstituicao(ins);
				doa.setColaborador(col);

				doacoes.add(doa);
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
		return doacoes;
	}

	public Doacao doaById(int id) {

		String sql = "SELECT * FROM doacao_colaboradores_instituicoes WHERE id_doa=?";

		ResultSet rset = null;

		Colaborador col = new Colaborador();
		Instituicao ins = new Instituicao();
		Doacao doa = new Doacao();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			doa.setId(rset.getInt("id_doa"));
			doa.setTipo(rset.getString("tipo_doa"));
			doa.setDescricao(rset.getString("desc_doa"));
			doa.setDocComp(rset.getString("com_doa"));
			doa.setData(formatter.format(rset.getDate("data_doa")));
			doa.setQuantMat(rset.getInt("qt_doa"));
			doa.setAnonimo(rset.getString("anonimo").charAt(0));

			ins.setId(rset.getInt("id_ins"));
			col.setId(rset.getInt("id_col"));
			col.setNome(rset.getString("nome_col"));
			doa.setInstituicao(ins);
			doa.setColaborador(col);

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
		return doa;
	}
}