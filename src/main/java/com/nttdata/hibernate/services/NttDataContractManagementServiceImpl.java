package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataContract;
import com.nttdata.hibernate.persistence.NttDataContractDaoI;
import com.nttdata.hibernate.persistence.NttDataContractDaoImpl;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Implementación Servicio de Contratos.
 * 
 * @author tmotasan
 *
 */
public class NttDataContractManagementServiceImpl implements NttDataContractManagementServiceI {

	/** DAO: NTTDATA_TH1_CONTRACT */
	private NttDataContractDaoI contractDao;

	/**
	 * Método Constructor.
	 * 
	 * @param session
	 */
	public NttDataContractManagementServiceImpl(final Session session) {

		this.contractDao = new NttDataContractDaoImpl(session);

	}

	@Override
	public void insertNewContract(final NttDataContract newContract) {

		// Verificación de nulidad e inexistencia.
		if (newContract != null && newContract.getId() == null) {

			// Insercción del nuevo contrato.
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(final NttDataContract updatedContract) {

		// Verificación de nulidad e inexistencia.
		if (updatedContract != null && updatedContract.getId() == null) {

			// Actualización o insercción del contrato.
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(final NttDataContract deletedContract) {

		// Verificación de nulidad e inexistencia.
		if (deletedContract != null && deletedContract.getId() != null) {

			// Borrado del contrato.
			contractDao.insert(deletedContract);
		}

	}

	@Override
	public NttDataContract searchById(final Long contractId) {

		// Resultado.
		NttDataContract contract = null;

		// Verificación de nulidad.
		if (contractId != null) {

			// Obtención del contrato por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;

	}

	@Override
	public List<NttDataContract> searchAll() {

		// Resultado.
		List<NttDataContract> list = new ArrayList<NttDataContract>();

		// Obtención de contratos.
		list = contractDao.searchAll();

		return list;

	}

	@Override
	public List<NttDataContract> searchContractsByCustomerId(final Long customerId) {

		// Resultado.
		List<NttDataContract> list = new ArrayList<NttDataContract>();

		// Obtención de contratos.
		list = contractDao.searchByCustomerId(customerId);

		return list;

	}

}
