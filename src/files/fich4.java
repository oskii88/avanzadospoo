package files;

import java.io.File;

public class fich4 {
    public static void main(String[] args) {
        File fotos = new File("C:/Temp/Fotos"); // Teniendo C:\Temp creado
        boolean mkdirFot = fotos.mkdir();

        if (mkdirFot) {
            System.out.println("Creada carpeta " + fotos.getName() + "? " + mkdirFot);
        } else {
            File doc = new File("C:/Temp/Documento.txt");
            System.out.println("Borrada carpeta " + fotos.getName() + "? " + fotos.delete());
            System.out.println("Borrado archivo " + doc.getName() + "? " + doc.delete());
        }

        File origenDir = new File("C:/Temp/Fotos2");
        origenDir.mkdir();
        File destinoDir = new File("C:/Temp/Fotografias");
        File origenDoc = new File("C:/Temp/Fotografias/Document.txt");
        File destinoDoc = new File("C:/Temp/Document.txt");

        System.out.println("Se ha movido y renombrado la carpeta? " + origenDir.renameTo(destinoDir));
        System.out.println("Se ha movido el documento? " + origenDoc.renameTo(destinoDoc));
    }
}
