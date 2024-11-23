package GerenciadorDeProdutos;

import java.util.*;

/**
 * A classe AlgoritmoMochila implementa o Algoritmo A* para resolver o problema da mochila.
 * Dado um conjunto de produtos e uma capacidade máxima do estoque, esta classe encontra
 * a melhor combinação de produtos que maximiza o valor total sem ultrapassar a capacidade.
 */
public class AlgoritmoMochila {

    /**
     * Resolve o problema da mochila utilizando o Algoritmo A* para encontrar a melhor combinação de produtos.
     *
     * @param estoque A instância de Estoque que contém a capacidade máxima e a lista de produtos disponíveis.
     * @return A lista de produtos que representa a melhor solução encontrada, maximizando o valor sem exceder a capacidade.
     */
    public List<Produto> resolver(Estoque estoque) {
        System.out.println("Solucionando o problema de otimização...");

        // Ordena os produtos com base na eficiência (valor/peso), priorizando produtos de maior valor por unidade de peso
        System.out.println("Ordenando os produtos...");
        List<Produto> produtosOrdenados = new ArrayList<>(estoque.getProdutos());
        produtosOrdenados.sort((a, b) -> Double.compare(b.getValor() / b.getPeso(), a.getValor() / a.getPeso()));

        // Fila de prioridade para explorar estados com base no valor total (maior valor primeiro)
        System.out.println("Criando fila de prioridade para explorar os estados com base no valor total...");
        PriorityQueue<EstadoMochila> fila = new PriorityQueue<>(Comparator.comparingDouble(EstadoMochila::getValorTotal).reversed());
        fila.add(new EstadoMochila());

        // Variável para armazenar o melhor estado encontrado
        EstadoMochila melhorEstado = null;

        // Loop de busca A* para encontrar o melhor estado
        System.out.println("Buscando a melhor combinação...");
        while (!fila.isEmpty()) {
            EstadoMochila atual = fila.poll();

            // Verifica se o estado atual é melhor que o melhor estado encontrado até agora
            if (atual.getPesoTotal() <= estoque.getCapacidade() &&
                    (melhorEstado == null || atual.getValorTotal() > melhorEstado.getValorTotal())) {
                melhorEstado = atual;
            }

            // Expande o estado atual adicionando os próximos produtos disponíveis na lista ordenada
            for (Produto produto : produtosOrdenados) {
                // Adiciona o produto ao estado atual apenas se o peso total resultante não exceder a capacidade
                if (atual.getPesoTotal() + produto.getPeso() <= estoque.getCapacidade() &&
                        !atual.getProdutosSelecionados().contains(produto)) {  // Evita adicionar o mesmo produto várias vezes
                    EstadoMochila novoEstado = new EstadoMochila(atual.getProdutosSelecionados());
                    novoEstado.adicionarProduto(produto);
                    fila.add(novoEstado);
                }
            }
        }

        // Retorna a lista de produtos selecionados no melhor estado encontrado
        return melhorEstado != null ? melhorEstado.getProdutosSelecionados() : new ArrayList<>();
    }
}
