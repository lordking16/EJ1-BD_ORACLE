import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Persona {

    public static ResultSet consultarTablaPersona (Connection connection) throws SQLException {
        //Se crea consulta SQL
        String sql_sentencia = "SELECT * FROM PERSONA";
        ResultSet resultSet = null;
        try {
            //2. CREAR OBJETO STATEMENT, preparar sentencia
            Statement sentencia = connection.createStatement();

            //3. CREAR OBJETO RESULTSET, obtener los registros
            resultSet = sentencia.executeQuery(sql_sentencia);

        } catch (SQLException e) {
            System.out.println("ALGO SALIÓ MAL EN LA CONSULTA");
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void imprimirRegistros (ResultSet resultSet) throws SQLException {
        // Procesar los resultados
        while (resultSet.next()) {
            try {
                // Obtener datos de la fila actual
                BigDecimal id = resultSet.getBigDecimal("ID");
                String name = resultSet.getString("NOMBRE");
                int edad = resultSet.getInt("EDAD");
                // Hacer algo con los datos, por ejemplo, imprimirlos
                System.out.println("ID: " + id + ", Nombre: " + name + ", Edad: " + edad + "\n");
            } catch (SQLException e){
                System.out.println("Alguna columna no tiene el nombre correcto o el tipo de dato no es correcto?");
                e.printStackTrace();
            }

        }
    }
}
