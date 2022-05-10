package personas;

import java.util.List;

public class Viewadoptantes {
	public void veradoptantes(adoptantes adoptante) {
		System.out.println("Datos del adoptante: "+adoptante);
	}
	
	public void veradoptantes(List<adoptantes> adoptantes) {
		for (adoptantes adoptante : adoptantes) {
			System.out.println("Datos del adoptante: "+adoptante);
		}		
	}
}