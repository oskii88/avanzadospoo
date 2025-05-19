package almacenarobjetos.hasmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        HashMap<String,String> trabajadores= new HashMap<>();
        Scanner sc= new Scanner(System.in);

        trabajadores.put("12345678A", "Laura Gomez");
        trabajadores.put("87654321B", "Carlos Martinez");
        trabajadores.put("13579246C", "Ana Rodriguez");

        System.out.println("Introduzca un nif: ");
        String NIF=sc.nextLine();


        System.out.println("Introduzca un nombre");
        String nombre=sc.nextLine();

        //introducir(NIF, nombre, trabajadores);


        //buscarNIFPorNombre(nombre, trabajadores);

        //modificar(NIF, nombre, trabajadores);

        eliminarPorNombre(nombre, trabajadores);

        System.out.println(trabajadores.size());
    }

    public static HashMap introducir(String NIF,String nombre, HashMap<String,String> trabajadores){

        if(trabajadores.containsKey(NIF) || trabajadores.containsValue(nombre)){
            System.out.println("Ese trabajador ya existe");
        }else{
            trabajadores.put(NIF, nombre);
        }
        return trabajadores;

    }
    public static void buscarTrabajador(String NIF,HashMap<String,String> trabajadores){

        if(trabajadores.containsKey(NIF)){
            System.out.println(trabajadores.get(NIF));
        }else{
            System.out.println("no existe");
        }
    }

    public static void buscarNIFPorNombre( String nombre, HashMap<String, String> trabajadores) {

        boolean encontrado=false;

        for (Map.Entry<String, String> entrada : trabajadores.entrySet()) {
            if (entrada.getValue().equalsIgnoreCase(nombre)) {
                System.out.println(entrada.getKey());  // Devuelve el NIF
                encontrado=true;
                break;
            }
        }if(!encontrado){
            System.out.println("no se encontro"); // No encontrado
        }
    }

    public static void modificar(String NIF,String nombre, HashMap<String,String> trabajadores ){

        if(trabajadores.containsKey(NIF)|| trabajadores.containsValue(nombre)){
            trabajadores.remove(NIF);
            System.out.println("Se ha borrao loko :)");

            trabajadores.put(NIF, nombre);
            System.out.println("Se ha vuelto a crear lokito :)");
        }else{
            System.out.println("no existe");
        }
    }

    public static void eliminarPorNombre(String nombre, HashMap<String, String> trabajadores){

        boolean encontrado=false;

        for (Map.Entry<String, String> entrada : trabajadores.entrySet()) {
            if (entrada.getValue().equalsIgnoreCase(nombre)) {
                System.out.println(entrada.getKey());  // Devuelve el NIF

                trabajadores.remove(entrada.getKey());
                encontrado=true;
                break;
            }
        }if(!encontrado){
            System.out.println("no se encontro"); // No encontrado
        }

    }
}
