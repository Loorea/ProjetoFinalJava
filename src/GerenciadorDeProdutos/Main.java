package GerenciadorDeProdutos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque(100);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nGerenciador de Produtos");
            System.out.println("1. Criar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Sair");
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
