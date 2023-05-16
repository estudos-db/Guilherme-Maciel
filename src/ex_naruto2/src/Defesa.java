import java.util.Random;

public class Defesa {
    public static boolean getResultado(int oponenteDano) {
        boolean conseguiuDesviar = new Random().nextBoolean();

        if(conseguiuDesviar){
            System.out.println("Você desviou de um ataque!");
        }else {
            System.out.println("Você recebeu um ataque, dano sofrido: " + oponenteDano);
        }

        return conseguiuDesviar;
    }
}
