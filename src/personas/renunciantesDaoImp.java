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

public class renunciantesDaoImp implements IrenunciantesDao {
	
	public boolean registrar(renunciantes renunciantes) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO renunciantes values (NULL,'"+renunciantes.getNIF()+"','"+renunciantes.getNombre()+"','"+renunciantes.getApellidos()+"','"+renunciantes.getDireccion()+"','"+renunciantes.getCP()+"','"+renunciantes.getProvincia()+"','"+renunciantes.getTipoacogida()+"','"+renunciantes.getMotivoadopcion()+"')";
		
		try {			
			con=conexionsafe_pets.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase renunciantesDaoImp, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	@Override
	public List<renunciantes> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM renunciantes";
		
		List<renunciantes> listarenunciantes= new ArrayList<renunciantes>();
		
		try {			
			co= conexionsafe_pets.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				renunciantes a=new renunciantes();
				a.setcodrenunciante(rs.getInt(1));
				a.setNIF(rs.getString(2));
				a.setNombre(rs.getString(3));
				a.setApellidos(rs.getString(5));
				a.setDireccion(rs.getString(3));
				listarenunciantes.add(a);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase RenunciantesDaoImp, método obtener");
			e.printStackTrace();
		}
		
		return listarenunciantes;
	}
 
	@Override
	public boolean actualizar(renunciantes renunciantes) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE renunciantes SET NIF= '"+renunciantes.getNIF()+"', Nombre= '"+renunciantes.getNombre()+"',Apellidos='"+renunciantes.getApellidos()+"', Direccion ='"+renunciantes.getDireccion()+"',CP='"+renunciantes.getCP()+"', Provincia ='"+renunciantes.getProvincia()+"',Tipoacogida ='"+renunciantes.getTipoacogida()+"',Motivoadopcion ='"+renunciantes.getMotivoadopcion()+"' WHERE codrenunciante = '"+renunciantes.getcodrenunciante()+"'";
		try {
			connect=conexionsafe_pets.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase renunciantesDaoImp, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	@Override
	public boolean eliminar(renunciantes renunciantes) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM renunciantes WHERE codrenunciante="+renunciantes.getcodrenunciante();
		try {
			connect=conexionsafe_pets.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase renunciantesDaoImp, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}