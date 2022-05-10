package personas;

import java.util.ArrayList;
import java.util.List;

import adopciones.adopciones;
import adopciones.adopcionesDaoImp;
import adopciones.IadopcionesDao;
import adopciones.Viewadopciones;

public class Controlleradoptantes {
	
private Viewadoptantes vista= new Viewadoptantes();
	
	public Controlleradoptantes() {
	}
	
	//llama al DAO para guardar un adoptante
	public void registrar(adoptantes adoptante ) {
		IadoptantesDao dao= new  adoptantesDaoImp();
		dao.registrar(adoptante);
	}
	
	//llama al DAO para actualizar un adoptante
	public void actualizar(adoptantes adoptante) {
		IadoptantesDao dao= new adoptantesDaoImp();
		dao.actualizar(adoptante);
	}
	
	//llama al DAO para eliminar un adoptante
	public void eliminar(adoptantes adoptante) {
		IadoptantesDao dao= new adoptantesDaoImp();
		dao.eliminar(adoptante);
	}
	
	//llama al DAO para obtener todos los adoptantes y luego los muestra en la vista
	public void veradoptantes(){
		List<adoptantes> adoptante = new ArrayList<adoptantes>();
		IadoptantesDao dao= new adoptantesDaoImp();
		adoptante=dao.obtener();
//		vista.veradoptantes(adoptantes);
	}
	
}
