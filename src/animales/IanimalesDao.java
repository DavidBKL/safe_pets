package animales;
import java.util.List;

public interface IanimalesDao {
	public boolean registrar(animales animales);
	public List<animales> obtener();
	public boolean actualizar(animales animales);
	public boolean eliminar(animales animales);

}
