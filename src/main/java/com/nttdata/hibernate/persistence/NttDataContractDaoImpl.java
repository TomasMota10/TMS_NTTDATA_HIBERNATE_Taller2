package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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
public class NttDataContractDaoImpl extends CommonDaoImpl<NttDataContract> implements NttDataContractDaoI {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	public NttDataContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<NttDataContract> searchByCustomerId(final Long customerId) {

		// Consulta.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<NttDataContract> cquery = cb.createQuery(NttDataContract.class);
		final Root<NttDataContract> rootCust = cquery.from(NttDataContract.class);
		final Join<NttDataContract, NttDataCustomer> pJoinCont = rootCust.join("customerId");

		// Where.
		final Predicate pr1 = cb.equal(pJoinCont.getParent().<Long> get("customerId"), customerId);

		// Consulta.

		cquery.select(rootCust).where(pr1);

		// Ejecución de consulta.
		final List<NttDataContract> result = session.createQuery(cquery).getResultList();

		return result;
	}

}
