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
import model.Local;

public class InstituicaoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void save(Cliente cliente) {

		String sql = "INSERT INTO cliente(cpf_cli, nome_cli, data_nasc, tel_cli, email, senha, logradouro, id_local)" + " VALUE(?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setDate(3, new Date(formatter.parse(cliente.getNasc()).getTime()));
			pstm.setString(4, cliente.getTel());
			pstm.setString(5, cliente.getEmail());
			pstm.setString(6, cliente.getSenha());
			pstm.setString(7, cliente.getEnde());
			pstm.setInt(8, cliente.getLocal().getId());

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

		String sql = "DELETE FROM cliente WHERE id_cli=?";

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
	
	public void update(Cliente cliente) {

		String sql = "update cliente SET cpf_cli = ?,nome_cli = ?, data_nasc = ?, tel_cli = ?, email = ?, senha = ?, logradouro = ?, id_local = ? where id_cli = ?";
		
		try {
			
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setDate(3, new Date(formatter.parse(cliente.getNasc()).getTime()));
			pstm.setString(4, cliente.getTel());
			pstm.setString(5, cliente.getEmail());
			pstm.setString(6, cliente.getSenha());
			pstm.setString(7, cliente.getEnde());
			pstm.setInt(8, cliente.getLocal().getId());
			pstm.setInt(9, cliente.getId());

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

		String sql = "SELECT * FROM cliente_local";

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

		String sql = "SELECT * FROM cliente_local WHERE id_cli=?";

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