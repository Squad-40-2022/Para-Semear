package crud;

import java.util.Scanner;

import controller.RelatorioDAO;
import model.Relatorio;

public class RelatorioCRUD {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		RelatorioDAO rDAO = new RelatorioDAO();

		Relatorio re = new Relatorio();

		int menu;

		System.out.println("========== CLIENTE ==========");
		System.out.println("1 - Cadastrar novo relatorio");
		System.out.println("2 - Remover relatorio");
		System.out.println("3 - Atualizar relatorio");
		System.out.println("4 - Mostrar todos os relatorios");
		System.out.println("5 - Buscar relatorio por mes");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Mes de refencia: ");
			re.setMes(entrada.nextInt());

			System.out.println("Ano: ");
			re.setAno(entrada.nextInt());

			System.out.println("Qual o numero de contemplados? ");
			re.setNumCont(entrada.nextInt());

			System.out.println("Qual o numero de voluntarios? ");
			re.setQdeVol(entrada.nextInt());

			System.out.println("Projetos abrangidos:");
			re.setProjetos(entrada.nextLine());

			System.out.println("Materiais usados:");
			re.setMatUsado(entrada.nextLine());
			
			System.out.println("Valor utilizado: R$ ");
			re.setValor(entrada.nextDouble());

			rDAO.save(re);

			RelatorioCRUD.main(args);
			break;
		case 2:
			System.out.println("Digite o mes e o ano do relatorio deletado:");
			rDAO.removeBy(entrada.nextInt(),entrada.nextInt());
			RelatorioCRUD.main(args);
			break;
		case 3:
			System.out.println("Mes de refencia: ");
			re.setMes(entrada.nextInt());

			System.out.println("Ano: ");
			re.setAno(entrada.nextInt());

			System.out.println("Qual o numero de contemplados? ");
			re.setNumCont(entrada.nextInt());

			System.out.println("Qual o numero de voluntarios? ");
			re.setQdeVol(entrada.nextInt());

			System.out.println("Projetos abrangidos:");
			re.setProjetos(entrada.nextLine());

			System.out.println("Materiais usados:");
			re.setMatUsado(entrada.nextLine());
			
			System.out.println("Valor utilizado: R$ ");
			re.setValor(entrada.nextDouble());

			rDAO.update(re);
			RelatorioCRUD.main(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Relatorio r : rDAO.getRelatorios()) {
				System.out.println(r.getMes()+" / "+r.getAno());
				System.out.println("Qtd Contemplados: " + r.getNumCont());
				System.out.println("Qtd Voluntarios: " + r.getQdeVol());
				System.out.println("Projetos: " + r.getProjetos());
				System.out.println("Situacao: " + r.getMatUsado());
				System.out.println("Valor utilizado: R$ " + r.getValor());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			RelatorioCRUD.main(args);
			break;
		case 5:
			System.out.println("Digite o mes e ano que deseja buscar:");

			int mes = entrada.nextInt();
			int ano = entrada.nextInt();

			Relatorio r = rDAO.relMesAno(mes,ano);
			System.out.println(r.getMes()+" / "+r.getAno());
			System.out.println("Qtd Contemplados: " + r.getNumCont());
			System.out.println("Qtd Voluntarios: " + r.getQdeVol());
			System.out.println("Projetos: " + r.getProjetos());
			System.out.println("Situacao: " + r.getMatUsado());
			System.out.println("Valor utilizado: R$ " + r.getValor());
			System.out.println("----------------------------------- ");
			System.out.println("===============================");
			ProjetoCRUD.main(args);
			break;
		case 0:
			InstituicaoCRUD.Instituicao(args);
			break;
		default:
			System.out.println("Opcao invalida!");
			RelatorioCRUD.main(args);
			break;

		}
		entrada.close();
	}

}
