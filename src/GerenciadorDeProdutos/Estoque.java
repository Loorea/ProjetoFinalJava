package GerenciadorDeProdutos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();
    private int codigoAtual = 1;
    private double capacidade;

    private Scanner scanner = new Scanner(System.in);

    public Estoque(double capacidade) {
        this.capacidade = capacidade;
    }

    public void adicionarProduto() {

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o peso do produto:");
        Double peso = scanner.nextDouble();

        System.out.println("Digite o valor do produto:");
        Double valor = scanner.nextDouble();

        Produto produto = new Produto(nome, codigoAtual, peso, valor);
        produtos.add(produto);

        System.out.println("Produto criado com sucesso!");
        codigoAtual++;

    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public void atualizarProdutos() {

        System.out.println("Digite o código do produto que deseja atualizar:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto produtoEncontrado = null;

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado != null) {

            System.out.println("Produto encontrado:");

            System.out.println(produtoEncontrado);

            System.out.println("Digite o novo nome do produto (ou pressione Enter para manter o mesmo):");

            String novoNome = scanner.nextLine();

            if (!novoNome.isEmpty()) {
                produtoEncontrado.setNome(novoNome);
            }

            System.out.println("Digite o novo peso do produto (ou -1 para manter o mesmo):");
            double novoPeso = scanner.nextDouble();
            scanner.nextLine();

            if (novoPeso > -1) {

                double pesoAtual = produtoEncontrado.getPeso();
                double diferencaPeso = novoPeso - pesoAtual;

                produtoEncontrado.setPeso(novoPeso);
                System.out.println("Produto atualizado com sucesso!");

            } else {

                System.out.println("Nenhuma alteração no peso.");

            }

        } else {

            System.out.println("Produto com código " + codigo + " não encontrado.");

        }
    }

    public double getCapacidade() {
        return capacidade;
    }

}
