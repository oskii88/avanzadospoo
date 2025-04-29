package tema7.ejercicio3;

public class llamadalocal extends llamadas {
      private double costeloc;
      private double horasloc;
    public llamadalocal(int numeroin, int duracion, int numdestino,double costeloc,double horasloc) {
        super(numeroin, duracion, numdestino);
        this.costeloc = 0.50 ;
        this.horasloc = this.costeloc ;
    }

    public double getCosteloc() {
        return costeloc;
    }

    public double getHorasloc() {
        return horasloc;
    }

    public void setHorasloc(double horasloc) {
        this.horasloc = horasloc;
    }
}
