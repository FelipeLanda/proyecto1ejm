package edu.fcle.proyectogoogle.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import edu.fcle.proyectogoogle.common.Constants;
import edu.fcle.proyectogoogle.service.DataAccessService;

public class DataAccessServiceImpl implements DataAccessService{
	
	private Logger log=Logger.getLogger(DataAccessServiceImpl.class);
	
	/**
	 * 
	 * @see edu.fcle.proyectogoogle.service.DataAccessService#loginCliente(java.lang.String, java.lang.String)
	 */
	public Map<String,String> loginCliente(String usuario, String clave){
		Map<String, String> map=null;
		log.info("validando desde el servicio");
		if(usuario.equals("locoxkiddy") && clave.equals("331262")){
			map=new HashMap<String, String>();
			map.put(Constants.NOMBRES_SERVICE, "Cristian Landa");
			map.put(Constants.CLAVE_SERVICE, clave);
			map.put(Constants.USUARIO_SERVICE, usuario);
			return map;
		}
		return map;
	}

}
