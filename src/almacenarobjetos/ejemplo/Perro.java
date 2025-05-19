package almacenarobjetos.ejemplo;

public class Perro extends Mascotas{

    private String raza;
    private boolean pulgas;//true-->tiene pulgas   false-->no tiene

    public Perro(String raza, boolean pulgas, String nombre,int edad, String estado, String fechaNacimiento){

        super(nombre, edad, estado, fechaNacimiento);
        this.raza=raza;
        this.pulgas=pulgas;
    }
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isPulgas() {
        return pulgas;
    }

    public void setPulgas(boolean pulgas) {
        this.pulgas = pulgas;
    }

    public  void muestra() {

    }
    public  String  habla(){
        return "hola";
    }


}

