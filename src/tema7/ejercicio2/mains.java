package tema7.ejercicio2;

import java.util.Scanner;

public class mains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("el siguiente menu te xplicara las opciones para usar el cifrador y el descifrador dependiendo de uno de los 3 tipos");
        boolean bucle = false;
        int tipo ;
        int opcion;
        while (!bucle) {
            System.out.println("introduce el tipo 1 multiplicaion 2 suma 3 division ");
            System.out.println("menu:");
            System.out.println("1. introducir numero que va a modificar");
            System.out.println("2. cantidad numerica que modificara al numero");
            System.out.println("3. TIPO + codificar y descodificar");
            System.out.println("4. imprimir resultados ");
            System.out.println("5. acabar programa");
            System.out.println("introduce la opcion");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    int modicador=0;
                    boolean bucle1 = false;
                    System.out.println("introduce el modificador ");
                   modicador = sc.nextInt();




            }

        }
    }
}

