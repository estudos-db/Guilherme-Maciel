package Ex16;

import java.util.ArrayList;

public class RegistroDeColega {

    private ArrayList<Colega> rC;

    public RegistroDeColega() {
        rC = new ArrayList<Colega>();
    }

    public void addColega (Colega colega) {
        rC.add(colega);
    }

    public Colega getColega (int indice) {
        return rC.get(indice);
    }

    public void removeContato (Colega colega) {
        rC.remove(colega);
    }

    public void removeContato (int indice) {
        rC.remove(indice);
    }

    public int size() {
        return rC.size();
    }

}