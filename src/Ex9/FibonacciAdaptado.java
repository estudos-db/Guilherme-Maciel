package Ex9;

import java.util.ArrayList;
import java.util.List;

public class FibonacciAdaptado {

    public static String gerarFibo(double n) {

        List<Double> listaFibo = new ArrayList<>(List.of(0.0, 100.0));
        if (n < 0) {
            return "Número negativo";
        }

        for (int i = 1; i < n; i++) {
            Double aux = listaFibo.get(i - 1) + listaFibo.get(i);
            if (aux >= n){
                break;
            }
            listaFibo.add(aux);
        }

        return listaFibo.toString();
    }
}
