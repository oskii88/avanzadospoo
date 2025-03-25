package tema7.ejercicio1;

public class circulo implements Figura2 {
   private int radio;

    public circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return 3.14*radio*radio;
    }

    @Override
    public double perimeter() {
        return 2*3.14*radio;
    }

    @Override
    public void escalar(int escala) {
        radio= escala * radio;
        System.out.println("la escala de circulo a sido ,modificada");
    }

    @Override
    public void imprimir() {
        System.out.println("el circulo tiene un area de " + area() + "y perimtro d e : " + perimeter());
    }
}
