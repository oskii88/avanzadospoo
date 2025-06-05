package practicas_hasmap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class tienda {
    private static HashMap<String, animalx> listaanimales = new HashMap();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("bienvenido a la tienda de animales a continuacion le enseñaremos las opciones para adoptar su animal");
        programa();

    }
    private static void imprimirMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Pedir animal.");
        System.out.println("2. devolver animal.");
        System.out.println("3. Listar a los animales que se pediran.");
        System.out.println("4. Calcular precio.");
        System.out.println("5. Salir");
    }
    private static void programa()  {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            imprimirMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                       nuevoaniumal();


                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Ha elegido Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        } while (opcion != 5);


    }
    private static void nuevoaniumal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("introduc el nombre del animal");
        String nombre = sc.nextLine();
        if (listaanimales.containsKey(nombre)) {
            listaanimales.get(nombre).masmascotas();
        }else {
            System.out.println("vale añadiremos uno nuevo <3");
            System.out.println("dime el precio del animal");


         }
        double pio = sc.nextDouble();

        System.out.println("dime el tipo de animal pez , canino , felinos");
        String a = sc.nextLine();
        animalx nuevoanimalq;
        do {
            boolean sal = false;
            if (a.equalsIgnoreCase("pez")) { //si no existe pez
                do {
                    System.out.println("es de agua dulce si o no");
                    String respuesta = sc.nextLine();
                    if (respuesta.equalsIgnoreCase("si")) {
                        sal = true;
                    } else if (respuesta.equalsIgnoreCase("no")) {
                        sal = false;
                    } else {
                        System.out.println("dato incorrecto");
                    }


                } while (true);


            }
            nuevoanimalq = new pez(nombre, 1, pio, sal);
        }while(true);

    }
}
