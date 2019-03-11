package gestionUtilisateurs.models.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDAO {
	private static String url = "jdbc:mysql://localhost/gsb-frais";
	
	private static String user = "ts2";
	
	private static String passwd = "ts2";
	
	private static Connection connect = null;
	
	public static Connection getInstance(){
		if (connect == null){
			try{
				connect = DriverManager.getConnection(url, user, passwd);
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return connect;
	}
	
	public static void close(){
		if(connect != null){
			try{
				connect.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
