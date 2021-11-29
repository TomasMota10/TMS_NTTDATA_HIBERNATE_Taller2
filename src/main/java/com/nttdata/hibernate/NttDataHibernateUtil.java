package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Configuration class.
 * 
 * @author tmotasan
 *
 */
public class NttDataHibernateUtil {

	/** Session factory*/
	private static final SessionFactory SESSION_FACTORY;

	/**Generate session factory.*/
	static {

		try {

			// Generate configuration.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Throwable ex) {

			// Initialization error.
			System.err.println("[ERROR] Hibernate configuration - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Return the sessions factory.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
