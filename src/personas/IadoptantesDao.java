package personas;
import java.util.List;

public interface IadoptantesDao {
	public boolean registrar(adoptantes adoptantes);
	public List<adoptantes> obtener();
	public boolean actualizar(adoptantes adoptantes);
	public boolean eliminar(adoptantes adoptantes);

}
