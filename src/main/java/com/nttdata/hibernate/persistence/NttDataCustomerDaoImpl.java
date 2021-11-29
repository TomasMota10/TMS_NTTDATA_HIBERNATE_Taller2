package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Table DAO implementation NTTDATA_TH1_CUSTOMER
 * 
 * @author tmotasan
 *
 */
public class NttDataCustomerDaoImpl extends CommonDaoImpl<NttDataCustomer> implements NttDataCustomerDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	public NttDataCustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<NttDataCustomer> searchByNameAndSurname(final String name, final String firstSurname, final String secondSurname) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttDataCustomer> cquery = cb.createQuery(NttDataCustomer.class);
		final Root<NttDataCustomer> rootCust = cquery.from(NttDataCustomer.class);

		// Where.
		final Predicate pr1 = cb.equal(rootCust.get("nombre"), name);
		final Predicate pr2 = cb.equal(rootCust.get("primerApellido"), firstSurname);
		final Predicate pr3 = cb.equal(rootCust.get("segundoApellido"), secondSurname);

		// Consulta.

		cquery.select(rootCust).where(cb.and(pr1, pr2, pr3));

		// Ejecución de consulta.
		final List<NttDataCustomer> result = session.createQuery(cquery).getResultList();

		return result;
	}

}
