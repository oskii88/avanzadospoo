package files;
import java.io.File;
public class fich1 {
   public static void main (String[] args) {

           File carpetaAbs = new File("C:/Java/documentos/fotos");    // Rutas absolutas
           File archivoAbs = new File("C:/Java/documentos/fotos/albania1.jpg");
           File carpetaRel = new File("trabajos");                    // Rutas relativas
           File fitxerRel = new File("trabajos/documento.txt");

           mostrarRutas(carpetaAbs);    // Mostramos sus rutas
           mostrarRutas(archivoAbs);
           mostrarRutas(carpetaRel);
           mostrarRutas(fitxerRel);
       }

    public static void mostrarRutas(File f) {
        System.out.println("getParent()        : " + f.getParent());
        System.out.println("getName()          : " + f.getName());
        System.out.println("getAbsolutePath()  : " + f.getAbsolutePath() + "\n");
    }

   }/**/

