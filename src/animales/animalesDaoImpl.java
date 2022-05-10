package animales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import conexionsafe_pets.conexionsafe_pets; 
 

public class animalesDaoImpl implements IanimalesDao {	
	
	@Override
	public boolean registrar(animales animales) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO animales values (NULL,'"+animales.getcodrenunciante()+"','"+animales.getEspecie()+"','"+animales.getNombre()+"','"+animales.getEdad()+"','"+animales.getRaza()+"','"+animales.getVacunas()+"','"+animales.getObservaciones()+"','"+animales.getcaracteristicas()+"','"+animales.getsexo()+"','"+animales.gettamano()+"')";
		
		try {			
			con=conexionsafe_pets.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase animalesDaoImp, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	@Override
	public List<animales> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM animales ORDER BY IDANIMAL";
		
		List<animales> listaanimales= new ArrayList<animales>();
		
		try {			
			co= conexionsafe_pets.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				animales a=new animales();
				a.setidanimal(rs.getInt(1));
				a.setcodrenunciante(rs.getInt(2));
				a.setEspecie(rs.getString(3));
				a.setNombre(rs.getString(4));
				a.setEdad(rs.getString(5));
				a.setRaza(rs.getString(6));
				a.setVacunas(rs.getString(7));
				a.setObservaciones(rs.getString(8));
				a.setcaracteristicas(rs.getString(9));
				a.setsexo(rs.getString(10));
				a.settamano(rs.getString(11));
				
				listaanimales.add(a);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase animalesDaoImp, método obtener");
			e.printStackTrace();
		}
		
		return listaanimales;
	}
 
	@Override
	public boolean actualizar(animales animales) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE animales SET Nombre='"+animales.getNombre()+"', Edad='"+animales.getEdad()+"', Raza='"+animales.getRaza()+"', Vacunas='"+animales.getVacunas()+"', Observaciones='"+animales.getObservaciones()+"', caracteristicas='"+animales.getcaracteristicas()+"', sexo='"+animales.getsexo()+"', tamano='"+animales.gettamano()+"'" +" WHERE idanimal="+animales.getidanimal();
		try {
			connect=conexionsafe_pets.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase animalesDaoImp, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	@Override
	public boolean eliminar(animales animales) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM animales WHERE idanimal="+animales.getidanimal();
		try {
			connect=conexionsafe_pets.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase animalesDaoImp, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}
