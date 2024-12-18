package otoni.omena.santos.machado.movietag.models;

public class Avaliacao {
    private Producao producao;
    private Integer avaliacao;

    public Avaliacao(Producao prod, int avaliacaoInt) {
       avaliacao = avaliacaoInt;
       producao = prod;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

}
