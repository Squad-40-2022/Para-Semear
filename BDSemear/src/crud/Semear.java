package crud;

import java.util.Scanner;

public class Semear {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int menu;

		System.out.println("========== MENU ==========");
		System.out.println("1 - Colaborador");
		System.out.println("2 - Instituicao");
		System.out.println("3 - Projetos");
		System.out.println("4 - Relatorio");
		System.out.println("5 - Doacao");
		System.out.println("0 - Sair");

		menu = entrada.nextInt();
		switch (menu) {
		case 1:
			ColaboradorCRUD.Colaborador(args);
			break;
		case 2:
			InstituicaoCRUD.Instituicao(args);
			break;
		case 3:
			ProjetoCRUD.main(args);
			break;
		case 4:
			RelatorioCRUD.main(args);
			break;
		case 5:
			DoacaoCRUD.main(args);
			break;
		case 0:
			System.out.println("Ate logo!");
			break;
		default:
			System.out.println("Opcao invalida!");
			Semear.main(args);
			
		}
		entrada.close();
	}
}
