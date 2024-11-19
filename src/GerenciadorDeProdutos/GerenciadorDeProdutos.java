package GerenciadorDeProdutos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GerenciadorDeProdutos {
    private List<Produto> produtos = new ArrayList<>();
    private int codigoAtual = 1;
    private Scanner scanner = new Scanner(System.in);

    public void criar() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite o peso do produto:");
        Double peso = scanner.nextDouble();
        scanner.nextLine();

        Produto produto = new Produto(nome, codigoAtual, peso);
        produtos.add(produto);
        System.out.println("Produto criado com sucesso!");
        codigoAtual++;
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
        Produto produtoEncontrado = null;

        System.out.println("Digite o código do produto que deseja atualizar:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

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
                produtoEncontrado.setPeso(novoPeso);
            }

            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto com código " + codigo + " não encontrado.");
        }
    }
}