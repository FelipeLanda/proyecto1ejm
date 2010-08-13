package edu.fcle.proyectogoogle.persistence.dao;

// Generated 12/08/2010 09:38:35 PM by Hibernate Tools 3.3.0.GA

import java.util.List;
import java.util.Map;
import edu.fcle.proyectogoogle.model.bean.Cliente;

/**
 * Home object for domain model class Cliente.
 * @see edu.fcle.proyectogoogle.model.bean.Cliente
 * @author Hibernate Tools
 */
public interface ClienteDao {

	public void persist(Cliente transientInstance);

	public void attachDirty(Cliente instance);

	public void attachClean(Cliente instance);

	public void delete(Cliente persistentInstance);

	public Cliente merge(Cliente detachedInstance);

	public Cliente findById(int id);
	
	public Map<String, String> findByUserAndPassword(String user, String password);

	public List<Cliente> findByExample(Cliente instance);
}
