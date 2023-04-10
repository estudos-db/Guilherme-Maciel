package Ex8;

import java.util.Scanner;

public class RecebeNumero {
    private Scanner scanner = new Scanner(System.in);

    public void receberNumero(){
        double numero = 0;

        while (numero != 10){
            System.out.println("Digite um numero: ");
            numero = scanner.nextDouble();
            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        RecebeNumero recebedor = new RecebeNumero();
        recebedor.receberNumero();
    }
}
