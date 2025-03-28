package tema7.ejercicio2;

import java.util.Scanner;

public class mains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("el siguiente menu te xplicara las opciones para usar el cifrador y el descifrador dependiendo de uno de los 3 tipos");
        boolean bucle = false;
        int tipo ;
        int opcion;
        while (!bucle) {
            System.out.println("introduce el tipo 1 multiplicaion 2 suma 3 division ");
            System.out.println("menu:");
            System.out.println("1. introducir numero que va a modificar");
            System.out.println("2. cantidad numerica que modificara al numero");
            System.out.println("3. TIPO + codificar y descodificar");
            System.out.println("4. imprimir resultados ");
            System.out.println("5. acabar programa");
            System.out.println("introduce la opcion");
            opcion = sc.nextInt();


            switch (opcion) {
                case 1:
                    int modicador=0;
                    System.out.println("introduce el numero que se va  modificadar ");
                   modicador = sc.nextInt();

                  break;
                  case 2:
                      System.out.println("pon la cantidad que modifiacara a ese numero");
                      int cantidad = sc.nextInt();
                      break;
                      case 3:
                          System.out.println("pon 1 para suma 2 para multiplicacion 3 division");
                          int operacion = sc.nextInt();
                          System.out.println("ahora si 1.codificaras o 2.descodificaras");
                          int cod = sc.nextInt();
                          if(cod == 1){
                              if(operacion == 1){

                              } else if (operacion == 2) {

                              }else {}

                          }else
                          break;
                              case 4:
                                  System.out.println("ADIOS!!!!!!!!!!!!!!!");
                                  bucle=true;
                                  break;


            }

        }
    }
}

