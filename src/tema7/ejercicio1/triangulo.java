package tema7.ejercicio1;

public class triangulo  implements Figura2{
    private int h;
    private int b;

    public triangulo(int h, int b) {
        this.h = h;
        this.b = b;
    }

    @Override
    public double area() {
        return (double) (b * h) /2;
    }

    @Override
    public double perimeter() {
        return b+h;
    }

    @Override
    public void escalar(double escala) {

    }

    @Override
    public void imprimir() {
        System.out.println("tu triangulo tiene : area de " + area() + " y perimetro de " + perimeter());
    }
}
