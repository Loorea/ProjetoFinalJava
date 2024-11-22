package GerenciadorDeProdutos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GerenciadorDeProdutos {
    private List<Produto> produtos = new ArrayList<>();
    private int codigoAtual = 1;
    private Scanner scanner = new Scanner(System.in);
    private Estoque estoque; // MODIFICADO
    
    // MODIFICADO
    // construtor que recebe o estoque
    public GerenciadorDeProdutos(Estoque estoque) {
        this.estoque = estoque;
    }

    public void criar() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o peso do produto:");
        Double peso = scanner.nextDouble();
        scanner.nextLine();

        // MODIFICADO
        // verifica se tem capacidade disponivel no estoque
        if (estoque.getCapacidadeDisponivel() >= peso) {
            Produto produto = new Produto(nome, codigoAtual, peso);
            produtos.add(produto);
            estoque.adicionarProduto(nome, peso.intValue());
            System.out.println("Produto criado com sucesso!");
            codigoAtual++;
        } else {
            System.out.println("Espaço insuficiente no estoque para adicionar este produto.");
        }
    }

    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
    
    public void atualizar() {
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
            
            // MODIFICADO
            if (novoPeso > -1) {
                double pesoAtual = produtoEncontrado.getPeso();
                double diferencaPeso = novoPeso - pesoAtual;
                
                // MODIFICADO
                // ve se o estoque tem capacidade pro peso do produto
                if (estoque.getCapacidadeDisponivel() >= diferencaPeso) {
                    estoque.adicionarProduto(produtoEncontrado.getNome(), (int) diferencaPeso);
                    produtoEncontrado.setPeso(novoPeso);
                    System.out.println("Produto atualizado com sucesso!");
                } else {
                    System.out.println("Espaço insuficiente no estoque para atualizar o peso.");
                }
            } else {
                System.out.println("Nenhuma alteração no peso.");
            }
        } else {
            System.out.println("Produto com código " + codigo + " não encontrado.");
        }
    }
}
