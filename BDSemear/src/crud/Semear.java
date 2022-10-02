package crud;

import java.util.Scanner;

public class Semear {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int menu;

		System.out.println("========== MENU ==========");
		System.out.println("1 - Colaborador");
		System.out.println("2 - Instituição");
		System.out.println("0 - Sair");

		menu = entrada.nextInt();
		switch (menu) {
		case 1:
			ColaboradorCRUD.Colaborador(args);
			break;
		case 2:
			InstituicaoCRUD.Instituicao(args);
			break;
		case 0:
			System.out.println("Ate logo!");
			break;
		default:
			System.out.println("Opcao invalida!");
			Semear.main(args);
			
		}
	}

}
