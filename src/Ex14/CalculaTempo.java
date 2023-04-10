package Ex14;

import java.util.Scanner;

public class CalculaTempo {
    private int horas;
    private int minutos;
    private int segundos;
    private Scanner scanner = new Scanner(System.in);

    public void LerDados() {
        System.out.println("informe o numero em segundos que você deseja calcular");
        int tempoEmSegundos = scanner.nextInt();
        System.out.println(escreverDados(tempoEmSegundos));
    }

    public String escreverDados(int tempoEmSegundos) {

        horas = calcularHoras(tempoEmSegundos);
        minutos = calcularMinutos(tempoEmSegundos);
        segundos = calcularSegundos(tempoEmSegundos);

        return tempoEmSegundos + " segundos equivalem a " + horas + "h" + minutos + "min" + segundos + "seg";
    }

    public int calcularHoras(int tempoEmSegundos) {
        return tempoEmSegundos / 3600;
    }

    public int calcularMinutos(int tempoEmSegundos) {
        return (tempoEmSegundos % 3600) / 60;
    }

    public int calcularSegundos(int tempoEmSegundos) {
        return (tempoEmSegundos % 3600) % 60;
    }

    public static void main(String[] args) {
        CalculaTempo calculadorTempo = new CalculaTempo();
        calculadorTempo.LerDados();
    }

}
