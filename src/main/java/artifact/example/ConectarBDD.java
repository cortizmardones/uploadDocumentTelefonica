package artifact.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBDD {

	public final static String USER = "postgres";
	public final static String PASS = "Ahola123";

	public static Connection conectar() {

		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/telefonica", USER, PASS);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
