package Ex20.service;

import Ex20.model.Pedido;

import java.math.BigDecimal;
import java.util.Scanner;

public class PedidoServico {
    Scanner sc = new Scanner(System.in);

    public void realizarPedido() {
        boolean aux = true;

        Pedido pedido = new Pedido();
        pedido.adicionaItemNaLista();
        while (aux) {
            System.out.println("Adicionar item na lista? digite S(sim) ou N(não)");
            String aux2 = sc.next().toUpperCase();
            switch (aux2) {
                case "S" -> {
                    pedido.adicionaItemNaLista();
                }
                case "N" -> {
                    aux = false;
                }
            }
        }
        fecharPedido(pedido.getValorPedido());
    }

    public void fecharPedido(BigDecimal valorPedido) {
        BigDecimal troco;
        System.out.println("Valor total do pedido: " + valorPedido);
        System.out.println("Valor pago: ?");
        BigDecimal dinheiroRecebido = sc.nextBigDecimal();

        if (dinheiroRecebido.compareTo(valorPedido) < 0) {
            throw new RuntimeException("Dinheiro insuficiente");
        } else if (dinheiroRecebido.compareTo(valorPedido) == 0) {
            System.out.println("Compra finalizada");
        } else {
            troco = dinheiroRecebido.subtract(valorPedido);
            System.out.println("Compra finalizada! Seu troco é: " + troco);
        }
    }
}
