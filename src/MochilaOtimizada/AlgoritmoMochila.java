package MochilaOtimizada;

import java.util.*;

public class AlgoritmoMochila {

    public List<Produto> resolver(Mochila mochila) {
        System.out.println("Solucionando o problema de otimização...");

        System.out.println("Ordenando os produtos...");
        List<Produto> produtosOrdenados = new ArrayList<>(mochila.getProdutos());
        produtosOrdenados.sort((a, b) -> Double.compare(b.getValor() / b.getPeso(), a.getValor() / a.getPeso()));

        System.out.println("Criando fila de prioridade para explorar os estados com base no valor total...");
        PriorityQueue<EstadoMochila> fila = new PriorityQueue<>(Comparator.comparingDouble(EstadoMochila::getValorTotal).reversed());
        fila.add(new EstadoMochila());

        EstadoMochila melhorEstado = null;


        System.out.println("Buscando a melhor combinação...");
        while (!fila.isEmpty()) {
            EstadoMochila atual = fila.poll();

            if (atual.getPesoTotal() <= mochila.getCapacidade() &&
                    (melhorEstado == null || atual.getValorTotal() > melhorEstado.getValorTotal())) {
                melhorEstado = atual;
            }

            for (Produto produto : produtosOrdenados) {

                if (atual.getPesoTotal() + produto.getPeso() <= mochila.getCapacidade() &&
                        !atual.getProdutosSelecionados().contains(produto)) {
                    EstadoMochila novoEstado = new EstadoMochila(atual.getProdutosSelecionados());
                    novoEstado.adicionarProduto(produto);
                    fila.add(novoEstado);
                }
            }
        }

        return melhorEstado != null ? melhorEstado.getProdutosSelecionados() : new ArrayList<>();
    }
}