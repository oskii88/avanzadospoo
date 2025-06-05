package practicabasesdatos;

import java.sql.*;
import java.util.Scanner;

public class Pract1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Statement stmt = null;
        ResultSet rs = null;
        String bd = "ex3ev";
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
                      modulalum(stmt, rs);
                      modul(stmt, rs);
                    break;
                case 2:
                        alumnsuspensos(stmt, rs);

                    break;
                case 3:
                    alumnsinsupen(stmt, rs);

                    break;
                case 4:
                    modificarHorasModulo(stmt, rs
                    );

                    break;
                case 5:
                    listarAlumnosHorasLectivas(stmt, rs);
                case 6:
                    borraralumnos(stmt, rs);
                    break;
                    case 7:
                        System.out.println("Ha elegido Salir");
                        break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (opcion != 5);


    }



    private static void modulalum(Statement stmt, ResultSet rs) throws SQLException {
        /*Consulta*/
        System.out.println("Alumnos:");
        String sql = "select id,nombre,apellidos from alumnos";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            /*Acceso a los campos de la tabla*/
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");

            System.out.println(id + " " + nombre + " " + apellidos);
        }

        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }
    private static void modul(Statement stmt, ResultSet rs) throws SQLException {
        /*Consulta*/
        System.out.println("Modulos:");
        String ql = "select id,nombre,horas from modulos";
        rs = stmt.executeQuery(ql);

        while (rs.next()) {
            /*Acceso a los campos de la tabla*/
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String horas = rs.getString("horas");
            System.out.println(id + " " + nombre + " " + horas);
        }

        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }
    private static void alumnsuspensos(Statement stmt, ResultSet rs) throws SQLException {
        /*Consulta*/
        String qllo = "select a.nombre, a.apellidos, m.nombre from alumnos a JOIN modulosSuspensos ms ON a.id=ms.idAlumno JOIN modulos m ON ms.idModulo=m.id;";
        rs = stmt.executeQuery(qllo);

        while (rs.next()) {
            String nombre = rs.getString("a.nombre");
            String apellidos = rs.getString("a.apellidos");
            String m = rs.getString("m.nombre");
                    System.out.println("El alumno: " + nombre + " " + apellidos + " " +" tiene suspenso: "+ m);

            /*Acceso a los campos de la tabla*/

        }

        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }
    private static void alumnsinsupen(Statement stmt, ResultSet rs) throws SQLException {
        /*Consulta*/
        String llo = "select id,nombre ,apellidos from alumnos where id NOT IN (SELECT idAlumno from modulosSuspensos)";
        rs = stmt.executeQuery(llo);

        while (rs.next()) {

            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            System.out.println(id + " " + nombre + " " + apellidos);
            System.out.println("No estan suspensos");
            /*Acceso a los campos de la tabla*/

        }

        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }
    private static void anñadiralumno(Statement stmt, ResultSet rs) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce el nombre del alumno: ");
        String nome = sc.nextLine();
        System.out.println("introduce el apellido del alumno: ");
        String apelos = sc.nextLine();
        String nw = "INSERT INTO alumnos (nombre,apellidos) VALUES ('" +nome +"' ,'"+apelos+"')";
        int intro =  stmt.executeUpdate(nw);
        if(intro > 0){
            System.out.println("Se han actualizado "+intro+" filas de la BD");
        }else {
            System.out.println("No se ha modificado la BD");
        }
        System.out.println("Hay modulos  suspensos????    1 si  0 no  ");




    }
    private static void modificarHorasModulo(Statement stmt, ResultSet rs) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Indica el nombre del módulo que quieres cambiar: ");
            String nombreModulo = sc.nextLine();
            System.out.print("¿Cuántas horas tendrá ahora?: ");
            int nuevashoras = sc.nextInt();
            sc.nextLine(); //Limpiamos buffer

            /* Creamos y ejecutamos la consulta INSERT */
            String sql = "UPDATE modulos set horas=" + nuevashoras + " WHERE nombre='" + nombreModulo + "'";
            int numResultados = stmt.executeUpdate(sql);
            if (numResultados > 0) {
                System.out.println("Se han actualizado " + numResultados + " filas de la BD");
            } else {
                System.out.println("No se ha modificado la BD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void listarAlumnosHorasLectivas(Statement stmt, ResultSet rs) {
            Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Indica el límite de horas suspensas para buscar: ");
            int horas = sc.nextInt();
            sc.nextLine(); //Limpiamos buffer

            String sql = "select a.nombre, a.apellidos from alumnos a JOIN modulosSuspensos ms ON a.id=ms.idAlumno JOIN modulos m ON ms.idModulo=m.id group by a.id having sum(m.horas)>" + horas + ";";
            rs = stmt.executeQuery(sql);
            System.out.println("Alumnos con más horas de "+horas);
            while (rs.next()) {
                /*Acceso a los campos de la tabla*/
                String nombre = rs.getString("a.nombre");
                String apellidos = rs.getString("a.apellidos");
                System.out.println(nombre + " " + apellidos);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static void borraralumnos(Statement stmt, ResultSet rs) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("nombre del jugador a eliminar");
        String nombre = sc.nextLine();
        System.out.println("apellidos del alumno");
        String apellidos = sc.nextLine();
        String del = "DELETE FROM alumnos WHERE nombre='" + nombre + "' and apellidos ='" + apellidos + "'";
        int numResultados = stmt.executeUpdate(del);
        if (numResultados > 0) {
            System.out.println("Se ha eliminado el alumno: " + numResultados + " fil borrada de la BD");
        } else {
            System.out.println("No se ha borrado de la BD.");
        }


    }


    private static void imprimirMenu() {
        System.out.println("Menu de opciones");
        System.out.println("1. Alumnos y modulos existentes");
        System.out.println("2. mostarar alumnos y sus modulos suspensos");
        System.out.println("3.  Mostrar alumnos sin módulos suspensos.");
        System.out.println("4. Modificar las horas de un módulo.");
        System.out.println("5. Listar alumnos con un numero de horas suspensas");
        System.out.println("6. borrar alumnos sin suspensos");

    }
}

