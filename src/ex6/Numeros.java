package ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Numeros {
    List<Integer> numeros = new ArrayList<>();
    Random random = new Random();

    public void gerarNumeros(){
        for (int i = 0; i < 10; i++) {
            numeros.add(random.nextInt(100));
        }
    }

    public Integer informarMenorNumero(List<Integer> lista){
        Integer numero = null;
        for (int i = 0; i < lista.size(); i++) {
            numero = lista.get(i);
            for (int j = 0; j < lista.size(); j++) {
                if (numero > lista.get(j)) {
                    numero = lista.get(j);
                }
            }
        }
        return numero;
    }

    public Integer informarMaiorNumero(List<Integer> lista){
        Integer numero = null;
        for (int i = 0; i < lista.size(); i++) {
            numero = lista.get(i);
            for (int j = 0; j < lista.size(); j++) {
                if (numero < lista.get(j)) {
                    numero = lista.get(j);
                }
            }
        }
        return numero;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }
}