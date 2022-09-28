package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Cliente;
import model.Colaborador;
import model.Local;

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

	public List<Cliente> getClientes() {

		String sql = "SELECT * FROM colaborador";

		List<Cliente> clientes = new ArrayList<Cliente>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Cliente cli = new Cliente();
				Local local = new Local();
				
				cli.setId(rset.getInt("id_cli"));
				cli.setCpf(rset.getString("cpf_cli"));
				cli.setNome(rset.getString("nome_cli"));
				cli.setTel(rset.getString("tel_cli"));
				cli.setSenha(rset.getString("senha"));
				cli.setEmail(rset.getString("email"));
				cli.setEnde(rset.getString("logradouro"));
				cli.setNasc(formatter.format(rset.getDate("data_nasc")));
				
				local.setId(rset.getInt("id_local"));
				local.setCidade(rset.getString("cidade"));
				local.setUf(rset.getString("uf"));
				cli.setLocal(local);

				clientes.add(cli);
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
		return clientes;
	}

	public Cliente cliById(int id) {

		String sql = "SELECT * FROM colaborador WHERE id_cli=?";

		ResultSet rset = null;

		Cliente cli = new Cliente();
		Local local = new Local();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			cli.setId(rset.getInt("id_cli"));
			cli.setCpf(rset.getString("cpf_cli"));
			cli.setNome(rset.getString("nome_cli"));
			cli.setTel(rset.getString("tel_cli"));
			cli.setSenha(rset.getString("senha"));
			cli.setEmail(rset.getString("email"));
			cli.setEnde(rset.getString("logradouro"));
			cli.setNasc(formatter.format(rset.getDate("data_nasc")));
			
			local.setId(rset.getInt("id_local"));
			local.setCidade(rset.getString("cidade"));
			local.setUf(rset.getString("uf"));
			cli.setLocal(local);

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
		return cli;
	}
}