package ex3;

import java.util.Scanner;

class Jogo {
    public static void main (String args []){

        Scanner sc = new Scanner(System.in);
        int sinal1, sinal2;

        System.out.println("Escolha entre 0, 1 e 2 , sendo que: ");
        System.out.println("Pedra = 0 ");
        System.out.println("Papel = 1  ");
        System.out.println("Tesoura = 2");

        System.out.println("Jogador 1: ");
        sinal1 = sc.nextInt();

        System.out.println("Jogador 2: ");
        sinal2 = sc.nextInt();

        switch (sinal1){
            case 0:
                switch (sinal2){
                    case 0:
                        System.out.println("Empate");
                        break;
                    case 1:
                        System.out.println("Jogador 2 ganhou");
                        break;
                    case 2:
                        System.out.println("Jogador 1 ganhou");
                        break;
                    default:
                        System.out.println ("Opção inválida!");
                } break;
            case 1:
                switch(sinal2) {
                    case 0:
                        System.out.println("Jogador 1 ganhou");
                        break;
                    case 1:
                        System.out.println(" Empatou");
                        break;
                    case 2:
                        System.out.println("Jogador 2 ganhou");
                        break;
                    default:
                        System.out.println ("Opção inválida!");
                } break;
            case 2:
                switch(sinal2) {
                    case 0:
                        System.out.println("Jogador 2 ganhou");
                        break;
                    case 1:
                        System.out.println("Jogador 1 ganhou");
                        break;
                    case 2:
                        System.out.println("Empate");
                        break;
                    default:
                        System.out.println ("Opção inválida!");
                } break;
            default:
                System.out.println ("Opção inválida!");
        }
    }
}