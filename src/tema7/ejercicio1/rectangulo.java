package tema7.ejercicio1;

public class rectangulo implements Figura2 {
    private int ancho;
    private int alto;

    public rectangulo(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return alto * ancho;
    }

    @Override
    public double perimeter() {
        return 2*alto+2*ancho;
    }



    @Override
    public void imprimir() {
        System.out.println("este recangulo tiene un : area de " + area() + "perimetro de : " + perimeter());
    }
}
