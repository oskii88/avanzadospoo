package ejercicioramd1;

import java.util.Scanner;

public class tokens {
    static java.util.Scanner in;

    public static void casoDePrueba() {

        // TU CÓDIGO AQUÍ
        int N = in.nextInt();
        int K = in.nextInt();
        int reparten = N/K;
        int sobran = N%K;
        System.out.println(reparten + " " + sobran);
    } // casoDePrueba

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main
} // class solution

