import java.util.Arrays;
import java.util.Scanner;

public class CribaDeEratostenes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor de N: ");
        int N = scanner.nextInt();

        long tiempoInicio = System.nanoTime();
        boolean[] esPrimo = cribaDeEratostenes(N);
        long tiempoFin = System.nanoTime();

        System.out.println("Numeros primos hasta " + N + ":");
        for (int i = 2; i <= N; i++) {
            if (esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        long duracion = tiempoFin - tiempoInicio;
        System.out.println("Tiempo de ejecucion: " + duracion + " nanosegundos");

        scanner.close();
    }

    public static boolean[] cribaDeEratostenes(int N) {
        boolean[] esPrimo = new boolean[N + 1];
        Arrays.fill(esPrimo, true);
        esPrimo[0] = false;
        esPrimo[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= N; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        return esPrimo;
    }
}
