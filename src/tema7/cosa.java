package tema7;
//estos es del 1
import tema7.ejercicio1.circulo;
import tema7.ejercicio1.cuadrado;
import tema7.ejercicio1.rectangulo;
import tema7.ejercicio1.triangulo;

import java.util.Scanner;

public class cosa {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cuadrado c = null;
        cuadrado c3 = null;
        rectangulo b1 = null;
        rectangulo b2 = null;
        circulo c1 = null;
        circulo c2 = null;
        triangulo u1 = null;
        triangulo u2 = null;
        boolean bucle = false;
        while (!bucle) {
            System.out.println("elige entre estas opciones ");
            System.out.println("1. crear");
            System.out.println("2. VER FIGURAS");
            System.out.println("3. escalar ");
            System.out.println("4. parar programa");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    c = new cuadrado(10);
                    c3 = new cuadrado(25);
                    b1 = new rectangulo(5, 20);
                    b2 = new rectangulo(20, 70);
                    u1 = new triangulo(5, 20);
                    u2 = new triangulo(24, 30);
                    c1 = new circulo(10);
                    c2 = new circulo(25);
                    break;
                case 2:

                    c.imprimir();
                    c3.imprimir();
                    b1.imprimir();
                    b2.imprimir();
                    c2.imprimir();
                    c1.imprimir();
                    u1.imprimir();
                    u2.imprimir();
                    break;
                    case 3:
                        System.out.println("a continuacion introduce la escala en un numero entero" );
                        int scala = sc.nextInt();
                        c.escalar(scala);
                        c1.escalar(scala);
                        c3.escalar(scala);
                        b1.escalar(scala);
                        b2.escalar(scala);
                        c2.escalar(scala);
                        u1.escalar(scala);
                        u2.escalar(scala);
                        break;
                case 4:
                   bucle = true;
                   break;
            }
        }
    }
}
