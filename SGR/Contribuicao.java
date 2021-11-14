package SGR;


import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Contribuicao {
	

	protected abstract String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas);

	protected static String arredondar(double numero) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(numero);
	}

}
