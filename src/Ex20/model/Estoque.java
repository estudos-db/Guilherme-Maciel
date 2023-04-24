package Ex20.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Estoque {
    private static List<Produto> listaProdutos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static Produto procuraProdutoPorNome(String nome) {
        for (Produto produto: listaProdutos) {
            if (produto.getNomeProduto().equals(nome) && produto.getQuantProduto() == 0){
                System.out.println("Produto indisponível no estoque");
            } else if (produto.getNomeProduto().equals(nome)){
                return produto;
            }
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public static Produto procuraProdutoPorId(int id) {
        for (Produto produto: listaProdutos) {
            if (produto.getIdProduto() == id && produto.getQuantProduto() == 0){
                System.out.println("Produto indisponível no estoque");
            } else if (produto.getIdProduto() == id){
                return produto;
            }
        }
        System.out.println("Produto não encontrado");
        return null;
    }

    public static void adicionaProdutoNaLista(Produto produto) {
        listaProdutos.add(produto);
    }

    public static void cadastrarProduto() {
        int idProduto = getListaProdutos().size() + 1;

        System.out.println("---CADASTRO DE PRODUTOS---");
        System.out.println("Nome do produto: ");
        String nomeProduto = sc.next();
        System.out.println("Preço do produto: ");
        BigDecimal precoProduto = sc.nextBigDecimal();
        System.out.println("Quantidade do produto: ");
        int quantProduto = sc.nextInt();

        Produto produto = new Produto(idProduto, nomeProduto, precoProduto, quantProduto);
        adicionaProdutoNaLista(produto);
        System.out.println("Produto cadastrado!");
    }

    public static void baixaEmEstoquePorNomeDeProduto(String nomeProduto, int aux) {
        for (Produto produto : listaProdutos){
            if (produto.getNomeProduto().equals(nomeProduto)){
                produto.setQuantProduto(produto.getQuantProduto() - aux);
            }
        }
    }

    public static void baixaEmEstoquePorIdDeProduto(int idProduto, int aux) {
        for (Produto produto : listaProdutos){
            if (produto.getIdProduto() == idProduto){
                produto.setQuantProduto(produto.getQuantProduto() - aux);
            }
        }
    }

    public static void exibirEstoque() {
        System.out.println("Estoque total: ");
        for (int i = 0; i < listaProdutos.size(); i++) {
            System.out.println(listaProdutos.get(i));
        }
    }

    public static boolean verificaDisponibilidadeDoProduto(String nomeProduto, int aux) {
        int qntProd = procuraProdutoPorNome(nomeProduto).getQuantProduto();
        if (qntProd - aux < 0){
            throw new NoSuchElementException("infelizmente não temos este produto em estoque suficiente");
        }
        return true;
    }


    public static List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public static void setListaProdutos(List<Produto> listaProdutos) {
        Estoque.listaProdutos = listaProdutos;
    }

}
