package BD;

import java.sql.*;
import java.util.Scanner;

public class PRUEAB1 {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        Connection conn;
        try {
            // Cargamos la clase que implementa el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Creamos una nueva conexión a la base de datos "bdpruebas"
            String url = "jdbc:mysql://localhost:3306/nba";
            // Abrimos la conexión con el usuario y la clave correspondiente
            conn = DriverManager.getConnection(url, "root", "");



            // Obtenemos un Statement de la conexión
            stmt = conn.createStatement();
            System.out.println("a continuacion veras el menu para sacar la info de los datos de la nba actuales en la base de datos");
            boolean fin = true;
            while (fin) {
                int opcion = 0;

                System.out.println("introduce la opcion");
                System.out.println("1.El jugador mas alto de la NBA");
                System.out.println("2.El jugador mas bajo de la NBA");
                System.out.println("3.Jugadores de los Leakers ");
                System.out.println("4.Jugador con ma puntos ");
                System.out.println("5. finalizar");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:      String sql = "SELECT Nombre, Procedencia, altura, peso FROM jugadores WHERE altura =(SELECT max(altura)from jugadores)";
                    rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String n = rs.getString("Nombre");
                            String c = rs.getString("Procedencia");
                            String co = rs.getString("altura");
                            String di  = rs.getString("peso");
                            System.out.println( n + " " + c + " " + co + " " + di);
                        }
                        break;
                    case 2:


                        String sl  = "INSERT INTO equipos (Nombre,Ciudad,Conferencia,Division) VALUES ('Pucela','Valladolid','West','Europe')";
                        int numresul = stmt.executeUpdate(sl);
                        if (numresul > 0) {
                            System.out.println("se añadio con exito " + numresul + "numer de filas");

                        }else {
                            System.out.println("no se modifico");
                        }
                        break;

                     case 3:
                         fin = false;
                         break;



                }
            }







            //consultas


// Como deberíamos obtener resultados, recorremos el ResultSet y mostramos sus datos

// Cerramos el ResultSet, el Statement y la conexión

            stmt.close();
            conn.close();

        } catch (
                SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        } catch (
                Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Cerramos el ResultSet si no es null
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    System.out.println("Error al cerrar el ResultSet.");
                }
                rs = null; // Vaciamos la variable para liberarla
            }

            // Cerramos el Statement si no es null
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    System.out.println("Error al cerrar el Statement.");
                }
            }
        }
    }
}


