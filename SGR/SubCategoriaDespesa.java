package SGR;

public class SubCategoriaDespesa {

    private CategoriaDespesa descricaoCategoria;
    private String descricaoSubcategoria;

    public SubCategoriaDespesa(CategoriaDespesa descricaoCategoria, String descricaoSubcategoria) {
        this.descricaoCategoria = descricaoCategoria;
        this.descricaoSubcategoria = descricaoSubcategoria;
    }

    @Override
    public String toString() {
        return  descricaoCategoria + "_" + descricaoSubcategoria;
    }

    public CategoriaDespesa getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public String getDescricaoSubcategoria() {
        return descricaoSubcategoria;
    }

}
