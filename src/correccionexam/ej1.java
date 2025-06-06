package correccionexam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la primera cadena: ");
        String primera = sc.nextLine();
        System.out.println("Ingrese la segunda cadena: ");
        String segunda = sc.nextLine();
        String cadenaMenor;
        String cadenaMayor;
        if (primera.length() < segunda.length()) {
            cadenaMenor = primera;
            cadenaMayor = segunda;
        } else {
            cadenaMenor = segunda;
            cadenaMayor = primera;
        }
        //Usamos un booleano, por defecto iguales (true) para ver si algún carácter no es encontrado)
        boolean mismosCaracteres = true;
        //Usamos una variable para saber cuál es el primer carácter no encontrado
        char cDiferente = 'a';
        for (int i = 0; i < cadenaMenor.length(); i++) {
            char busca = cadenaMenor.charAt(i);
            //Para cada carácter se pone un booleano a false (no encontrado), si se pone a true es que lo encuentra
            boolean iguales = false;
            for (int j = 0; j < cadenaMayor.length(); j++) {
                if (busca == cadenaMayor.charAt(j)) {
                    //Carácter encontrado y rompemos bucle
                    iguales = true;
                    break;
                }
            }
            if (!iguales) {
                //Si no se ha encontrado el carácter, es el primero que no es común y salimos
                cDiferente = busca;
                mismosCaracteres = false;
                break;
            }
        }
        File f = new File("datos.txt");
        try {
            FileWriter fw = new FileWriter(f, true);

            if (mismosCaracteres) {
                System.out.println("Los caracteres de la cadena más corta están en la más larga: " + cadenaMenor + ", " + cadenaMayor);
                fw.write("SI " + cadenaMenor + ", " + cadenaMayor + "\n");
            } else {
                System.out.println("No se cumple. La cadena más corta es: " + cadenaMenor);
                System.out.println("El primer carácter diferente es: " + cDiferente);
                fw.write("NO " + cadenaMenor + ", " + cadenaMayor + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            Scanner sc2 = new Scanner(f);
            int contador=0;
            while (sc2.hasNextLine()) {
                sc2.nextLine();
                contador++;
            }
            sc2.close();
            System.out.println("Hasta el momento,se han hecho "+contador+" intentos");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
