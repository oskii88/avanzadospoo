package almacenarobjetos.ejemplo;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Mascotas> lista;

    public Inventario(){
        lista= new ArrayList<>();
    }

    public void agergarMascota(Mascotas m){
        lista.add(m);
    }

    public void mostararMascotas(){
        for(Mascotas m:lista){
            m.muestra();
        }
    }
    public void mostrarTipoYNombre(){
        for(Mascotas m:lista){
            String tipo=m.getClass().getSimpleName();
            String nombre=m.getNombre();
            System.out.println("Tipo: "+tipo+" Nombre"+nombre);
        }
    }

    public void mostararDatosAnimal(String nombre){
        boolean encontrado=false;

        for(Mascotas m:lista){
            if(m.getNombre().equals(nombre)){
                m.muestra();
                encontrado=true;
                break;
            }
            if(!encontrado) System.out.println("No se ha encontrado a ninguna mascota con ese nombre");
        }
    }

    public void mostrarTodoLosDatos(){
        for(Mascotas m:lista){
            m.muestra();
            System.out.println("----------------------");
        }
    }
    public void insertarAnimales(Mascotas m){
        lista.add(m);
    }

    public void eliminarMascotas(Mascotas m){
        lista.remove(m);
    }

    public void vaciarInventario(){
        lista.clear();
    }
}
