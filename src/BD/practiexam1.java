package BD;

import java.sql.*;
import java.util.Scanner;

public class practiexam1 {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        ResultSet rs =null;
        Connection conn=null;
        String bd = "nba";
        String url = "jdbc:mysql://localhost:3306/nba"    ;
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();

            programa(stmt, rs);


        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {//Una mejor forma sería cerrar el ResultSet y el Statement en el finally si queremos
                try {
                    if (rs != null) rs.close();

                } catch (SQLException sqlEx) {
                    System.out.println("Error al cerrar el ResultSet.");
                }
                    //Vaciamos la variable para liberarla


                try {
                    if (stmt != null) stmt.close();

                } catch (SQLException e) {
                    System.out.println("Error al cerrar el Statement." + e.getMessage());
                }
            try {
                if (conn != null) conn.close();   // 3. Por último, Connection
            } catch (SQLException e) {
                System.out.println("Error al cerrar Connection: " + e.getMessage());
            }
                    //Vaciamos la variable para liberarla

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
                     mostrarequipos(stmt);
                    break;
                case 2:
                    jugadoresequip(stmt);
                    break;
                case 3:
                    jugadorpornombre(stmt);

                    break;
                case 4:
                      nuevojugador(stmt);
                    break;
                case 5:
                    modificar_posicion(stmt);
                    break;
                case 6:
                         eliminar_partido(stmt);
                    break;
                    case 7:
                            eliminar_jugadorsin_procedencia(stmt);
                        break;
                        case 8:
                            System.out.println("Ha elegido Salir");
                            System.exit(0);

                            break;
                default:
                    System.out.println("Opcion no valida");

            }
        } while (opcion != 8);
    }




    private static void mostrarequipos(Statement stmt) throws SQLException {
        /*Consulta*/
        String sql = "select nombre,ciudad,conferencia from equipos;";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            /*Acceso a los campos de la tabla*/
            String nom = rs.getString("nombre");
            String ciu = rs.getString("ciudad");
            String con = rs.getString("conferencia");
            System.out.println(nom+" "+ciu+" "+con);

        }
        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }
    private static void jugadoresequip (Statement stmt) throws SQLException {
        /*Consulta*/
        String jug = "select codigo,nombre,procedencia,nombre_equipo from jugadores;";
        ResultSet rs = stmt.executeQuery(jug);
        while (rs.next()) {
            /*Acceso a los campos de la tabla*/
            String codigo = rs.getString("codigo");
            String nom = rs.getString("nombre");
            String pro = rs.getString("procedencia");
            String no = rs.getString("nombre_equipo");
            System.out.println(codigo+ " " +" "+pro+" "+no);

        }
        rs.close();    // Cerramos el ResultSet, el Statement y la conexión
    }

    private static void imprimirMenu() {
        System.out.println("Menu de opciones");
        System.out.println("1. Mostrar equipos");
        System.out.println("2. jugadores y su equipo");
        System.out.println("3. buscar un jugador por su nombre");
        System.out.println("4. insertar nuevo jugador");
        System.out.println("5. Cambiar posicion de jugador");
        System.out.println("6. Eliminar un partido de la liga");
        System.out.println("7. Eliminar jugador sin procedencia por su nombre");
        System.out.println("8. salir");
    }
    private static void jugadorpornombre(Statement stmt) throws SQLException {
        System.out.println("introduce el nombre del juugador y te sacare sus datos ");
        String y = null;
        Scanner sc = new Scanner(System.in);
        try{
        y = sc.nextLine();}
        catch (Exception e){
            System.out.println("Error al ingresar el nombre del juugador");
            sc.nextLine();
        }
        String jugnom="SELECT codigo,nombre,procedencia,altura,peso,posicion,nombre_equipo from jugadores where nombre like '"+y+"'";
        ResultSet rs = stmt.executeQuery(jugnom);
        while (rs.next()) {
            String cod = rs.getString("codigo");
            String nombre = rs.getString("nombre");
            String pro = rs.getString("procedencia");
            String altura = rs.getString("altura");
            String peso = rs.getString("peso");
            String posicion = rs.getString("posicion");
            String nombre_equipo = rs.getString("nombre_equipo");
                System.out.println("id: "+cod + " nombre: " + nombre + " procedencia: "+ pro +" altura: " + altura + " peso: " + peso + " posicion: " + posicion + " nombre_equipo: " + nombre_equipo );

        }

    }
    private static void puntospartidomas (Statement stmt) throws SQLException {
        System.out.println("El jugador con mas puntos por partido es:");
        String puntos ="";
        ResultSet rs = stmt.executeQuery("select j.codigo,j.nombre,e.puntos_por_partido from jugadores j join estadisticas e on e.codigo=j.codigo ;");
        while (rs.next()) {
            String cod = rs.getString("codigo");
            String nombre = rs.getString("nombre");
            String pro = rs.getString("procedencia");


        }
    }
    private static void nuevojugador(Statement stmt) throws SQLException {
        System.out.println("introduce el nombre del juugador :");
        Scanner sc = new Scanner(System.in);
        String bre = sc.nextLine();
        System.out.println("introduce el procedencia del juugador :");
        String pro = sc.nextLine();
        System.out.println("introduce el altura del juugador  en intervalo:");
        String altra = sc.nextLine();
        System.out.println("introduce el peso del juugador :");
        String pso = sc.nextLine();
        System.out.println("introduce el posicion del juugador :");
        String posion = sc.nextLine();
        System.out.println("introduce el nombre del equipo:");
        String nomuipo = sc.nextLine();
        String nw = "INSERT INTO jugadores (nombre,procedencia,altura,peso,posicion,nombre_equipo) VALUES ('" +bre +"' ,'"+pro+"' ,'"+altra+"', '"+pso+"', '"+posion+"' ,'"+nomuipo+"')";
        int intro =  stmt.executeUpdate(nw); //FALTA CODIGO
        if(intro > 0){
            System.out.println("Se han actualizado "+intro+" filas de la BD");
        }else {
            System.out.println("No se ha modificado la BD");
        }

    }
    private static void modificar_posicion(Statement stmt) throws SQLException {
        System.out.println("que jugador quiere modificar la posicion de un jugador:");
        //intenta sacar tambien un listado de todos los jugadores chiqui y no olvidar excepciones:3
        Scanner sc = new Scanner(System.in);
        String bre = sc.nextLine();
        System.out.println("introduce la nueva posicion :");
        String posicionnew = sc.nextLine();
        String mt = "UPDATE jugadores SET posicion = '"+posicionnew+"' WHERE nombre = '"+bre+"'";
        int resultado = stmt.executeUpdate(mt);
        if (resultado > 0) {
            System.out.println("Se ha actualizado correctamente el jugador.");
        } else {
            System.out.println("No se encontró el jugador o no se modificó nada.");
        }
    }
    private static void eliminar_partido(Statement stmt) throws SQLException {
        System.out.println("que jugador quiere eliminar la partido:");
        //mostrar la lista de partidos
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce el codigo del partido: :");
        String part = sc.nextLine();
        String elepart ="DELETE FROM partidos WHERE codigo='"+part+"'";
        int resultado = stmt.executeUpdate(elepart);
        if (resultado > 0) {
            System.out.println("Partido eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún partido con ese código.");
        }

    }
     private static void eliminar_jugadorsin_procedencia(Statement stmt) throws SQLException {
        System.out.println("Introduce el nombre exacto del jugador que deseas eliminar (recuerda que solo lo hara si no tiene procedencia):");
                 Scanner sc = new Scanner(System.in);
                 String nmb = sc.nextLine();
                 //recuerda si esta unido ha otra tabla como  equipos por clave foranea haz otro delete que la elimine
                String sq = "DELETE FROM jugadores WHERE procedencia IS NULL AND nombre = '"+nmb+"'";

                int resultado = stmt.executeUpdate(sq);
                if (resultado > 0) {
                    System.out.println("Se ha actualizado correctamente el jugador.");
                }
                else {
                    System.out.println("no se actualizo correctamente el jugador o bien por el nombre o porque tiene procedencia.");
                }
     }
     //la opcion siguiente seria hacerlo pero sin que tenga valores asignados pero me da pereza ;)

    }




