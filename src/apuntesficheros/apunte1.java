package apuntesficheros;

import java.io.*;
import java.nio.file.Files;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class apunte1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaBase = "C:\\Users\\sergi\\Desktop\\Programacion\\Ficheros\\Documentos";

        // Llama a las funciones de prueba aquí si quieres
        // maximoYMinimo(rutaBase + "\\numeros.txt");
    }

    public static void mostrarInformacion(File f) {
         //existe???
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

        // Obtiene la lista de archivos y subdirectorios dentro del directorio 'f'
        File[] archivos = f.listFiles();

// Verifica si la lista no es null (puede ser null si no se tiene permiso para acceder)
        if (archivos != null) {
            // Imprime un mensaje indicando que se va a mostrar el contenido
            System.out.println("Contenido del directorio: ");

            // Recorre cada elemento (archivo o subdirectorio) dentro del arreglo 'archivos'
            for (File sub : archivos) {
                // Imprime el nombre del archivo o subdirectorio
                System.out.println(sub.getName());
            }
        } else {
            // Si no se pudo acceder al contenido del directorio, imprime un mensaje de error
            System.out.println("no se puede acceder al contenido");
        }
    }
    //mostrar infos
    public static void muestraInfoRuta(File f) throws FileNotFoundException {
          //existe????
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
    }  //pilla el maximo y minimo
    public static void maximoYMinimo(String ruta) {
        File archivo = new File(ruta);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean hayNumeros = false;

        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int numero = scanner.nextInt();
                    if (numero > max) max = numero;
                    if (numero < min) min = numero;
                    hayNumeros = true;
                } else {
                    scanner.next();
                }
            }

            if (hayNumeros) {
                System.out.println("Número máximo: " + max);
                System.out.println("Número mínimo: " + min);
            } else {
                System.out.println("No se encontraron números válidos en el archivo.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    public static void notaMediaAlumnos(String ruta) {
        class Alumno {
            String nombre;
            double media;
            Alumno(String n, double m) { nombre = n; media = m; }
        }

        List<Alumno> lista = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(ruta))) {
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(" ");
                String nombre = datos[0] + " " + datos[1];
                double suma = 0;
                for (int i = 2; i < datos.length; i++) {
                    suma += Double.parseDouble(datos[i]);
                }
                double media = suma / (datos.length - 2);
                lista.add(new Alumno(nombre, media));
            }

            lista.sort((a, b) -> Double.compare(b.media, a.media));
            for (Alumno a : lista) {
                System.out.printf("%s -> %.2f\n", a.nombre, a.media);
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    public static void ordenarArchivo(String archivoA, String archivoB) {
        try {
            List<String> lineas = Files.readAllLines(new File(archivoA).toPath());
            Collections.sort(lineas);
            Files.write(new File(archivoB).toPath(), lineas);
            System.out.println("Archivo ordenado guardado en: " + archivoB);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void generarNombresAleatorios(String archivoNombres, String archivoApellidos, int cantidad, String destino) {
        try {
            List<String> nombres = Files.readAllLines(new File(archivoNombres).toPath());
            List<String> apellidos = Files.readAllLines(new File(archivoApellidos).toPath());
            Random rnd = new Random();

            PrintWriter pw = new PrintWriter(new FileWriter(destino, true));
            for (int i = 0; i < cantidad; i++) {
                String nombre = nombres.get(rnd.nextInt(nombres.size()));
                String apellido = apellidos.get(rnd.nextInt(apellidos.size()));
                pw.println(nombre + " " + apellido);
            }
            pw.close();
            System.out.println("Nombres generados guardados en: " + destino);
        } catch (IOException e) {
            System.out.println("Error generando nombres: " + e.getMessage());
        }
    }

    public static void clasificarDiccionario(String rutaDiccionario) {
        File carpeta = new File("Diccionario");
        carpeta.mkdir();

        Map<Character, List<String>> mapa = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            mapa.put(c, new ArrayList<>());
        }

        try (Scanner sc = new Scanner(new File(rutaDiccionario))) {
            while (sc.hasNext()) {
                String palabra = sc.next();
                char inicial = Character.toUpperCase(palabra.charAt(0));
                if (mapa.containsKey(inicial)) {
                    mapa.get(inicial).add(palabra);
                }
            }

            for (char c : mapa.keySet()) {
                PrintWriter pw = new PrintWriter("Diccionario/" + c + ".txt");
                for (String palabra : mapa.get(c)) {
                    pw.println(palabra);
                }
                pw.close();
            }

            System.out.println("Diccionario creado en carpetas por letras.");

        } catch (IOException e) {
            System.out.println("Error procesando diccionario: " + e.getMessage());
        }
    }

    public static void buscarEnPi(String rutaPi, String secuencia) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaPi))) {
            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea.trim());
            }
            String pi = sb.toString();
            boolean encontrado = false;

            for (int i = 0; i <= pi.length() - secuencia.length(); i++) {
                boolean coincide = true;
                for (int j = 0; j < secuencia.length(); j++) {
                    if (pi.charAt(i + j) != secuencia.charAt(j)) {
                        coincide = false;
                        break;
                    }
                }
                if (coincide) {
                    encontrado = true;
                    break;
                }
            }

            System.out.println(encontrado ? "Secuencia encontrada" : "Secuencia no encontrada");

        } catch (IOException e) {
            System.out.println("Error leyendo archivo de Pi: " + e.getMessage());
        }
    }

    public static void estadisticasTexto(String archivo) {
        int lineas = 0, palabras = 0, caracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length();
                String[] tokens = linea.toLowerCase().split("\\W+");
                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        palabras++;
                        frecuencia.put(token, frecuencia.getOrDefault(token, 0) + 1);
                    }
                }
            }

            System.out.println("Líneas: " + lineas);
            System.out.println("Palabras: " + palabras);
            System.out.println("Caracteres: " + caracteres);
            System.out.println("Top 10 palabras más comunes:");
            frecuencia.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue())
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
    public static void lectura(File f1) {
        try {
            Scanner sc = new Scanner(f1);

            while (sc.hasNextInt()) {
                int a = sc.nextInt();
                System.out.println("Dato leído: " + a);
            }

            System.out.println("-----------------------------------");

            // Con un String
            Scanner sc2 = new Scanner(f1);
            while (sc2.hasNextLine()) {
                String a = sc2.nextLine();
                //esto es lo que muestra cada vez que lo lee
                //la a es lo que esta leyendo
                System.out.println("Dato leído con string: " + a);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void escritura(File f1) {
        try {
            FileWriter fw = new FileWriter(f1, true);
            //cada linea que añadas como esta es otra linea que se escriba
            fw.write("" + 49 + "\n");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

