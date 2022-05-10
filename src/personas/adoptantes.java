package personas;

public class adoptantes {

private int codadoptante;	
private String NIF;
private String Nombre;
private String Apellidos;
private String Direccion;
private int CP;
private String Provincia;
private String Tipoacogida;
private String Motivoadopcion;
	
	public adoptantes() {
	}
	
	public adoptantes(String NIF, String Nombre, String Apellidos, int CP, String Direccion, String Provincia, String Tipoacogida, String Motivoadopcion) {
		this.NIF = NIF;
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.CP = CP;
		this.Direccion = Direccion;
		this.Provincia = Provincia;
		this.Tipoacogida = Tipoacogida;
		this.Motivoadopcion = Motivoadopcion;
	}
	public int getcodadoptante() {
		return codadoptante;
	}
 
	public void setcodadoptante(int codadoptante) {
	this.codadoptante = codadoptante;
	
	}
	public String getNIF() {
		return NIF;
	}
 
	public void setNIF(	String NIF) {
		this.NIF = NIF;
	}
 
	public String getNombre() {
		return Nombre;
	}
 
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
 
	public String getApellidos() {
		return Apellidos;
	}
 
	public void setApellidos(String Apellidos) {
		this.Apellidos = Apellidos;
	}
	
	public String getDireccion() {
		return Direccion;
	}
 
	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}
	public int getCP() {
		return CP;
	}
 
	public void setCP(int CP) {
		this.CP = CP;
	}
	
	public String getProvincia() {
		return Provincia;
	}
 
	public void setProvincia(String Provincia) {
		this.Provincia = Provincia;
	}
	
	public String getTipoacogida() {
		return Tipoacogida;
	}
 
	public void setTipoacogida(String Tipoacogida) {
		this.Tipoacogida = Tipoacogida;
	}
		
		public String getMotivoadopcion() {
			return Motivoadopcion;
		}
	 
		public void setMotivodeadopcion(String Motivodeadopcion) {
			this.Motivoadopcion = Motivoadopcion;
			
	}
	
	@Override
	public String toString() {
		return this.NIF+", "+this.Nombre+", "+this.Apellidos+", "+this.CP+", "+this.Provincia+", "+this.Tipoacogida+", "+this.Motivoadopcion;
	}

}
