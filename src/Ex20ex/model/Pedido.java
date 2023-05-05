package Ex20.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {
    private List<Item> listaDeItens = new ArrayList<>();
    private BigDecimal valorPedido = BigDecimal.valueOf(0);
    private Scanner sc = new Scanner(System.in);

    public void calcularValorTotal() {
        setValorPedido(BigDecimal.ZERO);
        for (int i = 0; i < listaDeItens.size(); i++) {
            valorPedido = valorPedido.add(listaDeItens.get(i).getPrecoItem());
        }
        setValorPedido(valorPedido);
    }

    public void adicionaItemNaLista() {
        System.out.println("Nome do produto desejado: ");
        String nome = sc.next();
        Produto produto = Estoque.procuraProdutoPorNome(nome);
        System.out.println("Quantidade desejada: ");
        int quantProduto = sc.nextInt();
        Estoque.verificaDisponibilidadeDoProduto(produto.getNomeProduto(), quantProduto);

        Item item = new Item(quantProduto, produto);
        Estoque.baixaEmEstoquePorNomeDeProduto(nome, quantProduto);

        adcionarItemALista(item);
        calcularValorTotal();
    }

    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public void adcionarItemALista(Item item) {
        listaDeItens.add(item);
    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "Itens no pedido " + listaDeItens +
                '}';
    }
}
