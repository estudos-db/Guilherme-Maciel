public class NinjaDeTaijutsu extends Personagem implements Ninja{

    public NinjaDeTaijutsu(String nome, int idade, String aldeia, String[] jutsus, int chakra) {
        super(nome, idade, aldeia, jutsus, chakra);
    }

    @Override
    public void usarJutsu() {
        System.out.println("O personagem " + getNome() + " está usando um golpe de Taijutsu!");
    }

    @Override
    public void desviar() {
        System.out.println("O personagem " + getNome() + " está desviando de um ataque usando sua habilidade em Taijutsu!");
    }
}