package personas;
import java.util.List;

public interface IrenunciantesDao {
	public boolean registrar(renunciantes renunciantes);
	public List<renunciantes> obtener();
	public boolean actualizar(renunciantes renunciantes);
	public boolean eliminar(renunciantes renunciantes);

}