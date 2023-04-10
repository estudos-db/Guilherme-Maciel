package Ex10;

import java.util.Scanner;

public class Matriz {
    private int linhas = 5;
    private int colunas = 5;
    private int[][] matriz = new int[linhas][colunas];

    private Scanner scanner = new Scanner(System.in);

    public void inserirNumerosNaMatriz() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.println("Inserir numero na matriz: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        mostrarMatriz(matriz);
        somarDiagonal(matriz);
    }

    public void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
    }

    public void somarDiagonal(int[][] matriz) {
        int somaDiagonal = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i == j){
                    somaDiagonal += matriz[i][j];
                }
            }
        }
        System.out.println("A soma da diagonal é: "+ somaDiagonal);
    }

    public static void main(String[] args) {
        Matriz matrizes = new Matriz();

        matrizes.inserirNumerosNaMatriz();
    }
}
