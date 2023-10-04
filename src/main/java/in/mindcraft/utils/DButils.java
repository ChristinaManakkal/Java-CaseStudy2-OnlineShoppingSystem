package in.mindcraft.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
	private static Connection cn;   //private static object-this is connection object
	
	public static Connection openConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/layered_archi";
		cn=DriverManager.getConnection(url,"root","root");
		return cn;
	}
	
	public static void closeConnection() throws SQLException {
		if(cn!=null)
			cn.close();
	}
}
