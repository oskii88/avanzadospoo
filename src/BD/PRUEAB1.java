package BD;

import java.sql.*;

public class PRUEAB1 {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        Connection conn;
        try {
            // Cargamos la clase que implementa el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Creamos una nueva conexión a la base de datos "bdpruebas"
            String url = "jdbc:mysql://localhost:3306/nba";
            // Abrimos la conexión con el usuario y la clave correspondiente
            conn = DriverManager.getConnection(url, "root", "")



            // Obtenemos un Statement de la conexión
            stmt = conn.createStatement();
            //consultas
            String sql = "SELECT nombre, ciudad, conferencia, division FROM equipos";
            rs = stmt.executeQuery(sql);

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


