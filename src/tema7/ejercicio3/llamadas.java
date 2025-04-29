package tema7.ejercicio3;

abstract class llamadas {
   private   int numeroin;
   private   int numdestino;
   private   int duracion ;

    public llamadas(int numeroin, int duracion, int numdestino) {
        this.numeroin = numeroin;
        this.duracion = duracion;
        this.numdestino = numdestino;
    }

    public int getNumeroin() {
        return numeroin;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getNumdestino() {
        return numdestino;
    }

    public void setNumdestino(int numdestino) {
        this.numdestino = numdestino;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNumeroin(int numeroin) {
        this.numeroin = numeroin;
    }
}
