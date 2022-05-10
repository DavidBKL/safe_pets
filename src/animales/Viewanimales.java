package animales;

import java.util.List;

public class Viewanimales {
	public void verAnimales(animales animal) {
		System.out.println("Datos del animal: "+animal);
	}
	
	public void verAnimales(List<animales> animales) {
		for (animales animal : animales) {
			System.out.println("Datos del animal: "+animales);
		}		
	}
}
