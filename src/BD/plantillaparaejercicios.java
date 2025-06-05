package BD;

import java.sql.*;
import java.util.Scanner;

public class plantillaparaejercicios {
    public static void main(String[] args) {
        Statement stmt = null;
        ResultSet rs = null;
        String bd = "nba";
        String url = "jdbc:mysql://localhost:3306/" + bd;
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            programa(stmt, rs);

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {    //Una mejor forma sería cerrar el ResultSet y el Statement en el finally si queremos
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    System.out.println("Error al cerrar el ResultSet.");
                }
                rs = null;    //Vaciamos la variable para liberarla
            }
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
    //programa
    private static void programa(Statement stmt, ResultSet rs) throws SQLException {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            imprimirMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:



                    break;
                case 2:
                    jugadorBajo(stmt, rs);
                    break;
                case 3:
                    jugadoresLakers(sc);
                    break;
                case 4:
                    jugadorPuntos();
                    break;
                case 5:
                    System.out.println("Ha elegido Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        } while (opcion != 5);


    }

    private static void jugadorPuntos() {
    }

    private static void jugadoresLakers(Scanner sc) {
    }

    private static void jugadorBajo(Statement stmt, ResultSet rs) throws SQLException {
        /*Consulta*/
        String sql = "select nombre from jugadores where altura=(select min(altura) from jugadores);";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            /*Acceso a los campos de la tabla*/
            String nombre = rs.getString("nombre");
            System.out.println("El jugador más bajo es: " + nombre);
        }
        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }

    private static void imprimirMenu() {
        System.out.println("Menu de opciones");
        System.out.println("1. Jugador más alto");
        System.out.println("2. Jugador más bajo");
        System.out.println("3. Jugadores de los Lakers");
        System.out.println("4. Jugador con más puntos");
        System.out.println("5. Salir");
    }
}
