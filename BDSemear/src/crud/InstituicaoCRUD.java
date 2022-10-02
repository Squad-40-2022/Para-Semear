package crud;

import java.util.Scanner;

import controller.InstituicaoDAO;
import model.Colaborador;
import model.Instituicao;

public class InstituicaoCRUD {

	public static void Instituicao(String[] args) {
		Scanner entrada = new Scanner(System.in);
		InstituicaoDAO instituicaoDAO = new InstituicaoDAO();

		Instituicao ins = new Instituicao();

		int menu;

		System.out.println("========== CLIENTE ==========");
		System.out.println("1 - Cadastrar instituição");
		System.out.println("2 - Remover instituição");
		System.out.println("3 - Atualizar instituição");
		System.out.println("4 - Mostrar instituição");
		System.out.println("5 - Buscar instituição por ID");
		System.out.println("0 - Voltar");
		menu = entrada.nextInt();
		entrada.nextLine();
		switch (menu) {
		case 1:
			System.out.println("Digite o CNPJ:(xx.xxx.xxx/xxxx-xx)");
			ins.setCnpj(entrada.nextLine());

			System.out.println("Digite a Razão Social:");
			ins.setRazSocial(entrada.nextLine());

			System.out.println("Digite o Nome Fantasia:");
			ins.setNomeFant(entrada.nextLine());
			
			System.out.println("Digite o nome do responsável:");
			ins.setNomeResp(entrada.nextLine());
						
			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			ins.setTel(entrada.nextLine());

			System.out.println("Digite o endereço:");
			ins.setEnd(entrada.nextLine());
			
			System.out.println("Digite o Cidade:");
			ins.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			ins.setUf(entrada.nextLine());
			
			System.out.println("Digite o email:");
			ins.setEmail(entrada.nextLine());

			System.out.println("Digite a senha:");
			ins.setSenha(entrada.nextLine());
			
			System.out.println("Ensira os documentos da instituição");
			ins.setDoc(entrada.nextLine());

			instituicaoDAO.save(ins);

			InstituicaoCRUD.Instituicao(args);
			break;
		case 2:
			System.out.println("Digite o CPF do cliente que sera deletado:");
			instituicaoDAO.removeBy(entrada.nextInt());
			ColaboradorCRUD.Colaborador(args);
			break;
		case 3:
			System.out.println("Digite o CNPJ:(xx.xxx.xxx/xxxx-xx)");
			ins.setCnpj(entrada.nextLine());

			System.out.println("Digite a Razão Social:");
			ins.setRazSocial(entrada.nextLine());

			System.out.println("Digite o Nome Fantasia:");
			ins.setNomeFant(entrada.nextLine());
			
			System.out.println("Digite o nome do responsável:");
			ins.setNomeResp(entrada.nextLine());
						
			System.out.println("Digite o telefone:((DDD) xxxxx-xxxx)");
			ins.setTel(entrada.nextLine());

			System.out.println("Digite o endereço:");
			ins.setEnd(entrada.nextLine());
			
			System.out.println("Digite o Cidade:");
			ins.setCidade(entrada.nextLine());

			System.out.println("Digite o UF:");
			ins.setUf(entrada.nextLine());
			
			System.out.println("Digite o email:");
			ins.setEmail(entrada.nextLine());

			System.out.println("Digite a senha:");
			ins.setSenha(entrada.nextLine());
			
			System.out.println("Ensira os documentos da instituição");
			ins.setDoc(entrada.nextLine());

			instituicaoDAO.update(ins);
			InstituicaoCRUD.Instituicao(args);
			break;

		case 4:
			System.out.println("===============================");
			for (Instituicao i : instituicaoDAO.getInstituicoes()) {
				System.out.println("Instituição: " + i.getNomeFant());
				System.out.println("CNPJ: " + i.getCnpj());
				System.out.println("Responsavel: " + i.getNomeResp());
				System.out.println("Telefone: " + i.getTel());
				System.out.println("Endereço: " + i.getEnd() + "  - Cidade: " +i.getCidade()+ " - UF: " + i.getUf());
				System.out.println("Email: " + i.getEmail());
				System.out.println("----------------------------------- ");
			}
			System.out.println("===============================");
			ColaboradorCRUD.Colaborador(args);
			break;
		case 5:
			System.out.println("Digite o CPF do colaborador:");
			
			Integer id = entrada.nextInt();

			Instituicao i = instituicaoDAO.insById(id);
			System.out.println("Instituição: " + i.getNomeFant());
			System.out.println("CNPJ: " + i.getCnpj());
			System.out.println("Responsavel: " + i.getNomeResp());
			System.out.println("Telefone: " + i.getTel());
			System.out.println("Endereço: " + i.getEnd() + "  - Cidade: " +i.getCidade()+ " - UF: " + i.getUf());
			System.out.println("Email: " + i.getEmail());
			System.out.println("----------------------------------- ");
		}
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

}
