import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ficher {

    public static void main(String[] args) {
            /*Programa que... */
            int resultado = 300;
            File fiche = new File("fichero.txt");

            /*Escritura FileWriter*/
            FileWriter fw = null;
            try {
                fw = new FileWriter(fiche, true);
                fw.write("\n"+resultado);
                fw.close();
            } catch (IOException e) {
                System.out.println("Error al hacer la escritura en el fichero");
            }


            /*Lectura Scanner*/
            Scanner scFich = null;
            try {
                scFich = new Scanner(fiche);
            } catch (FileNotFoundException e) {
                System.out.println("Fichero no encontrado");
            }
            int acum=0;
            while (scFich.hasNext()) {
                int num = scFich.nextInt();
                acum+=num;
                System.out.println("Total parcial: "+acum);
            }
            System.out.println("Total: "+acum);

        }
    }

