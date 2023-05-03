public class DeTerra extends Dragao{
    public DeTerra(int id, double peso, int vida, double ataque) {
        super(id, peso, vida, ataque);
    }
    @Override
    public void atacar(Dragao dragao) {
        if (dragao.getClass() == DeAgua.class) {
            dragao.setVida(dragao.getVida() - getAtaque());
        }
        if (dragao.getClass() == DeFogo.class) {
            dragao.setVida(dragao.getVida() - getAtaque());
        }
    }
    @Override
    public String toString(){
        return "Dragao de Terra | Vida: " + this.getVida();
    }

}
