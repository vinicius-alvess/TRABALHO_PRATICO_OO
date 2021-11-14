package SGR;

public class CategoriaDespesa {

    private String descricao;


    public CategoriaDespesa(String descricaoCategoriDespesa) {
        this.descricao = descricaoCategoriDespesa;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
