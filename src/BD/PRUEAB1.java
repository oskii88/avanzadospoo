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
            boolean fin = false;
            while (fin == false) {
                int opcion = 0;
                System.out.println("introduce la opcion");
                System.out.println("1.El jugador mas alto de la NBA");
                System.out.println("2.El jugador mas bajo de la NBA");
                System.out.println("3.Jugadores de los Leakers ");
                System.out.println("4.Jugador con ma puntos ");
                System.out.println("5. finalizar");
                switch (opcion) {
                    case 1:      String sql = "SELECT nombre, ciudad, conferencia, division FROM jugadores WHERE altura =(SELECT max(altura)from jugadores))";
                    rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String n = rs.getString("Nombre");
                            String c = rs.getString("Ciudad");
                            String co = rs.getString("Conferencia");
                            String di  = rs.getString("Division");
                            System.out.println( n + " " + c + " " + co + " " + di);
                        }
                        break;
                    case 2:
                        String e

                                = "SELECT nombre, ciudad, conferencia, division FROM jugadores WHERE altura =(SELECT max(altura)from jugadores))";
                        //rs = stmt.executeQuery(sql);

                }
            }







            //consultas


// Como deberíamos obtener resultados, recorremos el ResultSet y mostramos sus datos
            while (rs.next()) {
                String n = rs.getString("Nombre");
                String c = rs.getString("Ciudad");
                String co = rs.getString("Conferencia");
                String di  = rs.getString("Division");
                System.out.println( n + " " + c + " " + co + " " + di);
            }

// Cerramos el ResultSet, el Statement y la conexión
            rs.close();
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


