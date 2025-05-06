package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class plantillaselectydeletfacil {
    public static void main(String[] args) {
        Statement stmt = null;
        String bd = "bdpruebas";
        String url = "jdbc:mysql://localhost:3306/"+bd;
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            /* Creamos y ejecutamos la consulta INSERT */
            String sql = "INSERT INTO tablapruebas VALUES(5, 'campo1','2023-01-01')";
            int numResultados = stmt.executeUpdate(sql);
            if(numResultados > 0){
                System.out.println("Se han actualizado "+numResultados+" filas de la BD");
            }else {
                System.out.println("No se ha modificado la BD");
            }
            /* Creamos y ejecutamos la consulta UPDATE */
            sql = "UPDATE tablapruebas set campo2='2025-01-01' WHERE id=5";
            numResultados = stmt.executeUpdate(sql);
            if(numResultados > 0){
                System.out.println("Se han actualizado "+numResultados+" filas de la BD");
            }else {
                System.out.println("No se ha modificado la BD");
            }
            /* Creamos y ejecutamos la consulta DELETE */
            sql = "DELETE FROM tablapruebas WHERE id=5";
            numResultados = stmt.executeUpdate(sql);
            if(numResultados > 0){
                System.out.println("Se han actualizado "+numResultados+" filas de la BD");
            }else {
                System.out.println("No se ha modificado la BD");
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {    //Una mejor forma sería cerrar el ResultSet y el Statement en el finally si queremos
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (
                        SQLException sqlEx) {
                    System.out.println("Error al cerrar el Statement.");
                }
                stmt = null;    //Vaciamos la variable para liberarla
            }
        }
    }
}
