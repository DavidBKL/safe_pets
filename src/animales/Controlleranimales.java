package animales;

import java.util.ArrayList;
import java.util.List;

public class Controlleranimales {
	
	private Viewanimales vista= new Viewanimales();
	
	public Controlleranimales() {
	}
	
	
	public void registrar(animales animales ) {
		IanimalesDao dao= new  animalesDaoImpl();
		dao.registrar(animales);
	}
	
	
	public void actualizar(animales animales) {
		IanimalesDao dao= new  animalesDaoImpl();
		dao.actualizar(animales);
	}
	
	
	public void eliminar(animales animales) {
		IanimalesDao dao= new  animalesDaoImpl();
		dao.eliminar(animales);
	}
	
	
	public void veranimales(){
		List<animales> animales = new ArrayList<animales>();
		IanimalesDao dao= new  animalesDaoImpl();
		animales=dao.obtener();

	}
	
	
	
}

