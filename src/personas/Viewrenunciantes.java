package personas;

import java.util.List;

public class Viewrenunciantes {
	public void verrenunciantes(renunciantes renunciantes) {
		System.out.println("Datos del renunciante: "+renunciantes);
	}
	
	public void verrenunciantes(List<renunciantes> renunciantes) {
		for (renunciantes renunciante: renunciantes) {
			System.out.println("Datos del renunciante: "+renunciante);
		}		
	}
}