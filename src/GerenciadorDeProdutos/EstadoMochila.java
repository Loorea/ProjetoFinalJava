package GerenciadorDeProdutos;

import java.util.ArrayList;
import java.util.List;

class EstadoMochila {
    private List<Produto> produtosSelecionados;
    private double pesoTotal;
    private double valorTotal;

    // Construtor para um estado vazio
    public EstadoMochila() {
        this.produtosSelecionados = new ArrayList<>();
        this.pesoTotal = 0;
        this.valorTotal = 0;
    }

    // Construtor para um estado baseado em uma lista de produtos existente
    public EstadoMochila(List<Produto> produtosSelecionados) {
        this.produtosSelecionados = new ArrayList<>(produtosSelecionados);
        this.pesoTotal = produtosSelecionados.stream().mapToDouble(Produto::getPeso).sum();
        this.valorTotal = produtosSelecionados.stream().mapToDouble(Produto::getValor).sum();
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

    @Override
    public String toString() {
        return "EstadoMochila{" +
                "produtosSelecionados=" + produtosSelecionados +
                ", pesoTotal=" + pesoTotal +
                ", valorTotal=" + valorTotal +
                '}';
    }
}

