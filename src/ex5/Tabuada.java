package ex5;

import java.util.ArrayList;
import java.util.List;

public class Tabuada {

    public static void mostrarTabuada(double numero){
        System.out.println("vc escolheu a tabuada de:" + numero);
        for (int i = 1; i < 11; i++) {
            System.out.println(numero +" x "+ i + " = " + (numero*i));
        }
    }

    public static void main(String[] args) {
        mostrarTabuada(5);
    }
}