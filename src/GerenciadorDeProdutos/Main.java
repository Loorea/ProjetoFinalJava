package GerenciadorDeProdutos;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita a capacidade máxima do estoque ao usuário
        System.out.print("Digite a capacidade máxima do estoque (em kg): ");
        double capacidadeMaxima = scanner.nextDouble();
        scanner.nextLine();

        Estoque estoque = new Estoque(capacidadeMaxima);
        int opcao;

        do {
            System.out.println("\nGerenciador de Produtos");
            System.out.println("1. Criar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Resolver Mochila (Melhor Combinação de Produtos)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    estoque.adicionarProduto();
                    break;
                case 2:
                    estoque.listarProdutos();
                    break;
                case 3:
                    estoque.atualizarProdutos();
                    break;
                case 4:
                    AlgoritmoMochila algoritmo = new AlgoritmoMochila();
                    List<Produto> melhorCombinacao = algoritmo.resolver(estoque);
                    if (melhorCombinacao.isEmpty()) {
                        System.out.println("Nenhuma combinação de produtos encontrada dentro da capacidade.");
                    } else {
                        System.out.println("Melhor combinação de produtos:");
                        for (Produto produto : melhorCombinacao) {
                            System.out.println(produto);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
