package SGR;

import Exceptions.DadosPessoaisIncompletosException;
import Exceptions.RendimentoInvalidoException;

import java.util.LinkedList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;


import javax.swing.JOptionPane;

public class CadastroMoradores implements Impressora {

	private List<Morador> moradores;
	String nomeArquivo = "Moradores.txt";

	public CadastroMoradores() {
		// Usando o construtor para instanciar a lista encadeada
		// Foi a solucao que encontrei momentanemente
		moradores = new LinkedList<Morador>();
	}

	public void cadastrarMoradores() {
		boolean repetir = false;
		String nome = null, email = null, strRendimento;
		float rendimento = 0;
		
		do {
			try {
				repetir = false;
				
				nome = JOptionPane.showInputDialog("Nome: ");
				email = JOptionPane.showInputDialog("\n" + "Email: ");
				strRendimento = JOptionPane.showInputDialog("\n" + "Rendimento: ");

				if (!strRendimento.isEmpty()) {
					rendimento = Float.parseFloat(strRendimento);
				}

				if (nome.isEmpty() || email.isEmpty() || strRendimento.isEmpty()) {
					throw new DadosPessoaisIncompletosException();
				} else if (rendimento < 0) {
					throw new RendimentoInvalidoException();
				}

			} catch (DadosPessoaisIncompletosException e) {
				repetir = true;
				JOptionPane.showMessageDialog(null, "ERRO! Por favor preencha todos os campos");
			} catch (RendimentoInvalidoException e) {
				do {
					JOptionPane.showMessageDialog(null, "ERRO! Nao e possivel um rendimento negativo ou vazio!");
					strRendimento = JOptionPane.showInputDialog("\n" + "Rendimento: ");
					if (!strRendimento.isEmpty()) {
						rendimento = Float.parseFloat(strRendimento);
					}
				} while (rendimento < 0 || strRendimento.isEmpty());
				repetir = false;
			}
		} while (repetir);

		// Instanciando Morador
		Morador morador = new Morador(nome, email, rendimento);

		moradores.add(morador); // adicionado o novo morador
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	private float rendimentoTotal() {

		float rendimentoTotal = 0;

		for (Morador m : moradores) {
			rendimentoTotal += m.getRendimento();
		}
		return rendimentoTotal;
	}

	public float getRendimentoTotal() {
		return rendimentoTotal();
	}

	public int getNumeroMoradores() {
		return this.moradores.size();
	}

	// Gravando moradores em arquivo "Moradores.txt"
	@Override
	public void escreve() {

		BufferedWriter buffer = null;
		FileWriter out = null;

		try {
			out = new FileWriter(nomeArquivo);
			buffer = new BufferedWriter(out);

			for (Morador a : moradores) {
				buffer.write(a.getNome().toString());
				buffer.write(';');
				buffer.write(a.getEmail().toString());
				buffer.write(';');
				String r = Float.toString(a.getRendimento());
				buffer.write(r.toString());
				buffer.write('\n');
			}

			buffer.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}
	
	//Lê arquivo com dados de moradores (Persistir dados)
	public void lerMoradores() {
        FileInputStream in = null;  //objeto que "lida" com o arquivo de entrada

        try {

            in = new FileInputStream(nomeArquivo); //tenta abrir o arquivo em modo leitura
            moradores.clear(); //Limpa buffer para evitar duplo cadastro no arquivo

            byte[] conteudoArquivo = in.readAllBytes();
            //Transformar o vetor em uma String!

            String cadastro = "";
            for (int i=0; i<conteudoArquivo.length; i++) {
                cadastro += (char)conteudoArquivo[i];
            }

            String[] strMoradores = cadastro.split("\n");
            for (String par : strMoradores) {
                String[] str = par.split(";");
                float f = Float.parseFloat(str[2]);
                Morador a = new Morador(str[0], str[1],f);
                moradores.add(a);
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
	
	
	
	public void apagarRep(){
       		File file = new File( nomeArquivo );
        	file.delete();
    }

}

