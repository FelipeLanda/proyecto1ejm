package edu.fcle.proyectogoogle.view.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import edu.fcle.proyectogoogle.common.Constants;
import edu.fcle.proyectogoogle.common.ServiceFinder;
import edu.fcle.proyectogoogle.service.DataAccessService;
import edu.fcle.proyectogoogle.service.impl.DataAccessServiceImpl;
import edu.fcle.proyectogoogle.view.model.Login;

public class LoginController {
	
	private Logger log=Logger.getLogger(LoginController.class);
	private Login login;
	private DataAccessService dataAccessService;;

	public LoginController() {		
		dataAccessService=new DataAccessServiceImpl();//(DataAccessServiceImpl)ServiceFinder.findBean("dataAccessService");
		login=(Login)ServiceFinder.findBean("login");
	}
	
	public String validarUsuario(){
		log.info("Validando desde el controller");
		Map<String,String> map=dataAccessService.
		loginCliente(login.getUsuario(), login.getClave());
		
		if(map==null){
			log.info("Error al validar clave y usuario");
			return "error";
		}
		login.setNombres(map.get(Constants.NOMBRES_SERVICE));
		log.info("El usuario "+login.getNombres()+" ingresó a session");		
		return "bienvenido";
	}


	public void setLogin(Login login) {
		this.login = login;
	}

	public void setDataAccessService(DataAccessService dataAccessService) {
		this.dataAccessService = dataAccessService;
	}

	public Login getLogin() {
		return login;
	}

	public DataAccessService getDataAccessService() {
		return dataAccessService;
	}

	
	
	
	

}
