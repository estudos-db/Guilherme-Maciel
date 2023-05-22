import java.util.Map;

public class NinjaDeTaijutsu extends Personagem implements Ninja{
    public NinjaDeTaijutsu(String nome, Map<String, Jutsu> jutsus, int chakra, int vida) {
        super(nome, jutsus, chakra, vida);
    }

    @Override
    public boolean usarJutsu(String nome) {
        Jutsu jutsu = getJutsus().get(nome);

        if(!VerificaSePossuiChakra.getResultado(getChakra(), jutsu.getConsumoDeChakra())){
            System.out.print("chakra insuficiente");
            return false;
        }

        super.descontarChakra(jutsu.getConsumoDeChakra());
        System.out.print("habilidade de taijutso usada");

        return true;
    }

    @Override
    public void desviar(Jutsu jutsuOponente) {
        boolean teveSucesso = Defesa
                .getResultado(jutsuOponente.getDano());

        if(!teveSucesso) descontarVida(jutsuOponente.getDano());
    }
}