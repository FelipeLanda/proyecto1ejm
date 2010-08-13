package edu.fcle.proyectogoogle.persistence.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import edu.fcle.proyectogoogle.common.Constants;
import edu.fcle.proyectogoogle.model.bean.Cliente;
import edu.fcle.proyectogoogle.persistence.dao.ClienteDao;
import edu.fcle.proyectogoogle.util.HibernateUtil;

public class ClienteDaoImpl implements ClienteDao{
	
	private static final Log log = LogFactory.getLog(ClienteDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
//			return (SessionFactory) new InitialContext()
//					.lookup("SessionFactory");//SessionFactory
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Cliente transientInstance) {
		log.debug("persisting Cliente instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cliente instance) {
		log.debug("attaching dirty Cliente instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cliente instance) {
		log.debug("attaching clean Cliente instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cliente persistentInstance) {
		log.debug("deleting Cliente instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cliente merge(Cliente detachedInstance) {
		log.debug("merging Cliente instance");
		try {
			Cliente result = (Cliente) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cliente findById(int id) {
		log.debug("getting Cliente instance with id: " + id);
		try {
			Cliente instance = (Cliente) sessionFactory.getCurrentSession()
					.get("edu.fcle.proyectogoogle.model.bean.Cliente", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Map<String, String> findByUserAndPassword(String user, String password) {
		log.debug("getting Cliente instance with user : " + user+" and password: "+password);
		Map<String, String> map=null;
		try {
			Cliente instance = (Cliente)sessionFactory
			.getCurrentSession().createQuery("from Cliente where USUARIO_CLIENTE=? AND CLAVE_CLIENTE=?").
			setString(0, user).setString(1, password).uniqueResult();
			
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
				map=new HashMap<String, String>();
				map.put(Constants.NOMBRES_SERVICE, instance.getApepatCliente()+" "+instance.getApematCliente()+", "+instance.getNombresCliente());
				map.put(Constants.CLAVE_SERVICE, password);
				map.put(Constants.USUARIO_SERVICE, user);
			}
			return map;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cliente> findByExample(Cliente instance) {
		log.debug("finding Cliente instance by example");
		try {
			List<Cliente> results = (List<Cliente>) sessionFactory
					.getCurrentSession().createCriteria(
							"edu.fcle.proyectogoogle.model.bean.Cliente").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

}
