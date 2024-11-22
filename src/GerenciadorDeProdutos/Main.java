package GerenciadorDeProdutos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque(100);
        GerenciadorDeProdutos gerenciador = new GerenciadorDeProdutos(estoque);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nGerenciador de Produtos");
            System.out.println("1. Criar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Exibir Estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciador.criar();
                    break;
                case 2:
                    gerenciador.listar();
                    break;
                case 3:
                    gerenciador.atualizar();
                    break;
                case 4:
                    estoque.exibirEstoque();
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
