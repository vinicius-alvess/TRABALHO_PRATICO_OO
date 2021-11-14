package app;

import SGR.CadastroMoradores;
import SGR.CadastroDespesas;
import SGR.Igualitaria;
import SGR.Proporcional;

import javax.swing.JOptionPane;

public class UI {

	static CadastroMoradores cadastroMoradores = new CadastroMoradores();
	static CadastroDespesas cadastroDespesas = new CadastroDespesas();
	static Igualitaria contIgual = new Igualitaria();
	static Proporcional contProp = new Proporcional();

	public static void main(String[] args) {

        ApresentarMenu();

    }

    private static int escolhaOpcao(){
		int opcao;
		String menu = "Sistema de Gerenciamento de Republica \n"
					+ "1 - Cadastrar Morador\n"
					+ "2 - Cadastrar Categoria\n"
					+ "3 - Cadastrar Subcategoria\n"
					+ "4 - Cadastrar Despesa\n"
					+ "5 - Calculo da Contribuicao\n"
					+ "6 - Apagar Republica\n"
					+ "0 - Sair do programa\n";
	   
		String Stropcao = JOptionPane.showInputDialog(menu);
		opcao = Integer.parseInt(Stropcao);
		return opcao;
	}

    private static void ApresentarMenu(){ 
        int opcao = 0;
		do { 
			opcao = escolhaOpcao();
			switch (opcao) {
			case 1:
				cadastroMoradores.lerMoradores(); //Ler arquivo com dados de moradores antes de efetuar novo cadastro
				cadastroMoradores.cadastrarMoradores();
				cadastroMoradores.escreve(); //Adicionando novo morador ao arquivo "aluno.txt"
				break;
			case 2: 
				cadastroDespesas.cadastrarCategoria();
				break;
			case 3:
				cadastroDespesas.cadastrarSubcategoria();
				break;
			case 4:
				cadastroDespesas.cadastrarDespesa();
				cadastroDespesas.escreve();
				break;
			case 5:
				ApresentarMenuContribuicao();
				break;
			case 6:
				cadastroMoradores.apagarRep(); // Apaga todos os dados de moradores da república
				break;
			case 0: 
				JOptionPane.showMessageDialog(null, " Obrigado por utilizar o programa! Volte Sempre!");
				break;
			default:
				JOptionPane.showMessageDialog(null, " Opcao Invalida!!");
				break;
			}
		} while (opcao != 0);
    }

	private static int escolhaOpcaoContribuicao() {
		int opcao;
		String menu = "------Contribuicao------\n"
					+ "1 - Contribuicao Igualitaria \n"
					+ "2 - Contribuicao Proporcional\n"
					+ "0 - Sair";
		String Stropcao = JOptionPane.showInputDialog(menu);
		opcao = Integer.parseInt(Stropcao);
		return opcao;
	}

	private static void ApresentarMenuContribuicao(){ 
        int opcao = 0, OpcMes =0, OpcAno=0;
		String dataMes = "------Mes------\n";
		String dataAno = "------Ano------\n";
		String StropcaoMes, StropcaoAno;

		do { 
			
			opcao = escolhaOpcaoContribuicao();
			
			switch (opcao) {
			case 1:
				StropcaoMes = JOptionPane.showInputDialog(dataMes);
				OpcMes = Integer.parseInt(StropcaoMes);
				StropcaoAno = JOptionPane.showInputDialog(dataAno);
				OpcAno = Integer.parseInt(StropcaoAno);
				cadastroMoradores.lerMoradores();
				cadastroDespesas.LimpaLista();
				cadastroDespesas.lerDespesas(OpcMes,OpcAno);
					
				JOptionPane.showMessageDialog(null,  contIgual.calcularContribuicao(cadastroMoradores, cadastroDespesas)); // Teste do metodo calcular contribuicao ** 
				break;
			case 2: 
				StropcaoMes = JOptionPane.showInputDialog(dataMes);
				OpcMes = Integer.parseInt(StropcaoMes);
				StropcaoAno = JOptionPane.showInputDialog(dataAno);
				OpcAno = Integer.parseInt(StropcaoAno);
				cadastroMoradores.lerMoradores();				
				cadastroDespesas.LimpaLista();
				cadastroDespesas.lerDespesas(OpcMes,OpcAno);
				JOptionPane.showMessageDialog(null,  contProp.calcularContribuicao(cadastroMoradores, cadastroDespesas));
				//cadastroDespesas.cadastrarCategoria();
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, " Opcao Invalida!!");
				break;
			}
		} while (opcao !=0);
    }

}

