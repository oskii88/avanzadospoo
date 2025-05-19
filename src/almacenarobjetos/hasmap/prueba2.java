package almacenarobjetos.hasmap;

import java.util.HashMap;
import java.util.Map;

public class prueba2 {
    public static void main(String[] args) {
        Map<Integer,String> mapaemple = new HashMap<>();
        mapaemple.put(1, "hey");
        mapaemple.put(2, "oy");
        mapaemple.put(3, "A");
        mapaemple.put(4, "B");
       boolean a= mapaemple.containsValue("y"); //te devuelve si esta es valor o no
        boolean b= mapaemple.containsKey(3);
       System.out.println(a);
       System.out.println(b);
       //devolver vaqlores:
        mapaemple.remove(1); //remueve info del hasmap
        System.out.println(mapaemple.values());
        System.out.println(mapaemple.keySet());

        //metodoget jeje
        String nombre = mapaemple.get(3);
        System.out.println(nombre);

    }



}
