package ex2;

import java.math.BigDecimal;

public class VendeProduto {

        private String nome;
        private BigDecimal preco;
        private BigDecimal valor;
        private int quantidade;

        public VendeProduto(String nome, BigDecimal preco, int quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
            valor = definirValor(preco, quantidade);
        }

        public static BigDecimal definirValor(BigDecimal preco, int quantidade){
            BigDecimal resultado = preco.multiply(new BigDecimal(quantidade));
            if (quantidade > 10 &&  quantidade <= 20) {
                resultado = resultado.multiply(BigDecimal.valueOf(0.9));
            } else if (quantidade > 20 && quantidade <= 50) {
                resultado = resultado.multiply(BigDecimal.valueOf(0.8));
            } else if (quantidade > 50) {
                resultado = resultado.multiply(BigDecimal.valueOf(0.75));
            }
            return resultado;
        }

        public BigDecimal getValor() {
            return valor;
        }

    public static void main(String[] args) {
        System.out.println(definirValor(new BigDecimal(20.0), 5));
    }

}
