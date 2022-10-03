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
				System.out.println("Qual o nome do Projeto? ");
				pro.setNome(entrada.nextLine());

				System.out.println("Local onde sera realizado: ");
				pro.setLocal(entrada.nextLine());

				System.out.println("Qual o numero de contemplados? ");
				pro.setNumCont(entrada.nextInt());

				System.out.println("Qual a frequencia em que esse projeto ocorrera? ");
				pro.setFrequencia(entrada.nextLine());

				System.out.println("Descreva o projeto");
				pro.setDescricao(entrada.nextLine());

				System.out.println("Situacao do projetos?: (A/I)");
				pro.setSituacao(entrada.nextLine().charAt(0));

				pDAO.save(pro);

				ProjetoCRUD.main(args);
				break;
			case 2:
				System.out.println("Digite o CPF do cliente que sera deletado:");
				pDAO.removeBy(entrada.nextInt());
				ProjetoCRUD.main(args);
				break;
			case 3:
				System.out.println("Qual o nome do Projeto? ");
				pro.setNome(entrada.nextLine());

				System.out.println("Local onde sera realizado: ");
				pro.setLocal(entrada.nextLine());

				System.out.println("Qual o numero de contemplados? ");
				pro.setNumCont(entrada.nextInt());

				System.out.println("Qual a frequencia em que esse projeto ocorrera? ");
				pro.setFrequencia(entrada.nextLine());

				System.out.println("Descreva o projeto");
				pro.setDescricao(entrada.nextLine());

				System.out.println("Situacao do projetos?: (A/I)");
				pro.setSituacao(entrada.nextLine().charAt(0));

				pDAO.update(pro);
				ProjetoCRUD.main(args);
				break;

			case 4:
				System.out.println("===============================");
				for (Projeto p : pDAO.getProjetos()) {
					System.out.println("Nome: " + p.getNome());
					System.out.println("Local: " + p.getLocal());
					System.out.println("Qtd de Contemplados: " + p.getNumCont());
					System.out.println("Frequencia: " + p.getFrequencia());
					System.out.println("Situacao: " + p.getSituacao());
					System.out.println("Descricao: " + p.getDescricao());
					System.out.println("----------------------------------- ");
				}
				System.out.println("===============================");
				ProjetoCRUD.main(args);
				break;
			case 5:
				System.out.println("Digite o nome do Projeto:");

				String nome = entrada.next();

				Projeto p = pDAO.buscarProj(nome);
				System.out.println("Nome: " + p.getNome());
				System.out.println("Local: " + p.getLocal());
				System.out.println("Qtd de Contemplados: " + p.getNumCont());
				System.out.println("Frequencia: " + p.getFrequencia());
				System.out.println("Situacao: " + p.getSituacao());
				System.out.println("Descricao: " + p.getDescricao());
				System.out.println("----------------------------------- ");
				System.out.println("===============================");
				ProjetoCRUD.main(args);
				break;
			case 0:
				Semear.main(args);
				break;
			default:
				System.out.println("Opcao invalida!");
				ProjetoCRUD.main(args);
				break;

			}
			entrada.close();
			}

}
