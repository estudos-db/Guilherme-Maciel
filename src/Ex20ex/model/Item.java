package Ex20.model;

import java.math.BigDecimal;

public class Item {
    private Produto produto;
    private BigDecimal precoItem;

    private int quantItem;


    public Item(int quant, Produto produto) {
        this.quantItem = quant;
        this.produto = produto;
        valorTotal();

    }

    public int getQuant() {
        return quantItem;
    }

    public void setQuant(int quant) {
        this.quantItem = quant;
    }

    public BigDecimal getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(BigDecimal precoItem) {
        this.precoItem = precoItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void valorTotal(){
        precoItem = produto.getPrecoProduto().multiply(BigDecimal.valueOf(quantItem));
    }

    @Override
    public String toString() {
        return "Item{" +
                "quant=" + quantItem +
                ", precoItem=" + precoItem +
                ", produto=" + produto +
                '}';
    }
}
