package adopciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import adopciones.adopciones;
import adopciones.IadopcionesDao;
import conexionsafe_pets.conexionsafe_pets; 

public class adopcionesDaoImp implements IadopcionesDao {
	
	public boolean registrar(adopciones adopciones) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		SimpleDateFormat fechaadopcion= new SimpleDateFormat ("yyyy-MM-dd");
		String fechadeadopcion = fechaadopcion.format(adopciones.getfechaadopcion());
		
		String sql="INSERT INTO adopciones values (NULL,'"+adopciones.getadoptante()+"','"+adopciones.getrenunciante()+"','"+fechadeadopcion+"','"+adopciones.getidanimal()+"')";
		
		try {			
			con=conexionsafe_pets.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase adopcionesDaoImp, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	@Override
	public List<adopciones> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM adopciones";
		
		List<adopciones> listaadopciones= new ArrayList<adopciones>();
		
		try {			
			co= conexionsafe_pets.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				adopciones a=new adopciones();
				a.setcodadopcion(rs.getInt(1));
				a.setfechaadopcion(rs.getDate(4));
				a.setadoptante(rs.getInt(2));
				a.setidanimal(rs.getInt(5));
				a.setrenunciante(rs.getInt(3));
				listaadopciones.add(a);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ArticuloDaoImp, método obtener");
			e.printStackTrace();
		}
		
		return listaadopciones;
	}
 
	@Override
	public boolean actualizar(adopciones adopciones) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE adopciones SET adoptante= '"+adopciones.getadoptante()+"', renunciante= '"+adopciones.getrenunciante()+"',fechaadopcion='"+adopciones.getfechaadopcion()+"', idanimal ='"+adopciones.getidanimal()+"' WHERE codadopcion = '"+adopciones.getcodadopcion()+"'";
		try {
			connect=conexionsafe_pets.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase adopcionesDaoImp, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	@Override
	public boolean eliminar(adopciones adopciones) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM adopciones WHERE codadopcion="+adopciones.getcodadopcion();
		try {
			connect=conexionsafe_pets.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase adopcionesDaoImp, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}