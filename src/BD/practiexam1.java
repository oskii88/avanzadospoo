package BD;

import java.sql.*;
import java.util.Scanner;

public class practiexam1 {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rs =null;
        String bd = "nba";
        String url = "jdbc:mysql://localhost:3306/" + bd   ;
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
            String sql = "select nombre,ciudad,conferencia from productos;";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                /*Acceso a los campos de la tabla*/
                int nom = rs.getInt("nombre");
                String ciu = rs.getString("ciudad");
                String con = rs.getString("conferencia");
                System.out.println(nom+" "+ciu+" "+con);

            }
            programa(stmt,rs);
        }
    }

    private static void programa(Statement stmt, ResultSet rs) throws SQLException {
        int opcion = 0;

        Scanner sc = new Scanner(System.in);
        do {
            imprimirMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                     mostrarequipos(stmt, rs);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Ha elegido Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }
        } while (opcion != 6);
    }



    private static void agregarProducto(Scanner sc, Statement stmt) throws SQLException {
        /* Creamos y ejecutamos la consulta INSERT */
        System.out.print("Dame el nombre del producto: ");
        String nom= sc.nextLine();
        System.out.print("Dame la categoría del producto: ");
        String cat= sc.nextLine();
        System.out.print("Dame el precio del producto: ");
        int pre= sc.nextInt();
        System.out.println("Dame el stock del producto: ");
        int sto= sc.nextInt();
        String sql = "insert into productos (nombre, categoria, precio, stock) values ('"+nom+"', '"+cat+"', "+pre+", "+sto+");";
        int numResultados = stmt.executeUpdate(sql);
        if(numResultados > 0){
            System.out.println("Se han actualizado "+numResultados+" filas de la BD");
        }else {
            System.out.println("No se ha modificado la BD");
        }
    }

    private static void mostrarequipos(Statement stmt, ResultSet rs) throws SQLException {
        /*Consulta*/
        String sql = "select nombre,ciudad,conferencia from productos;";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            /*Acceso a los campos de la tabla*/
            int nom = rs.getInt("nombre");
            String ciu = rs.getString("ciudad");
            String con = rs.getString("conferencia");
            System.out.println(nom+" "+ciu+" "+con);

        }
        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }

    private static void imprimirMenu() {
        System.out.println("Menu de opciones");
        System.out.println("1. Mostrar productos");
        System.out.println("2. Agregar producto");
        System.out.println("3. Modificar precio de producto");
        System.out.println("4. Actualizar stock de producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
    }
}


