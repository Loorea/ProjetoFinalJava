import java.util.ArrayList;
import java.util.List;

public class AlgoritmoMochila {

    // Método principal do algoritmo
    public static List<Produto> executar(int capacidade, List<Produto> produtos) {
        int n = produtos.size();
        int[][] dp = new int[n + 1][capacidade + 1];

        // Construção da tabela dp
        for (int i = 1; i <= n; i++) {
            Produto produto = produtos.get(i - 1);
            for (int w = 0; w <= capacidade; w++) {
                if (produto.getPeso() <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - produto.getPeso()] + produto.getValor());
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Reconstrução da solução
        List<Produto> selecionados = new ArrayList<>();
        int w = capacidade;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Produto produto = produtos.get(i - 1);
                selecionados.add(produto);
                w -= produto.getPeso();
            }
        }

        return selecionados;
    }

    // Exibir resultados
    public static void exibirResultados(List<Produto> selecionados, int capacidade) {
        int pesoTotal = 0;
        int valorTotal = 0;

        System.out.println("\nProdutos selecionados para o estoque:");
        for (Produto produto : selecionados) {
            System.out.println(produto.getNome() + " (Peso: " + produto.getPeso() + ", Valor: " + produto.getValor() + ")");
            pesoTotal += produto.getPeso();
            valorTotal += produto.getValor();
        }

        System.out.println("Peso total utilizado: " + pesoTotal + "/" + capacidade);
        System.out.println("Valor total armazenado: " + valorTotal);
    }
}
