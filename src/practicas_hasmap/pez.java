package practicas_hasmap;

public class pez extends animalx {
     protected boolean dulce;

    public pez(String nombre, int nummascotas, double precio, boolean dulce) {
        super(nombre, nummascotas, precio);
        this.dulce = dulce;
    }

    @Override
    public String toString() {
        return "pez{" +
                "dulce=" + dulce +
                ", precio=" + precio +
                ", nummascotas=" + nummascotas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
