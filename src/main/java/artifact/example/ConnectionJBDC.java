package artifact.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJBDC {

	public final static String USER = "postgres";
	public final static String PASS = "Ahola123";
	private static Connection connection;

	public static Connection openConnection() throws Exception {

		try {

			// OBTENEMOS UN OBJETO DE TIPO CONNECTION CON EL DRIVER JDBC
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/telefonica", USER, PASS);

			// RETORNAMOS LA CONEXION YA CARGADA CON LOS PARAMETROS
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	public void closeConnection() throws Exception {
		try {
			// CERRAMOS LA CONEXION ESTATICA
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}

}
