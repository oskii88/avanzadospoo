package TEMAFINALfICHEROS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LECTURAFICHERO1 {
    public static void main(String[] args) {
        File f =new File("fichero.txt");

        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                int a = sc.nextInt();
                System.out.println("persona:" + a);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
    }



    }

