package adopciones;

import java.util.List;

public class Viewadopciones {
	public void veradopciones(adopciones adopciones) {
		System.out.println("Datos de adopcion: "+adopciones);
	}
	
	public void veradopciones(List<adopciones> adopciones) {
		for (adopciones adopcion: adopciones) {
			System.out.println("Datos de adopcion: "+adopciones);
		}		
	}
}