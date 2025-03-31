package ejercicioramd1;

public class HACKIN {
    static java.util.Scanner in;

    public static void casoDePrueba() {
        String constra = in.nextLine();
        String num = "0123456789";
        String num2 = "abcdefghijklmnopqrstuvwxyz";
        String num3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num4 = "+_)(*&^%$#@!./,;{}.";
        if (constra.length() >= 12) {
            for (int i = 0; i < num.length(); i++) {
                if (constra.contains("" + num.charAt(i))) {
                    for (int j = 0; j < num2.length(); j++) {
                        if (constra.contains("" + num2.charAt(j))) {
                            for (int k = 0; k < num3.length(); k++) {
                                if (constra.contains("" + num3.charAt(k))) {
                                    for (int l = 0; l < num4.length(); l++) {
                                        if (constra.contains("" + num4.charAt(l))) {
                                            System.out.println("OK");
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("ERROR");


        // TU CÓDIGO AQUÍ

    } // casoDePrueba

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main
} // class solution

