package practicas_hasmap;

public class felinos extends animalx {
    protected String tipo;

    public felinos(String nombre, int nummascotas, int precio, String tipo) {
        super(nombre, nummascotas, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "felinos{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", nummascotas=" + nummascotas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
