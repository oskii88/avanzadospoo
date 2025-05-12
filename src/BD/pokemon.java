package BD;

import java.sql.*;
import java.util.Scanner;

public class pokemon {
    public static void main(String[] args) {
        Statement stmt = null;
        ResultSet rs = null;
        String bd = "pokemonbd";
        String url = "jdbc:mysql://localhost:3306/pokemonbd" ;
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

                    /*Consulta*/
                    String sql = "select nombre from tipospokemon ";
                    rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        /*Acceso a los campos de la tabla*/
                        String nombre = rs.getString("nombre");
                        System.out.println("los tipos son  " + nombre);
                    }
                    rs.close();    // Cerramos el ResultSet, el Statement y la conexión
                    break;
                case 2:
                    String sl = "select id,nombre,puntosVida,tipo from pokemon";
                    rs = stmt.executeQuery(sl);
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String nombre = rs.getString("nombre");
                        String puntos = rs.getString("puntosVida");
                        String tipo = rs.getString("tipo");
                        System.out.println(id + " " + nombre + " vida: " + puntos + " tipo: " + tipo);

                    }
                    break;
                case 3:
                     String s= "select nombre from pokemon where puntosVida =(SELECT max(puntosVida) FROM pokemon)";
                     rs = stmt.executeQuery(s);
                     while (rs.next()) {
                         String nombre = rs.getString("nombre");
                         System.out.println("el pokemon con la vida mas alto es: " + nombre);
                     }
                    break;
                case 4:

                    System.out.println("introduce el tipo y te pondre que pokemons tienen ese tipo");


                    String tips = "Select p.id,p.nombre,p.puntosVida,t.nombre FROM pokemon p LEFT JOIN tipospokemon t on p.tipo=t.id";
                    rs = stmt.executeQuery(tips);
                    while (rs.next()) {
                        String nombre = rs.getString("nombre");
                        System.out.println("los pokemon con este tipo son: " + nombre);
                    }

                    break;
                case 5:
                    System.out.println("introduce el nombre del pokemon ");
                    String poknom = sc.nextLine();
                    String nompo = "select id,nombre, puntosVida from pokemon where nombre = '" + poknom + "'";
                    rs = stmt.executeQuery(nompo);
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String nombre = rs.getString("nombre");
                        String puntos = rs.getString("puntosVida");
                        System.out.println("tu pokemon es este" + id + " " + nombre + " " + puntos);
                    }
                    break;
                    case 6:
                        System.out.println("introduce un numero de vida");
                        int vid = sc.nextInt();
                        String vda = "select id, nombre, puntosVida from pokemon where puntosVida > '"+ vid +"' " ;
                        rs = stmt.executeQuery(vda);
                        while (rs.next()) {
                            String id = rs.getString("id");
                            String nombre = rs.getString("nombre");
                            String puntos = rs.getString("puntosVida");
                            System.out.println("tu pokemons superiores a esa vida son: " + id + " " + nombre + " " + puntos);

                        }
                        break;
                        case 7:
                            System.out.println("introduce los siguiente datos para tu tipo");
                            System.out.println("nombre  ");
                                String tpo = sc.nextLine();

                                String inser =  "INSERT INTO tipospokemon (nombre) VALUES ('" +tpo +"')";
                                int a =  stmt.executeUpdate(inser);



                                break;





            }
        } while (opcion != 13);


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
        System.out.println("1. Mostrar los tipos existentes");
        System.out.println("2. Mostrar todos los personajes con su id, nombre, vida y tipo.");
        System.out.println("3. Mostrar el pokémon con la mayor cantidad de vida.");
        System.out.println("4. Buscar pokémon por un tipo indicado por el usuario.");
        System.out.println("5. Buscar pokémon por un nombre indicado por el usuario.");
        System.out.println("6. Buscar pokémon con una vida superior a lo indicado por el usuario.");
        System.out.println("7. Insertar un nuevo tipo con datos pedidos al usuario");
        System.out.println("8. Insertar un nuevo pokémon con datos pedidos al usuario, incluído el tipo.");
        System.out.println("9. Modificar el tipo de un pokémon en particular.");
        System.out.println("10. Modificar la vida de un pokémon en particular.");
        System.out.println("11. Eliminar un pokémon.");
        System.out.println("12. Eliminar un tipo (si no tiene ningún pokémon de dicho tipo)");
        System.out.println("13. Eliminar un tipo (sin importar que algún pokémon tenga dicho tipo).\n");
    }
}
