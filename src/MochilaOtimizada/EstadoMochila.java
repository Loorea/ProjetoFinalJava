package MochilaOtimizada;

import java.util.ArrayList;
import java.util.List;

class EstadoMochila {
    private List<Produto> produtosSelecionados;
    private double pesoTotal;
    private double valorTotal;


    public EstadoMochila() {
        this.produtosSelecionados = new ArrayList<>();
        this.pesoTotal = 0;
        this.valorTotal = 0;
    }


    public EstadoMochila(List<Produto> produtosSelecionados) {
        this.produtosSelecionados = new ArrayList<>(produtosSelecionados);
        for (Produto produto: produtosSelecionados) {
            this.pesoTotal += produto.getPeso();
            this.valorTotal += produto.getValor();
        }
    }

    public void adicionarProduto(Produto produto) {
        produtosSelecionados.add(produto);
        pesoTotal += produto.getPeso();
        valorTotal += produto.getValor();
    }

    public List<Produto> getProdutosSelecionados() {
        return produtosSelecionados;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double heuristica(double capacidade) {
        return capacidade - pesoTotal;
    }

    @Override
    public String toString() {
        return "EstadoMochila{" +
                "produtosSelecionados=" + produtosSelecionados +
                ", pesoTotal=" + pesoTotal +
                ", valorTotal=" + valorTotal +
                '}';
    }
}

