package edu.fcle.proyectogoogle.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import edu.fcle.proyectogoogle.common.Constants;
import edu.fcle.proyectogoogle.common.ServiceFinder;
import edu.fcle.proyectogoogle.persistence.dao.ClienteDao;
import edu.fcle.proyectogoogle.persistence.dao.impl.ClienteDaoImpl;
import edu.fcle.proyectogoogle.service.DataAccessService;
import edu.fcle.proyectogoogle.view.model.Login;

public class DataAccessServiceImpl implements DataAccessService{
	
	private Logger log=Logger.getLogger(DataAccessServiceImpl.class);
	private ClienteDao clienteDao; 
	
	public DataAccessServiceImpl(){
		clienteDao=new ClienteDaoImpl();//(ClienteDao)ServiceFinder.findBean("clienteDao");
	}
	
	/**
	 * 
	 * @see edu.fcle.proyectogoogle.service.DataAccessService#loginCliente(java.lang.String, java.lang.String)
	 */
	public Map<String,String> loginCliente(String usuario, String clave){
		
		log.info("validando desde el servicio");
		return clienteDao.findByUserAndPassword(usuario, clave);

	}
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	

}
