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
            String url = "jdbc:mysql://localhost:3306/bdpruebas";

            // Abrimos la conexión con el usuario y la clave correspondiente
            conn = DriverManager.getConnection(url, "root", "1234");

            // Otra opción de apertura de la conexión
            // Connection conn = DriverManager.getConnection(url + "?user=root&password=1234");

            // Obtenemos un Statement de la conexión
            stmt = conn.createStatement();
            // Acá podrías agregar un bloque catch y finally si lo necesitás
            // Creamos y ejecutamos la consulta SELECT sobre la "tablapruebas"
            String sql = "SELECT * FROM tablapruebas";
            rs = stmt.executeQuery(sql);

// También se puede comprobar la sentencia y luego recoger el resultado
// if (stmt.execute(sql)) { rs = stmt.getResultSet(); }

// Como deberíamos obtener resultados, recorremos el ResultSet y mostramos sus datos
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("campo1");
                Date fecha = rs.getDate("campo2");
                System.out.println(id + " " + nombre + " " + fecha);
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


