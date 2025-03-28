package tema7.ejercicio2;

public class Cifrador {



    public static void multiplicaion (int a, int b) {
         int c = a*b;
        System.out.println("tu numero es " +c );
    }
    public static void desciframult (int a, int b) {
        int c = a*b;
        c= c/b;
        System.out.println("tu numero es " +c );

    }
    public static void suma(int a, int b) {
        int c= a+b;
        System.out.println("tu numero es " +c );

    }
    public static void dessuma (int a, int b) {

        int c = a+b;
        c=c-b;
        System.out.println("tu numero es " +c );
    }
    public static void division (int a, int b) {
       int c= a / b;
    }
    public static void   decodifidiv (int a, int b) {
        int c=a/b;
        c=c*b;
        System.out.println("tu numero es " +c );
    }
}
