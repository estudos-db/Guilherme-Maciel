package Ex11;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class OrdenaVetor {

    public static void main(String[] args) {
        int vet[]= new int[10];
        int i;
        int cont;
        int aux;


        for(i=0; i<vet.length;i++){
            vet[i]= new Random().nextInt(99);
        }
        System.out.println("Vetor desordenado");
        System.out.println(Arrays.toString(vet));
        Arrays.sort(vet);
        System.out.println("Vetor ordenado");
        System.out.println(Arrays.toString(vet));
    }
}
