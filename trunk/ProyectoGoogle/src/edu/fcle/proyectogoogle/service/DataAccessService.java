package edu.fcle.proyectogoogle.service;

import java.util.Map;

public interface DataAccessService {
	
	/**
	 * <b>Método que devuelve los datos de un Cliente encontrado, 
	 * sino lo encuentra retorna null</b>
	 * @param usuario
	 * @param clave
	 * @return  Map<key, value>  key(String): llave  value(String): valor
	 */
	Map<String,String> loginCliente(String usuario, String clave);
}
