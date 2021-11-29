package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NttDataContract;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Interfaz del servicio de Contratos.
 * 
 * @author tmotasan
 *
 */
public interface NttDataContractManagementServiceI {

	/**
	 * Inserta un nuevo contrato.
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final NttDataContract newContract);

	/**
	 * Actualiza un cliente contrato.
	 * 
	 * @param updatedContract
	 */
	public void updateContract(final NttDataContract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract
	 */
	public void deleteContract(final NttDataContract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID.
	 * 
	 * @param contractId
	 */
	public NttDataContract searchById(final Long contractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @param contractId
	 * @return List<NttDataContract>
	 */
	public List<NttDataContract> searchAll();

	/**
	 * Obtiene un contrato de un cliente determinado por su ID.
	 * 
	 * @param name
	 * @return List<EverisContract>
	 */
	public List<NttDataContract> searchContractsByCustomerId(final Long customerId);

}
