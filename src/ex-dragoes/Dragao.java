public class Dragao {

    private int id;
    private double peso;
    private double vida;
    private double ataque;

    public Dragao(int id, double peso, double vida, double ataque) {
        this.id = id;
        this.peso = peso;
        this.vida = vida;
        this.ataque = ataque;
    }


    public void atacar(Dragao dragao){
        dragao.setVida(dragao.getVida() - getAtaque());
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
