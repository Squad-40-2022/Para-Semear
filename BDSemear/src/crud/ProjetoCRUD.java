import java.util.Scanner;

import controller.ProjetoDAO;
import model.Projeto;

public class ProjetoCRUD {
		public static void main(String[]args) {
			Scanner entrada = new Scanner(System.in);
			ProjetoDAO pDAO = new ProjetoDAO();

			Projeto pro = new Projeto();

			int menu;

			System.out.println("========== CLIENTE ==========");
			System.out.println("1 - Cadastrar novo projeto");
			System.out.println("2 - Remover projeto");
			System.out.println("3 - Atualizar projeto");
			System.out.println("4 - Mostrar todos os projetos");
			System.out.println("5 - Buscar projeto por nome");
			//System.out.println("6 - Buscar projeto por data");
			//System.out.println("7 - Buscar projeto por situação");
			//System.out.println("8 - Buscar projeto por frequência");
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
				System.out.println("Digite o CPF do cliente que sera deletado:");
				colaboradorDAO.removeBy(entrada.nextInt());
				ColaboradorCRUD.Colaborador(args);
				break;
			case 3:
				System.out.println("Digite o CPF:(xxx.xxx.xxx-xx)");
				col.setCpfOrCnpj(entrada.nextLine());

				System.out.println("Digite o nome:");
				col.setNome(entrada.nextLine());

				System.out.println("Digite o Sobrenome");
				col.setSobNome(entrada.nextLine());

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

}

}
