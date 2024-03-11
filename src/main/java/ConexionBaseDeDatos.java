import java.sql.*;

public class ConexionBaseDeDatos {

    // URL de conexión, reemplaza 'your_database', 'username' y 'password' con los valores adecuados
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String username = "sys as sysdba";
    private static String password = "lorenzo";

    private static Connection connection;

    public static Connection  crearConexion(){

    // Cargar el driver JDBC
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
        System.out.println("No se pudo cargar el driver JDBC");
        e.printStackTrace();
    }

    // Establecer la conexión
        try {
        //1. CREAR OBEJTO connection
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Conexión establecida correctamente");
        // Realiza aquí tus operaciones con la base de datos
        } catch (
        SQLException e) {
            System.out.println("Error al establecer la conexión");
            e.printStackTrace();
        }
        return connection;
    }
    public static void cerrarConexion(Connection connection) throws SQLException {
        try {
            connection.close();
            System.out.println("BASE DE DATOS CERRADA CORRECTAMENTE");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
