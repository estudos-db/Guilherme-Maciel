package Ex15;

import java.util.Scanner;

public class Calculadora {
    public static  double div(double valor1, double valor2) {
        return valor1/valor2;
    }
    public static double mult(double valor1, double valor2) {
        return valor1*valor2;
    }
    public static double sub(double valor1, double valor2) {
        return valor1-valor2;
    }
    public static double som(double valor1, double valor2) {
        return valor1+valor2;
    }

    public static double pot(double valor1, int auxPot) {
        double resultdadoPotencia = 1;
        for (int i = 0; i < auxPot; i++) {
            resultdadoPotencia *= valor1;
        }
        return  resultdadoPotencia;
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        int opcao = 5;
        double valor1;
        double valor2;
        int auxPot = 0;


        Scanner input = new Scanner(System.in);
        System.out.println("-Escolha uma opção-");
        System.out.println("1. Soma");
        System.out.println("2. Subtracao");
        System.out.println("3. Multiplicacao");
        System.out.println("4. Divisao");
        System.out.println("5. Potencia");
        System.out.println("0. Sair");
        System.out.println("Operação: ");

        opcao = input.nextInt();

        while (opcao != 0) {
            Scanner input1 = new Scanner(System.in);

            System.out.println("Qual o primeiro numero: ");
            valor1 = input1.nextInt();
            System.out.println("Qual o segundo numero (no caso de potencia, a elevação desejada do primeiro numero digitado: ");
            valor2 = input1.nextInt();

            if ( opcao == 1 ) {
                double operacao = c.som(valor1, valor2);
                System.out.printf("\nO resultado da soma é: %2f\n", operacao);
                break;
            }
            else if (opcao == 2) {
                double operacao = c.sub(valor1, valor2);
                System.out.printf("\nO resultado da subtração é: %2f\n", operacao);
                break;
            }
            else if (opcao == 3) {
                double operacao = c.mult(valor1, valor2);
                System.out.printf("\nO resultado da multiplicação é: %2f\n", operacao);
                break;
            }
            else if (opcao == 4) {
                double operacao = c.div(valor1, valor2);
                System.out.printf("\nO resultado da divisão é: %2f\n", operacao);
                break;
            }
            else if (opcao == 5) {
                double operacao = c.pot(valor1, auxPot);
                System.out.printf("\nO resultado da potencia é: %2f\n", operacao);
                break;
            }
            else{
                System.out.println("Opção inválida!");
                break;
            }
        }

    }
}
