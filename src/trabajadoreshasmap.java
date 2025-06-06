

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class trabajadoreshasmap {
    private static HashMap<String, trabajador> listadetrabajadores = new HashMap();
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        programa();

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
                    nuevotrabajador();
                    break;
                case 2:
                    buscarPorNombre();
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
    private static void imprimirMenu() {
        System.out.println("Menu de opciones");
        System.out.println("1. nuevo trabajador");
        System.out.println("2. buscar por nombre(dni)");
        System.out.println("3. Buscar por DNI (nombre)");
        System.out.println("4. borrar trabajador");
        System.out.println("5. Salir");
    }
    private static void nuevotrabajador() {
        Scanner sc = new Scanner(System.in);
        boolean valido = true;
        trabajador nuevotrabajador;

            System.out.println("Ingrese el nombre del trabajador");
            String nombre = sc.nextLine();
            if (listadetrabajadores.containsKey(nombre)) {
                System.out.println("El trabajador ya existe introduzca el nombre de nuevo");

            }else {
                System.out.println("Ingrese el dni del trabajador");
                String dni = sc.nextLine();
                System.out.println("Ingrese el apellido del trabajador");
                String apellido = sc.nextLine();
                nuevotrabajador = new trabajador(nombre, dni, apellido);

            }


    }
    private static void buscarPorNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del trabajador");
        String a = sc.nextLine();
        if( listadetrabajadores.containsKey(a)) {
           System.out.println("el dni de ese trabajador es:" + listadetrabajadores.get(a) );
        }

    }
}
