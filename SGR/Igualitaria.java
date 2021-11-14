package SGR;

public class Igualitaria extends Contribuicao{

    @Override
    public String calcularContribuicao(CadastroMoradores moradores, CadastroDespesas despesas){ 
        float valorTotal = despesas.getValorTotal();
        float numMoradores = moradores.getNumeroMoradores();
        
        String msg = "***** CONTRIBUICAO IGUALITARIA *****" + "\n\n\n";
        
        msg += "Valor total das despesas: " + "R$ " + valorTotal + "\n\n";
        
        msg += "Contribuicao por morador" + "\n";
        
        msg += "Porcentagem: " + arredondar(100/numMoradores) + "%" + "\n";
        
        msg += "Valor: " + "R$ " + arredondar(((1/numMoradores)*valorTotal));        

        return msg;
    }
}
