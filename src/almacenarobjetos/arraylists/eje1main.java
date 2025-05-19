package almacenarobjetos.arraylists;

import java.util.ArrayList;
import java.util.List;

public class eje1main {
    public static void main(String[] args) {
       // List<persona>lista;
        System.out.println("-------------for__________");
        List<eje1clase> lista1 = new ArrayList<eje1clase>();
       // eje1clase mauri = new eje1clase("laura",16,"f",2);
        lista1.add(new eje1clase("oscar",20, "m", 1));
        lista1.add(new eje1clase("jorge",20, "m", 2));
        lista1.add(new eje1clase("alex",17, "m", 3));
        lista1.add(new eje1clase("sergio",21, "m", 4));
        //recorrer arraylist 2 formas :)
        //indice for
        for(int i=0; i<lista1.size(); i++){
            System.out.println(lista1.get(i).getNombre());
            System.out.println(lista1.get(i).getEdad());
            System.out.println("---------------------------------------");


        }
        System.out.println("-----------   for each------------------");
        //recorrer con un for each
        for(eje1clase persona: lista1){
            System.out.println("prueba2 " + persona.getNombre() + " " + persona.getEdad());
        }

    }
}
