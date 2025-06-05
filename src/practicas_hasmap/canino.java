package practicas_hasmap;

public class canino extends animalx {
    protected boolean agresivo;
    protected String patron;

    public canino(String nombre, int nummascotas, int precio, boolean agresivo, String patron) {
        super(nombre, nummascotas, precio);
        this.agresivo = agresivo;
        this.patron = patron;
    }

    @Override
    public String toString() {
        return "canino{" +
                "agresivo=" + agresivo +
                ", patron='" + patron + '\'' +
                ", precio=" + precio +
                ", nummascotas=" + nummascotas +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
