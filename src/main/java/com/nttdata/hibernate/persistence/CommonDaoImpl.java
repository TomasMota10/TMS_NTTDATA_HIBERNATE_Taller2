package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 *TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Generic DAO Implementation
 * 
 * @author tmotasan
 *
 */
public class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Class type */
	private Class<T> entityClass;

	/** DB connection session */
	private Session session;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(T paramT) {

		// Confirm active transaction.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insert data.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void update(T paramT) {

		// Confirm active transaction.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Update or insert the data.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void delete(T paramT) {

		// Confirm active transaction.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Delete data.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public T searchById(Long id) {

		// Confirm active transaction.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Get Generic Object by PK.
		T result = session.get(this.entityClass, id);

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Confirm active transaction.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Get all the records from a table.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
