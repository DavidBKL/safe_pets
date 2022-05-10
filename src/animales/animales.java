package animales;

public class animales {
	private int idanimal;
	private int codrenunciante;
	private String Especie;
	private String Nombre;
	private String Edad;
	private String Raza;
	private String Vacunas;
	private String Observaciones;
	private String caracteristicas;
	private String sexo;
	private String tamano;
	
	public animales() {
	}
	
	public animales(int codrenunciante, String Especie, String Nombre, String Edad, String Raza, String Vacunas, String Observaciones, String caracteristicas, String sexo, String tamano) {
		this.idanimal = idanimal;
		this.codrenunciante = codrenunciante;
		this.Especie = Especie;
		this.Nombre = Nombre;
		this.Edad = Edad;
		this.Raza = Raza;
		this.Vacunas = Vacunas;
		this.Observaciones = Observaciones;                                                                         
		this.caracteristicas = caracteristicas;
		this.sexo = sexo;
		this.tamano = tamano;
	}
 
	public int getcodrenunciante() {
		return codrenunciante;
	}
 
	public void setcodrenunciante(int codrenunciante) {
		this.codrenunciante = codrenunciante;
	}
	public String getEspecie() {
		return Especie;
		}
	 
	public void setEspecie(String Especie) {
		this.Especie = Especie;	
	}
	public int getidanimal() {
		return idanimal;
	}
 
	public void setidanimal(int idanimal) {
		this.idanimal = idanimal;
	}
	public String getNombre() {
		return Nombre;
	}
 
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
 
	public String getEdad() {
		return Edad;
	}
 
	public void setEdad(String Edad) {
		this.Edad = Edad;
	}
 
	public String getRaza() {
		return Raza;
	}
 
	public void setRaza(String Raza) {
		this.Raza = Raza;
	}
	
	public String getVacunas() {
		return Vacunas;
	}
 
	public void setVacunas(String Vacunas) {
		this.Vacunas = Vacunas;
	}
	
	public String getObservaciones() {
		return Observaciones;
	}
 
	public void setObservaciones(String Observaciones) {
		this.Observaciones = Observaciones;
	}
	public String getcaracteristicas() {
		return caracteristicas;
	}
 
	public void setcaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getsexo() {
		return sexo;
	}
 
	public void setsexo(String sexo) {
		this.sexo = sexo;
	}
	public String gettamano() {
		return tamano;
	}
 
	public void settamano(String tamano) {
		this.tamano = tamano;
	}
	
	
	@Override
	public String toString() {
		return this.idanimal+", "+this.codrenunciante+","+this.Especie+","+this.Nombre+", "+this.Edad+", "+this.Raza+", "+this.Vacunas+", "+this.Observaciones+", "+this.caracteristicas+", "+this.sexo+", "+this.tamano;
	}


}
