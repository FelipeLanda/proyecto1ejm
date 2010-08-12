package edu.fcle.proyectogoogle.view.model;

public class Login {
	private String usuario;
	private String clave;
	private String nombres;
	public Login(String usuario, String clave, String nombres) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.nombres = nombres;
	}
	public Login() {
		super();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	
	
	

}
