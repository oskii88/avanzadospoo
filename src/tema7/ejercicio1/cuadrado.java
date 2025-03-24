package tema7.ejercicio1;

public class cuadrado implements  Figura2{
    private int lado;

    public cuadrado(int lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado*lado;
    }

    @Override
    public double perimeter() {

        return lado*4;
    }

    @Override
    public void escalar(int escala) {
        int  escal=escala;
        lado=escal*lado;

    }

    @Override
    public void imprimir() {
       System.out.println("este cuadrado tiene "+area()+ "M^2"+perimeter()+ "M");
    }
}
