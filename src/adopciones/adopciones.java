package adopciones;

import java.util.Date;
public class adopciones {

	private int codadopcion;
	private int adoptante;
	private int renunciante;
	private Date fechaadopcion;
	private int idanimal;
	
	public adopciones() {
	}

	public adopciones(int codadopcion, Date fechaadopcion,int adoptante, int renunciante,  int idanimal) {
	this.codadopcion = codadopcion;
	this.fechaadopcion = fechaadopcion;
	this.adoptante = adoptante;
	this.renunciante = renunciante;
	this.idanimal = idanimal;
	
	}

	public int getcodadopcion() {
		return codadopcion;
	}
 
	public void setcodadopcion(int codadopcion) {
		this.codadopcion = codadopcion;
	}
 
 
	public Date getfechaadopcion() {
		return fechaadopcion;
	}
 
	public void setfechaadopcion(Date fechaadopcion) {
		this.fechaadopcion = fechaadopcion;
	}	
	
	public int getadoptante() {
		return adoptante;
	}
 
	public void setadoptante(int adoptante) {
		this.adoptante = adoptante;
	}	
	
	public int getrenunciante() {
		return renunciante;
	}
	public void setrenunciante(int renunciante) {
		this.renunciante = renunciante;
	}	
			
	public int getidanimal() {
		return idanimal;
	}
	public void setidanimal(int idanimal) {
		this.idanimal = idanimal;
	}	
	@Override
	public String toString() {
		return this.codadopcion+", "+this.fechaadopcion+", "+this.adoptante+","+this.renunciante+" "+this.idanimal+"";
	
	}
	}