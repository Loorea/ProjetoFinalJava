package GerenciadorDeProdutos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private int capacidadeTotal;
    private int capacidadeDisponivel;
    private List<String> produtos;

    public Estoque(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
        this.capacidadeDisponivel = capacidadeTotal;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String nome, int quantidade) {
        if (capacidadeDisponivel >= quantidade) {
            produtos.add(nome + " - " + quantidade + " unidades");
            capacidadeDisponivel -= quantidade;
            System.out.println(quantidade + " unidades de " + nome + " adicionadas ao estoque.");
        } else {
            System.out.println("Espaço insuficiente no estoque para adicionar " + nome + ".");
        }
    }

    public int getCapacidadeDisponivel() {
        return capacidadeDisponivel;
    }

    public void exibirEstoque() {
        System.out.println("Produtos no estoque:");
        for (String produto : produtos) {
            System.out.println("- " + produto);
        }
        System.out.println("Capacidade disponível: " + capacidadeDisponivel);
    }
}
