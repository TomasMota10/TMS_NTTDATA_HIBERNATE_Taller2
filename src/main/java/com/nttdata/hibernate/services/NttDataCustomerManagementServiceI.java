package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NttDataCustomer;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Interfaz del servicio de Clientes.
 * 
 * @author tmotasan
 *
 */
public interface NttDataCustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final NttDataCustomer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final NttDataCustomer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final NttDataCustomer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param customerId
	 */
	public NttDataCustomer searchById(final Long customerId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @param customerId
	 * @return List<NttDataCustomer>
	 */
	public List<NttDataCustomer> searchAll();

	/**
	 * Obtiene un cliente por su nombre completo.
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return List<NttDataCustomer>
	 */
	public List<NttDataCustomer> searchByFullName(final String name, final String firstSurname, final String secondSurname);

}
