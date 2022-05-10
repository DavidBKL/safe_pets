package personas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import adopciones.adopciones;
import adopciones.IadopcionesDao;
import conexionsafe_pets.conexionsafe_pets; 

public class adoptantesDaoImp implements IadoptantesDao {
	
	public boolean registrar(adoptantes adoptante) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO adoptantes values (NULL,'"+adoptante.getNIF()+"','"+adoptante.getNombre()+"','"+adoptante.getApellidos()+"','"+adoptante.getDireccion()+"','"+adoptante.getCP()+"','"+adoptante.getProvincia()+"','"+adoptante.getTipoacogida()+"','"+adoptante.getMotivoadopcion()+"')";
		
		try {			
			con=conexionsafe_pets.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase adoptantesDaoImp, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	@Override
	public List<adoptantes> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM adoptantes";
		
		List<adoptantes> listaadoptantes= new ArrayList<adoptantes>();
		
		try {			
			co= conexionsafe_pets.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				adoptantes a=new adoptantes();
				a.setcodadoptante(rs.getInt(1));
				a.setNIF(rs.getString(2));
				a.setNombre(rs.getString(3));
				a.setApellidos(rs.getString(4));
				a.setDireccion(rs.getString(5));
				listaadoptantes.add(a);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase adoptantesDaoImp, método obtener");
			e.printStackTrace();
		}
		
		return listaadoptantes;
	}
 
	@Override
	public boolean actualizar(adoptantes adoptante) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE adoptantes SET NIF= '"+adoptante.getNIF()+"', Nombre= '"+adoptante.getNombre()+"',Apellidos='"+adoptante.getApellidos()+"', Direccion ='"+adoptante.getDireccion()+"',CP='"+adoptante.getCP()+"', Provincia ='"+adoptante.getProvincia()+"',Tipoacogida ='"+adoptante.getTipoacogida()+"',Motivoadopcion ='"+adoptante.getMotivoadopcion()+"' WHERE codadoptante = '"+adoptante.getcodadoptante()+"'";
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
	public boolean eliminar(adoptantes adoptante) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM adoptantes WHERE codadoptante="+adoptante.getcodadoptante();
		try {
			connect=conexionsafe_pets.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase adoptantessDaoImp, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}