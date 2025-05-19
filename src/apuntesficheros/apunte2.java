package apuntesficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class apunte2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta;

        while (true) {
            System.out.println("Introduzca una ruta del sistema de archivos");
            ruta = sc.nextLine()+"\\";

            if (ruta.isEmpty()) {
                System.out.println("no hay na mi rei");
                break;
            }

            try {

                File archivo = new File(ruta);


                //cambiarNombre(base+"DOCS",base +"Documentos");
                //cambiarNombre(base+"DOCS/Fotografias",base +"DOCS/FOTOS");
                //cambiarNombre(base+"DOCS/Libros",base +"DOCS/LECTURAS");

                //quitarExtension(base+"DOCS/FOTOS");
                //quitarExtension(base+"DOCS/LECTURAS");

                //crearCarpeta(ruta+ "/Mis Cosas");
                //crearCarpeta(ruta+ "/Alfabeto");

                //moverCarpeta(ruta + "FOTOS", ruta + "Mis Cosas/Fotografias");
                //moverCarpeta(ruta + "LECTURAS", ruta + "Mis Cosas/Libros");


                // 3. Crear subcarpetas A-Z en "Alfabeto"

                /*
                for (char letra = 'A'; letra <= 'Z'; letra++) {
                crearCarpeta(ruta + "Alfabeto/" + letra);
                }
                */

                //System.out.println(borraTodo(ruta+ "Alfabeto"));


                //muestraInfoRuta2(archivo, true);

                break;

            } catch (Exception e) {
                System.out.println("Error al acceder a la ruta: " + e.getMessage());
            }
        }
        sc.close();
    }

    public static void mostrarInformacion(File f) {

        if (!f.exists()) {
            System.out.println("la ruta no existe");
            return;
        }

        System.out.println("Ruta absoluta: " + f.getAbsolutePath());
        System.out.println("Es archivo?: " + f.isFile());
        System.out.println("es directorio?: " + f.isDirectory());
        System.out.println("Esta oculto?: " + f.isHidden());
        System.out.println("Se puede escirbir?: " + f.canWrite());
        System.out.println("Se puede leer? :" + f.canRead());
        System.out.println("Tamaño en bytes: " + f.length());

        if (f.isDirectory()) {
            File[] archivos = f.listFiles();

            if (archivos != null) {
                System.out.println("Contenido del directorio: ");
                for (File sub : archivos) {
                    System.out.println(sub.getName());
                }
            } else {
                System.out.println("no se puede acceder al contenido");
            }
        }
    }

    public static void muestraInfoRuta(File f) throws FileNotFoundException {

        if (!f.exists()) {
            throw new FileNotFoundException("la ruta no existe");
        }

        if (f.isFile()) {
            System.out.println("El nombre del archivo es: " + f.getName());
        } else if (f.isDirectory()) {
            File[] contenido = f.listFiles();

            if (contenido != null) {
                System.out.println("Contenido del directorio: ");

                // mostrar los directorios
                for (File f1 : contenido) {
                    if (f1.isDirectory()) {
                        System.out.println("directorios: " + f1.getName());
                    }
                }

                // mostrar los archivos
                for (File f1 : contenido) {
                    if (f1.isFile()) {
                        System.out.println("archivos: " + f1.getName());
                    }
                }
            }
        } else {
            System.out.println("No se puede acceder al contenido");
        }
    }

    public static void muestraInfoRuta2(File f, boolean info) throws FileNotFoundException {

        if (!f.exists()) {
            throw new FileNotFoundException("la ruta no existe");
        }
        //archivo
        if (f.isFile()) {
            System.out.println("El nombre del archivo es: " + f.getName());

            //ultima fecha y tamaño
            if(info){
                System.out.println("Tamaño en bytes: "+f.length());


                long ultiamModificaion=f.lastModified();
                Date fecha=new Date(ultiamModificaion);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                System.out.println("Ultima fecha de modificacion: "+formato.format(fecha));
            }

            //fichero
        } else if (f.isDirectory()) {
            File[] contenido = f.listFiles();

            //ultima fecha y tamaño
            if(info){
                System.out.println("Tamaño en bytes: "+f.length());


                long ultiamModificaion=f.lastModified();
                Date fecha=new Date(ultiamModificaion);
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                System.out.println("Ultima fecha de modificacion: "+formato.format(fecha));
            }

            if (contenido != null) {
                Arrays.sort(contenido);
                System.out.println("Contenido del directorio: ");

                // mostrar los directorios
                for (File f1 : contenido) {
                    if (f1.isDirectory()) {
                        System.out.println(f1.getName());
                    }
                }

                // mostrar los archivos
                for (File f1 : contenido) {
                    if (f1.isFile()) {
                        System.out.println(f1.getName());
                    }
                }
            }
        }

    }
    //cambiar nombre
    public static void cambiarNombre(String rutaActual, String nuevaRuta)throws FileNotFoundException{

        File actual = new File(rutaActual);
        File nuevo = new File(nuevaRuta);

        if(actual.exists()){

            boolean renombrado=actual.renameTo(nuevo);

            if(renombrado){
                System.out.println("Se le ha cambiado el nombre");
            }else{
                System.out.println("no se ha podido cambiar el nombre");
            }
        }else{
            System.out.println("No existe");
        }
    }

    //quitar extensiones
    public static void quitarExtension(String rutaCarpeta) throws FileNotFoundException{

        File carpeta= new File(rutaCarpeta);

        if(carpeta.exists() && carpeta.isDirectory()){
            File [] archivos = carpeta.listFiles();

            if(archivos!=null){

                for(File archivo: archivos){
                    if(archivo.isFile()){
                        String nombre=archivo.getName();
                        int punto= nombre.lastIndexOf(".");

                        if(punto>0){

                            String nuevoNombre=nombre.substring(0, punto);
                            File nuevoArchivo = new File(archivo.getParent(), nuevoNombre);

                            if(archivo.renameTo(nuevoArchivo)){
                                System.out.println("renombrado");
                            }else{
                                System.out.println("no se ha podiddo renombrar");
                            }

                        }
                    }

                }


            }else{
                System.out.println("carpeta no valida");
            }
        }
    }

    public static void crearCarpeta(String ruta){

        //ruta dnd quiero crear la carpeta
        File carpeta= new File(ruta);
        if(!carpeta.exists()){
            if(carpeta.mkdirs()){
                System.out.println("carpeta creada");
            }else{
                System.out.println("no se pudo crear la carpeta");
            }
        }else{
            System.out.println("la carpeta ya existe");
        }
    }

    public static void moverCarpeta(String origenRuta, String destinoRuta){
        File origen = new File(origenRuta);
        File destino= new File(destinoRuta);

        if(origen.exists()){
            if(origen.renameTo(destino)){
                System.out.println("Carpeta movida");
            }else{
                System.out.println("No se pudo mover");
            }
        }else{
            System.out.println("No existe");
        }
    }

    public static boolean borraTodo(String ruta)throws FileNotFoundException{

        File f = new File(ruta);

        if(!f.exists()){
            throw new FileNotFoundException("La ruta no existe " + ruta);
        }

        // Si es un directorio, borramos todo su contenido
        if (f.isDirectory()) {
            File[] contenido = f.listFiles();
            if (contenido != null) {
                for (File file : contenido) {
                    // Borrar recursivamente
                    borraTodo(file.getAbsolutePath());
                }
            }
        }

        // Intentar borrar el archivo/directorio (ya vacío si era carpeta)
        boolean borrado = f.delete();
        if (!borrado) {
            System.out.println("No se pudo borrar");
        }
        return borrado;
    }
    }

