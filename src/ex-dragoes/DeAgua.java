public class DeAgua extends Dragao{
    public DeAgua(int id, double peso, int vida, double ataque) {
        super(id, peso, vida, ataque);
    }

    @Override
    public void atacar(Dragao dragao) {
        if (dragao.getClass() == DeFogo.class) {
            dragao.setVida(dragao.getVida() - getAtaque());

        }

        if (dragao.getClass() == DeTerra.class) {
            dragao.setVida(dragao.getVida() - getAtaque());
        }
    }
    @Override
    public String toString(){
        return "Dragao de Agua | Vida: " + this.getVida();
    }

}
