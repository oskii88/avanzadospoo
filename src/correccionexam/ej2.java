package correccionexam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ej2 {
    private static HashMap<String, Ej2Producto> listaProductos = new HashMap();
    public static void main(String[] args) {


    }
    rivate static void pedirProducto(Scanner sc) {
        System.out.print("Dame el nombre del producto a pedir: ");
        String nombre = sc.nextLine();
        if (listaProductos.containsKey(nombre)) {
            //El producto ya estaba
            listaProductos.get(nombre).incrementarUnidades();
        } else {
            //Nuevo producto
            System.out.print("Dame el precio del producto en euros: ");
            double precio = sc.nextDouble();
            sc.nextLine();//Limpiamos buffer
            System.out.print("¿Qué tipo es? (comida, bebida o gominola)");
            String tipo = sc.nextLine();
            Ej2Producto nuevoProducto;
            do {
                if (tipo.equalsIgnoreCase("comida")) {
                    boolean caliente;
                    do {
                        System.out.print("¿La comida es caliente?(si, no)");
                        String comida = sc.nextLine();
                        if (comida.equalsIgnoreCase("si")) {
                            caliente=true;
                            break;
                        } else if (comida.equalsIgnoreCase("no")) {
                            caliente=false;
                            break;
                        } else {
                            System.out.println("No es un tipo válido.");
                        }
                    } while (true);
                    nuevoProducto=new Ej2Comida(nombre, 1, precio, caliente);
                    break;
                } else if (tipo.equalsIgnoreCase("bebida")) {
                    System.out.print("¿Qué cantidad de mililistros contiene la bebida? ");
                    int ml = sc.nextInt();
                    sc.nextLine();//Limpiamos buffer
                    nuevoProducto=new Ej2Bebida(nombre, 1, precio, ml);
                    break;
                } else if (tipo.equalsIgnoreCase("gominola")) {
                    boolean apto;
                    do {
                        System.out.print("¿La gominola es apta para celíacos?(si, no)");
                        String comida = sc.nextLine();
                        if (comida.equalsIgnoreCase("si")) {
                            apto=true;
                            break;
                        } else if (comida.equalsIgnoreCase("no")) {
                            apto=false;
                            break;
                        } else {
                            System.out.println("No es un tipo válido.");
                        }
                    } while (true);
                    nuevoProducto=new Ej2Gominola(nombre, 1, precio, apto);
                    break;
                } else {
                    System.out.println("No es un tipo válido");
                }
            } while (true);
            listaProductos.put(nombre, nuevoProducto);
        }
    }

    private static void eliminarProducto(Scanner sc) {
        System.out.print("Dame el nombre del producto a aliminar: ");
        String nombre = sc.nextLine();
        if (listaProductos.containsKey(nombre)) {
            //El producto ya estaba y se elimina una unidad
            int unidadesRestantes = listaProductos.get(nombre).decrementarUnidades();
            if(unidadesRestantes == 0) {
                //Si se queda en 0 se elimina
                listaProductos.remove(nombre);  //borrar
                System.out.println("Quedan 0 unidades y se elimina el producto.");
            }
        } else {
            //El producto no estaba
            System.out.println("El producto no estaba en el pedido.");
        }
    }

    private static void listarProductos() {
        Iterator<Ej2Producto> coleccion = listaProductos.values().iterator();
        while(coleccion.hasNext()) {
            Ej2Producto prod = coleccion.next();
            if(prod instanceof Ej2Comida){
                System.out.println(prod);
            }
        }
        coleccion = listaProductos.values().iterator();
        while(coleccion.hasNext()) {
            Ej2Producto prod = coleccion.next();
            if(prod instanceof Ej2Bebida){
                System.out.println(prod);
            }
        }
        coleccion = listaProductos.values().iterator();
        while(coleccion.hasNext()) {
            Ej2Producto prod = coleccion.next();
            if(prod instanceof Ej2Gominola){
                System.out.println(prod);
            }
        }
    }

    private static void precioTotal() {
        Iterator<Ej2Producto> coleccion = listaProductos.values().iterator(); // llama a recorrer toda la lista
        double precioTotal=0;
        while(coleccion.hasNext()) {
            precioTotal+= coleccion.next().calcularPrecio();
        }
        System.out.println("El precio total es: "+precioTotal);
    }

    private static void imprimirMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Pedir producto.");
        System.out.println("2. Eliminar producto.");
        System.out.println("3. Listar productos para pedir.");
        System.out.println("4. Calcular precio.");
        System.out.println("5. Salir");
    }
}
