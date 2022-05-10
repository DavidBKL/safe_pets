package personas;

import java.util.ArrayList;
import java.util.List;

import adopciones.adopciones;
import adopciones.adopcionesDaoImp;
import adopciones.IadopcionesDao;
import adopciones.Viewadopciones;

public class Controllerrenunciantes {
	
private Viewrenunciantes vista= new Viewrenunciantes();
	
	public Controllerrenunciantes() {
	}
	
	//llama al DAO para guardar un renunciante
	public void registrar(renunciantes renunciantes ) {
		IrenunciantesDao dao= new renunciantesDaoImp();
		dao.registrar(renunciantes);
	}
	
	//llama al DAO para actualizar un renunciante
	public void actualizar(renunciantes renunciantes) {
		IrenunciantesDao dao= new renunciantesDaoImp();
		dao.actualizar(renunciantes);
	}
	
	//llama al DAO para eliminar un renunciante
	public void eliminar(renunciantes renunciantes) {
		IrenunciantesDao dao= new renunciantesDaoImp();
		dao.eliminar(renunciantes);
	}
	
	//llama al DAO para obtener todos los renunciantes y luego los muestra en la vista
	public void verrenunciantes(){
		List<renunciantes> renunciantes = new ArrayList<renunciantes>();
		IrenunciantesDao dao= new renunciantesDaoImp();
		renunciantes=dao.obtener();
//		vista.verrenunciantes(renunciantes);
	}
	
}
