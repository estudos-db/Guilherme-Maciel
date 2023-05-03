import java.util.*;
import java.util.HashMap;

public class Main extends Thread{

    public static ArrayList<Integer> procuraDragao(HashMap<Integer, HashMap<Integer, ArrayList<Dragao>>> matriz, int id){

        for (int x = 0; x < matriz.size(); x++){
            HashMap<Integer, ArrayList<Dragao>> coluna = matriz.get(x);
            for (int y = 0; y < matriz.size(); y++){
                if (coluna.get(y) == null) continue;
                for (Dragao dr: coluna.get(y)) {
                    if (dr == null) continue;
                    if (dr.getId() == id){
                        return new ArrayList<Integer>(Arrays.asList(x, y));
                    }
                }
            }
        }
        return null;
    }

    public static void movimentar(HashMap<Integer, HashMap<Integer, ArrayList<Dragao>>> matriz, int x, int y, Dragao dragao){

        ArrayList<Integer> posicaoAnteriorDragao = procuraDragao(matriz, dragao.getId());

        HashMap<Integer, ArrayList<Dragao>> auxiliarEstadoAnterior = matriz.get(posicaoAnteriorDragao.get(0));

        ArrayList<Dragao> auxiliarDragoes = auxiliarEstadoAnterior.get(posicaoAnteriorDragao.get(1));

        for (int i = 0; i< auxiliarDragoes.size(); i++){
            if (dragao.getId() == auxiliarDragoes.get(i).getId()){
                auxiliarDragoes.remove(i);
            }
        }

        auxiliarEstadoAnterior.put(posicaoAnteriorDragao.get(1), auxiliarDragoes);

        HashMap<Integer, ArrayList<Dragao>> auxiliarNovoEstado = matriz.get(x);
        ArrayList<Dragao> auxiliarDragoesNovoEstado = auxiliarNovoEstado.get(y);
        auxiliarDragoesNovoEstado.add(dragao);
        auxiliarNovoEstado.put(y, auxiliarDragoesNovoEstado);
    }

    public static void printarMatriz(HashMap<Integer, HashMap<Integer, ArrayList<Dragao>>> matriz){
        for (int i = 0; i < matriz.size(); i++) {
            HashMap<Integer, ArrayList<Dragao>> hashAuxiliar = matriz.get(i);
            for (int j = 0; j < hashAuxiliar.size(); j++) {
                System.out.print(hashAuxiliar.get(j) + " ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Dragao d1 = new DeFogo(1, 10, 10, 2);
        Dragao d2 = new DeAgua(2, 10, 10, 2);
        Dragao d3 = new DeTerra(3, 10, 10, 2);

        ArrayList<Dragao> dragoes = new ArrayList<>(Arrays.asList(d1, d2, d3));

        HashMap<Integer, HashMap<Integer, ArrayList<Dragao>>> matriz = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            HashMap<Integer, ArrayList<Dragao>> aux = new HashMap<>();
            for (int j = 0; j < 5; j++) {
                aux.put(j, new ArrayList<>());
            }
            matriz.put(i, aux);
        }

        HashMap<Integer, ArrayList<Dragao>> auxiliarEstadoAnterior = new HashMap<>();

        auxiliarEstadoAnterior = matriz.get(0);
        auxiliarEstadoAnterior.put(0, new ArrayList<Dragao>(Arrays.asList(d1)));
        matriz.put(0, auxiliarEstadoAnterior);

        auxiliarEstadoAnterior = matriz.get(1);
        auxiliarEstadoAnterior.put(0, new ArrayList<Dragao>(Arrays.asList(d2)));
        matriz.put(1, auxiliarEstadoAnterior);

        auxiliarEstadoAnterior = matriz.get(2);
        auxiliarEstadoAnterior.put(0, new ArrayList<Dragao>(Arrays.asList(d3)));
        matriz.put(2, auxiliarEstadoAnterior);

        System.out.println(procuraDragao(matriz, d1.getId()));
        printarMatriz(matriz);
        System.out.println(procuraDragao(matriz, d1.getId()));


        movimentar(matriz, 4, 3, d2);
        System.out.println("--");
        printarMatriz(matriz);


        Random auxiliarAleatoriox = new Random();
        Random auxiliarAleatorioy = new Random();
        Random auxiliarDragao = new Random();

        while (true){
            if (d1.getVida() < 1 || d2.getVida() < 1 || d3.getVida() < 1)break;

            int aleatoriox = auxiliarAleatoriox.nextInt(4);
            int aleatorioy = auxiliarAleatorioy.nextInt(4);

            int aleatorioDragao = auxiliarDragao.nextInt(dragoes.size())-1;

            //condição do if ? caso tru : caso false

            movimentar(matriz, aleatoriox, aleatorioy, dragoes.get(aleatorioDragao<0?0:aleatorioDragao));

            if (procuraDragao(matriz, 1).get(0) == procuraDragao(matriz, 2).get(0)
            && procuraDragao(matriz, 1).get(1) == procuraDragao(matriz, 2).get(1)){
                d1.atacar(d2);
                d2.atacar(d1);
            }
            if (procuraDragao(matriz, 1).get(0) == procuraDragao(matriz, 3).get(0)
                    && procuraDragao(matriz, 1).get(1) == procuraDragao(matriz, 3).get(1)){
                d1.atacar(d3);
                d3.atacar(d1);
            }
            if (procuraDragao(matriz, 2).get(0) == procuraDragao(matriz, 3).get(0)
                    && procuraDragao(matriz, 2).get(1) == procuraDragao(matriz, 3).get(1)){
                d2.atacar(d3);
                d3.atacar(d2);
            }
            System.out.println(matriz);
            Thread.sleep(100L);
        }


        System.out.println("---");

        System.out.println(dragoes);
        System.out.println("---");

        for (int i = 0; i < dragoes.size(); i++) {
            System.out.println(i + " = " + dragoes.get(i).getId());
        }

        printarMatriz(matriz);
    }
}