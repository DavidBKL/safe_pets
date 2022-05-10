package adopciones;
import java.util.List;

public interface IadopcionesDao {
	public boolean registrar(adopciones adopciones);
	public List<adopciones> obtener();
	public boolean actualizar(adopciones adopciones);
	public boolean eliminar(adopciones adopciones);
}
