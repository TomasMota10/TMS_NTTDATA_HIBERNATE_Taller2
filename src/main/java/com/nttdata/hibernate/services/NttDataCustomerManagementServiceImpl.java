package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.persistence.NttDataCustomerDaoI;
import com.nttdata.hibernate.persistence.NttDataCustomerDaoImpl;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Implementación del Servicio de Clientes.
 * 
 * @author tmotasan
 *
 */
public class NttDataCustomerManagementServiceImpl implements NttDataCustomerManagementServiceI {

	/** DAO: NTTDATA_TH1_CUSTOMER */
	private NttDataCustomerDaoI customerDao;

	/**
	 * Método Constructor.
	 * 
	 * @param session
	 */
	public NttDataCustomerManagementServiceImpl(final Session session) {
		this.customerDao = new NttDataCustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(final NttDataCustomer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getId() == null) {

			// Insercción del nuevo cliente.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(final NttDataCustomer updatedCustomer) {

		// Verificación de nulidad e inexistencia.
		if (updatedCustomer != null && updatedCustomer.getId() == null) {

			// Actualización o inserción del cliente.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(final NttDataCustomer deletedCustomer) {

		// Verificación de nulidad e inexistencia.
		if (deletedCustomer != null && deletedCustomer.getId() != null) {

			// Borrado del nuevo cliente.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public NttDataCustomer searchById(final Long customerId) {

		// Resultado.
		NttDataCustomer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del cliente por ID.
			customer = customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	public List<NttDataCustomer> searchAll() {

		// Resultado.
		List<NttDataCustomer> list = new ArrayList<NttDataCustomer>();

		// Obtención de clientes.
		list = customerDao.searchAll();

		return list;
	}

	@Override
	public List<NttDataCustomer> searchByFullName(final String name, final String firstSurname, final String secondSurname) {
		
		// Resultado.
		List<NttDataCustomer> list = new ArrayList<NttDataCustomer>();

		// Obtención de clientes.
		list = customerDao.searchByNameAndSurname(name, firstSurname, secondSurname);

		return list;
	}

}
