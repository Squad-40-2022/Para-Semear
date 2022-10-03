package crud;

		import java.util.Scanner;

		import controller.InstituicaoDAO;
		import controller.DoacaoDAO;
		import controller.ColaboradorDAO;
		import model.Instituicao;
		import model.Colaborador;
		import model.Doacao;

		public class DoacaoCRUD {

			public static void main(String[] args) {
				Scanner entrada = new Scanner(System.in);
				DoacaoDAO dDAO = new DoacaoDAO();
				InstituicaoDAO iDAO = new InstituicaoDAO();
				ColaboradorDAO cDAO = new ColaboradorDAO();

				Doacao doa = new Doacao();

				int menu;

				System.out.println("========== PROJETO ==========");
				System.out.println("1 - Nova Doacao");
				System.out.println("2 - Listar Doacoes");
				System.out.println("3 - Buscar Doacao");
				System.out.println("0 - Voltar");
				menu = entrada.nextInt();
				entrada.nextLine();
				switch (menu) {
				case 1:
					System.out.println("Digite o ID da instituicao:");
					Instituicao ins = iDAO.insById(entrada.nextInt());
					doa.setInstituicao(ins);
					entrada.nextLine();
					
					System.out.println("Digite o ID do colaborador:");
					Colaborador col = cDAO.colByCpf(entrada.next());
					doa.setColaborador(col);
					entrada.nextLine();
					
					System.out.println("Tipo: ");
					doa.setTipo(entrada.nextLine());

					System.out.println("data: ");
					doa.setData(entrada.nextLine());

					System.out.println("Quantia: ");
					doa.setQuantMat(entrada.nextInt());
					
					System.out.println("Descriçao");
					doa.setDescricao(entrada.nextLine());
					
					System.out.println("anexe o comprovante");
					doa.setDocComp(entrada.nextLine());

					System.out.println("Anonimo?: (S/N)");
					doa.setAnonimo(entrada.nextLine().charAt(0));

					dDAO.save(doa);

					DoacaoCRUD.main(args);
					break;
				case 2:
				System.out.println("===============================");
					for (Doacao d : dDAO.getDoacoes()) {
						System.out.println("Doador: " + d.getColaborador().getNome());
						System.out.println("Instituicao: " + d.getInstituicao().getNomeFant());
						System.out.println("tipo: " + d.getTipo());
						System.out.println("quantia: " + d.getQuantMat());
						System.out.println("Descricao: " + d.getDescricao());
						System.out.println("----------------------------------- ");
					}
					System.out.println("===============================");
					DoacaoCRUD.main(args);
					break;
				case 5:
					System.out.println("Digite o ID da Doacao:");

					int id = entrada.nextInt();

					Doacao d = dDAO.doaById(id);
					System.out.println("Doador: " + d.getColaborador().getNome());
					System.out.println("Instituicao: " + d.getInstituicao().getNomeFant());
					System.out.println("tipo: " + d.getTipo());
					System.out.println("quantia: " + d.getQuantMat());
					System.out.println("Descricao: " + d.getDescricao());
					System.out.println("----------------------------------- ");
					System.out.println("===============================");
					ProjetoCRUD.main(args);
					break;
				case 0:
					Semear.main(args);
					break;
				default:
					System.out.println("Opcao invalida!");
					DoacaoCRUD.main(args);
					break;

				}
				entrada.close();
			}

		}

