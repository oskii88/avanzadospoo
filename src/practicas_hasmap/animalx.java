package practicas_hasmap;

abstract class animalx {
   protected String nombre;
   protected int nummascotas;
   protected double precio;
   public animalx(String nombre, int nummascotas, double precio) {
       this.nombre = nombre;
       this.nummascotas = nummascotas;
       this.precio = precio;
   }
   public double calculaprecio (){return
   nummascotas*precio;}
    public void masmascotas(){
       nummascotas++;

    }
    public int restarmascotas(){
       nummascotas--;
       return nummascotas;
    }


}
