package adopciones;

import java.util.ArrayList;
import java.util.List;

import adopciones.adopciones;
import adopciones.adopcionesDaoImp;
import adopciones.IadopcionesDao;
import adopciones.Viewadopciones;

public class Controlleradopciones {
	
private Viewadopciones vista= new Viewadopciones();
	
	public Controlleradopciones() {
	}
	
	//llama al DAO para guardar una adopcion
	public void registrar(adopciones adopciones ) {
		IadopcionesDao dao= new  adopcionesDaoImp();
		dao.registrar(adopciones);
	}
	
	//llama al DAO para actualizar ua adopcion
	public void actualizar(adopciones adopciones) {
		IadopcionesDao dao= new adopcionesDaoImp();
		dao.actualizar(adopciones);
	}
	
	//llama al DAO para eliminar una adopcion
	public void eliminar(adopciones adopciones) {
		IadopcionesDao dao= new adopcionesDaoImp();
		dao.eliminar(adopciones);
	}
	
	//llama al DAO para obtener todas las adopciones y luego los muestra en la vista
	public void veradopciones(){
		List<adopciones> adopciones = new ArrayList<adopciones>();
		IadopcionesDao dao= new adopcionesDaoImp();
		adopciones=dao.obtener();
//		vista.veradopciones(adopciones);
	}
	
}
