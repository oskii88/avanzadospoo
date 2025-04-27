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
            System.out.println("4. acabar programa");
            System.out.println("introduce la opcion");
            opcion = sc.nextInt();
             int modificador=0;
             int operacion=0;

            switch (opcion) {
                case 1:

                    System.out.println("introduce el numero que se va  modificadar ");
                    modificador = sc.nextInt();

                  break;
                  case 2:
                      System.out.println("pon la cantidad que modifiacara a ese numero");
                      operacion = sc.nextInt();
                      break;
                      case 3:
                          System.out.println("pon 1 para suma 2 para multiplicacion 3 division");
                           operacion = sc.nextInt();
                          System.out.println("ahora si 1.codificaras o 2.descodificaras");
                          int cod = sc.nextInt();
                          if(cod == 1){
                              if(operacion == 1){
                                  if(cod == 1){

                                      Cifrador.suma(modificador,operacion);
                                  }else {
                                       Cifrador.dessuma(modificador,operacion);
                                  }


                              } else if (operacion == 2) {
                                  if (cod == 1){
                                            Cifrador.multiplicaion(modificador,operacion);
                                  }else{
                                      Cifrador.desciframult(modificador,operacion);
                                  }

                              }else {
                                  if(cod == 1){
                                      Cifrador.division(modificador,operacion);
                                  }else {
                                      Cifrador.decodifidiv(modificador,operacion);
                                  }

                              }

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

