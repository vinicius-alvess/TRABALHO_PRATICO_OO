package SGR;

public class Proporcional extends Contribuicao {

	@Override
	public String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas) {
		float k = despesas.getValorTotal() / moradores.getRendimentoTotal();

		String resultado = "***** CONTRIBUICAO PROPORCIONAL *****" + "\n\n\n";

		resultado += "Valor total das despesas: " + "R$ " + despesas.getValorTotal() + "\n\n";

		for (int i = 0; i < moradores.getNumeroMoradores(); i++) {

			Morador morador = moradores.getMoradores().get(i);

			resultado += morador.getNome() + " - "

					+ arredondar((morador.getRendimento() / moradores.getRendimentoTotal()) * 100) + "%" + " - "

					+ "R$ " + arredondar(k * morador.getRendimento()) + "\n";
			
		}

		return resultado;
	}
}
