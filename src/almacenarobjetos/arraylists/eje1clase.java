package almacenarobjetos.arraylists;

public class eje1clase {
    private String nombre;
    private int edad;
    private String sexo;
    private int nuero;

    public eje1clase(String nombre, int edad, String sexo, int nuero) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.nuero = nuero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNuero() {
        return nuero;
    }

    public void setNuero(int nuero) {
        this.nuero = nuero;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
