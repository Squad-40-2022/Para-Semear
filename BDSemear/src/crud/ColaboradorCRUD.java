package crud;

import java.util.Scanner;

import controller.ColaboradorDAO;
import model.Colaborador;

public class ColaboradorCRUD {

	public static void Colaborador(String[] args) {
		Scanner entrada = new Scanner(System.in);
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

		Colaborador col = new Colaborador();

		int menu;

		System.out.println("========== COLABORADOR ==========");
		System.out.println("1 - Cadastrar colaborador");
		System.out.println("2 - Remover colaborador");
		System.out.println("3 - Atualizar colaborador");
		System.out.println("4 - Mostrar colaboradores");
		System.out.println("5 - Buscar colaborador por CPF");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o CPF:(xxx.xxx.xxx-xx)");
			col.setCpfOrCnpj(entrada.nextLine());

			System.out.println("Digite o nome:");
			col.setNome(entrada.nextLine());

			System.out.println("Digite o Sobrenome");
			col.setSobNome(entrada.nextLine());
			
			System.out.println("Digite a data de nascimento:(dd/mm/aaaa)");
			col.setNasc(entrada.nextLine());	

			System.out.println("Digite o genero: (F/M/O(Outros))");
			col.setGenero(entrada.nextLine().charAt(0));

			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			col.setTel(entrada.nextLine());

			System.out.println("Digite o endereço:");
			col.setEnd(entrada.nextLine());

			System.out.println("Digite o Cidade:");
			col.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			col.setUf(entrada.nextLine());

			System.out.println(
					"Deseja ser contatado pelas instituições quando forem necessarios voluntarios em projetos?: (S/N)");
			col.setVolunt(entrada.nextLine().charAt(0));

			System.out.println("Qual sua disponibilidade para voluntariado?");
			System.out.println("*marque 1 ou mais opções");
			col.setCidade(entrada.nextLine());

			System.out.println("Digite o email:");
			col.setEmail(entrada.nextLine());

			System.out.println("Digite a senha:");
			col.setSenha(entrada.nextLine());

			colaboradorDAO.save(col);

			ColaboradorCRUD.Colaborador(args);
			break;
		case 2:
			System.out.println("Digite o ID do cliente que sera deletado:");
			colaboradorDAO.removeBy(entrada.nextInt());
			ColaboradorCRUD.Colaborador(args);
			break;
		case 3:
			System.out.println("Digite o ID do cliente:");
			col.setId(entrada.nextInt());
			entrada.nextLine();
			
			System.out.println("Digite o CPF:(xxx.xxx.xxx-xx)");
			col.setCpfOrCnpj(entrada.nextLine());

			System.out.println("Digite o nome:");
			col.setNome(entrada.nextLine());

			System.out.println("Digite o Sobrenome");
			col.setSobNome(entrada.nextLine());
			
			System.out.println("Digite a data de nascimento:(dd/mm/aaaa)");
			col.setNasc(entrada.nextLine());	

			System.out.println("Digite o genero: (F/M/O(Outros))");
			col.setGenero(entrada.nextLine().charAt(0));

			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			col.setTel(entrada.nextLine());

			System.out.println("Digite o endereço:");
			col.setEnd(entrada.nextLine());

			System.out.println("Digite o Cidade:");
			col.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			col.setUf(entrada.nextLine());

			System.out.println(
					"Deseja ser contatado pelas instituições quando forem necessarios voluntarios em projetos?: (S/N)");
			col.setVolunt(entrada.nextLine().charAt(0));

			System.out.println("Qual sua disponibilidade para voluntariado?");
			System.out.println("*marque 1 ou mais opções");
			col.setCidade(entrada.nextLine());

			System.out.println("Digite o email:");
			col.setEmail(entrada.nextLine());

			System.out.println("Digite a senha:");
			col.setSenha(entrada.nextLine());

			colaboradorDAO.update(col);
			ColaboradorCRUD.Colaborador(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Colaborador c : colaboradorDAO.getColaboradores()) {
				System.out.println("Colaborador: " + c.getNome() + " " + c.getSobNome());
				System.out.println("CPF: " + c.getCpfOrCnpj() + "        Data de Nascimento: " + c.getNasc());
				System.out.println("Genero: " + c.getGenero());
				System.out.println("Telefone: " + c.getTel());
				System.out.println("Endereço: " + c.getEnd() + "  - Cidade: " + c.getCidade() + " - UF: " + c.getUf());
				System.out.println("Email: " + c.getEmail());
				System.out.println("Disponibilidade: " + c.getDisp());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			ColaboradorCRUD.Colaborador(args);
			break;
		case 5:
			System.out.println("Digite o CPF do colaborador:");

			String cpf = entrada.next();

			Colaborador c = colaboradorDAO.colByCpf(cpf);
			System.out.println("Colaborador: " + c.getNome() + " " + c.getSobNome());
			System.out.println("CPF: " + c.getCpfOrCnpj() + "        Data de Nascimento: " + c.getNasc());
			System.out.println("Genero: " + c.getGenero());
			System.out.println("Telefone: " + c.getTel());
			System.out.println("Endereço: " + c.getEnd() + "  - Cidade: " + c.getCidade() + " - UF: " + c.getUf());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Disponibilidade: " + c.getDisp());
			System.out.println("----------------------------------- ");
			System.out.println("===============================");
			ColaboradorCRUD.Colaborador(args);
			break;
		case 0:
			Semear.main(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			ColaboradorCRUD.Colaborador(args);
			break;

		}
		entrada.close();
	}
}
