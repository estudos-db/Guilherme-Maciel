package Ex7;

public class Fibonacci {
    static long fibo(int n) {
        int F = 0;
        int ant = 0;

        for (int i = 1; i <= n; i++) {

            if (i == 1) {
                F = 1;
                ant = 0;
            } else {
                F += ant;
                ant = F - ant;
            }

        }

        return F;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            System.out.print("(" + i + "):" + Fibonacci.fibo(i) + "\t");
        }

    }
}
