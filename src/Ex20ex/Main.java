package Ex20;

import Ex20.model.Estoque;
import Ex20.model.Produto;
import Ex20.service.PedidoServico;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void lotarEstoque(){
        Produto produto1 = new Produto(1, "chocolate", BigDecimal.valueOf(15), 30);
        Produto produto2 = new Produto(2, "arroz", BigDecimal.valueOf(10), 30);
        Produto produto3 = new Produto(2, "sabao", BigDecimal.valueOf(5), 30);


        Estoque.adicionaProdutoNaLista(produto1);
        Estoque.adicionaProdutoNaLista(produto2);
        Estoque.adicionaProdutoNaLista(produto3);
    }

    public static void iniciaMenu() {

        PedidoServico pedidoService = new PedidoServico();
        Scanner sc = new Scanner(System.in);

        boolean aux = true;
        while (aux) {
            int aux2;
            System.out.println("---ESCOLHA A OPÇÃO DESEJADA---");
            System.out.println("1: Visualizar estoque");
            System.out.println("2: Cadastrar produto");
            System.out.println("3: Realizar pedido");
            System.out.println("4: Sair");
            try {
                aux2 = sc.nextInt();
            } catch (InputMismatchException excecao) {
                sc.nextLine();
                aux2 = 0;
            }
            switch (aux2) {
                case 1 -> {
                    Estoque.exibirEstoque();
                }
                case 2 -> {
                    Estoque.cadastrarProduto();
                }
                case 3 -> {
                    pedidoService.realizarPedido();
                }
                case 4 -> {
                    System.out.println("Programa encerrado");
                    aux = false;
                    sc.close();
                }
            }
        }
    }

    public static void main(String[] args) {
        lotarEstoque();
        iniciaMenu();
    }

}
