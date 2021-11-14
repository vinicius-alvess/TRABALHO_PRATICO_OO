package SGR;

public class Despesa {
    private String descricao;
    private String categoria;
    private Float valorDespesa;
    private int month;
    private int year;

    public Despesa(String descricao, String categoria, Float valorDespesa, int month, int year) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorDespesa = valorDespesa;
        this.month = month;
        this.year = year;
    }

    public Despesa(String descricao, Float valorDespesa, String categoria) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valorDespesa = valorDespesa;
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valorDespesa=" + valorDespesa +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public Float getValorDespesa() {
        return valorDespesa;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;

    }
}
