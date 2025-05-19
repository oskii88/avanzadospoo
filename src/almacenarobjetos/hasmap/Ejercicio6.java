package almacenarobjetos.hasmap;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {

        HashMap<Integer,String> alumnos= new HashMap<>();
        Scanner sc= new Scanner(System.in);

        alumnos.put(1001, "Laura Gómez");
        alumnos.put(1002, "Carlos Martínez");
        alumnos.put(1003, "Ana Rodríguez");
        alumnos.put(1004, "David Fernández");
        alumnos.put(1005, "María López");
        alumnos.put(1006, "Javier Ruiz");
        alumnos.put(1007, "Lucía Torres");
        alumnos.put(1008, "Sergio Morales");
        alumnos.put(1009, "Isabel Sánchez");
        alumnos.put(1010, "Diego Navarro");

        System.out.println("Nº alumnos: "+alumnos.size());

        System.out.println("Introdzca un numero de expediente: ");
        int prueba= sc.nextInt();
        if(alumnos.containsKey(prueba)){
            System.out.println(alumnos.get(prueba));
        }else System.out.println("no");


        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println("Intorduzca el numero del alumno que quiere borrar: ");

            try {
                numero = sc.nextInt();
                valido = true;  // Si llega aquí, el número es válido
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número entero válido.");
                sc.next(); // Limpia el buffer del scanner para evitar bucle infinito
            }
        }
        alumnos.remove(numero);
        System.out.println("Se ha borrao");

        System.out.println("Nº alumnos: "+alumnos.size());


    }

}
