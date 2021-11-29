package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Generic DAO
 * 
 * @author tmotasan
 *
 */
public interface CommonDaoI<T> {

	/**
	 * Insert a record in DB.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Update a record in the DB.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);

	/**
	 * Delete a record in the DB.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);

	/**
	 * Locate a record by ID in the DB.
	 * 
	 * @param paramT
	 */
	public T searchById(final Long id);

	/**
	 * Search all records in DB.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();

}
