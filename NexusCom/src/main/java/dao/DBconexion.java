package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconexion {

	public static Connection instance = null;

	public DBconexion() {

	}


	public static Connection getConnection() throws SQLException {



			instance = DriverManager.getConnection("jdbc:mysql://localhost:3360/nexuscom", "root","");

			return instance;

	}

}
