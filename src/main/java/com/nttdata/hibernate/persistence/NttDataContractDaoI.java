package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Table DAO NTTDATA_TH1_CONTRACT
 * 
 * @author tmotasan
 *
 */
public interface NttDataContractDaoI extends CommonDaoI<NttDataContract> {

	/**
	 * Busca los contratos de un determinado Cliente por ID.
	 * 
	 * @param customerId
	 *            - ID del cliente.
	 * @return List<NttDataContract> - Lista de Contratos.
	 */
	public List<NttDataContract> searchByCustomerId(final Long customerId);

}
