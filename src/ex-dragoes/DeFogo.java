public class DeFogo extends Dragao{

    public DeFogo(int id, double peso, int vida, double ataque) {
        super(id, peso, vida, ataque);
    }

    @Override
    public void atacar(Dragao dragao){
        if (dragao.getClass() == DeAgua.class){
            dragao.setVida(dragao.getVida() - getAtaque());
        }
        if (dragao.getClass() == DeTerra.class){
            dragao.setVida(dragao.getVida() - getAtaque());
        }
        //dragao.setVida(dragao.getVida() - getAtaque());
    }

    @Override
    public String toString(){
        return "Dragao de Fogo | Vida: " + this.getVida();
    }


}
