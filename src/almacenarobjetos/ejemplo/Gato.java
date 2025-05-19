package almacenarobjetos.ejemplo;


    public class Gato extends Mascotas{

        private String color;
        private boolean peloLargo;

        public Gato(String color, boolean peloLargo,String nombre,int edad, String estado, String fechaNacimiento){

            super(nombre, edad, estado, fechaNacimiento);
            this.color=color;
            this.peloLargo=peloLargo;
        }
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isPeloLargo() {
            return peloLargo;
        }

        public void setPeloLargo(boolean peloLargo) {
            this.peloLargo = peloLargo;
        }

        public  void muestra() {

        }
        public String habla(){
            return "hola";
        }

    }


