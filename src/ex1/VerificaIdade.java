package ex1;
public class VerificaIdade {
    public static String verificarIdade(int idade){
        if (idade < 18){
            return "Menor de idade!";
        } else {
            return "Maior de idade!";
        }
    }

    public static void main(String[] args) {
        System.out.println(verificarIdade(22));
    }
}
