package dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Maillist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Maillist
 * @author MyEclipse Persistence Tools
 */
public class MaillistDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MaillistDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String NUMBER = "number";
	public static final String EMAIL = "email";

	public void save(Maillist transientInstance) {
		log.debug("saving Maillist instance");
		try {
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(transientInstance);
			tx.commit();
			session.close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Maillist persistentInstance) {
		log.debug("deleting Maillist instance");
		try {
			Session session = getSession();
			Transaction tx = session.beginTransaction();
			session.delete(persistentInstance);
			tx.commit();
			session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	public Maillist findById(java.lang.Integer id) {
		log.debug("getting Maillist instance with id: " + id);
		try {
			Maillist instance = (Maillist) getSession().get("dao.Maillist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Maillist instance) {
		log.debug("finding Maillist instance by example");
		try {
			List results = getSession().createCriteria("dao.Maillist")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Maillist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Maillist as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findAll() {
		log.debug("finding all Maillist instances");
		try {
			String queryString = "from Maillist";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Maillist merge(Maillist detachedInstance) {
		log.debug("merging Maillist instance");
		try {
			Maillist result = (Maillist) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Maillist instance) {
		log.debug("attaching dirty Maillist instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Maillist instance) {
		log.debug("attaching clean Maillist instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}