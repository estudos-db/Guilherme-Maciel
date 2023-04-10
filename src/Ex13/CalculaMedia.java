package Ex13;

public class CalculaMedia {

    public static double calcularMedia(int[] notas){
        double soma = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }
        return soma/notas.length;
    }

    public static String definirSituacaoPorMedia(int media){
        if (media < 4){
            return  "Reprovado";
        } else if (media >= 4 && media <= 6) {
            return  "Verificação Suplementar";
        }
        return  "Aprovado";
    }
}
