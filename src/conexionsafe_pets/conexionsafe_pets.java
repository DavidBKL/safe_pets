package conexionsafe_pets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionsafe_pets {
	
/*	public static void main(String[] args) {
	 	conexionsafe_pets db = new conexionsafe_pets();
        db.conectar();
    }*/
	
	public static Connection conectar() {
		Connection con = null;
		
		String password = "";
		String usuario = "root";
		


//				+ "&password=" + password;
		try {
			
	//		Class.forName("com.mysql.cj.jdbc.Driver");
			
			String servidor = "jdbc:mysql://localhost/safe_pets?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			con = DriverManager.getConnection(servidor, usuario, password);
			
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}


}