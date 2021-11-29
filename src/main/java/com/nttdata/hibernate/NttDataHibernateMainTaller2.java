package com.nttdata.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataContract;
import com.nttdata.hibernate.persistence.NttDataCustomer;
import com.nttdata.hibernate.services.NttDataContractManagementServiceI;
import com.nttdata.hibernate.services.NttDataContractManagementServiceImpl;
import com.nttdata.hibernate.services.NttDataCustomerManagementServiceI;
import com.nttdata.hibernate.services.NttDataCustomerManagementServiceImpl;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Main Class.
 * 
 * @author tmotasan
 *
 */
public class NttDataHibernateMainTaller2 {

	public static void main(String[] args) {

		// Session opening.
		final Session session = NttDataHibernateUtil.getSessionFactory().openSession();

		// Start the contract and customer services.
		final NttDataCustomerManagementServiceI customerService = new NttDataCustomerManagementServiceImpl(session);
		final NttDataContractManagementServiceI contractService = new NttDataContractManagementServiceImpl(session);

		// Audit.
		final String updatedUser = "tmotasan";
		final Calendar uDate = Calendar.getInstance();
		final Date updatedDate = new Date(uDate.getTimeInMillis());

		// Generate new Customers.
		final NttDataCustomer cust1 = new NttDataCustomer();
		cust1.setUpdatedDate(updatedDate);
		cust1.setUpdatedUser(updatedUser);
		cust1.setNombre("Tomás");
		cust1.setPrimerApellido("Mota");
		cust1.setSegundoApellido("Sánchez");
		cust1.setDni("20072402A");

		final NttDataCustomer cust2 = new NttDataCustomer();
		cust2.setUpdatedDate(updatedDate);
		cust2.setUpdatedUser(updatedUser);
		cust2.setNombre("Agustín");
		cust2.setPrimerApellido("Guerrero");
		cust2.setSegundoApellido("Reyes");
		cust2.setDni("85498721A");

		// Generate new Contracts.
		final NttDataContract cont1 = new NttDataContract();
		final GregorianCalendar vdC1 = new GregorianCalendar(2020, 2, 21);
		cont1.setValidityDate(new Date(vdC1.getTimeInMillis()));
		final GregorianCalendar veC1 = new GregorianCalendar(2024, 2, 21);
		cont1.setExpireDate(new Date(veC1.getTimeInMillis()));
		cont1.setPrice(1250.25);
		cont1.setCustomerId(cust1);
		cont1.setUpdatedDate(updatedDate);
		cont1.setUpdatedUser(updatedUser);

		final NttDataContract cont2 = new NttDataContract();
		final GregorianCalendar vdC2 = new GregorianCalendar(2018, 5, 6);
		cont2.setValidityDate(new Date(vdC2.getTimeInMillis()));
		final GregorianCalendar veC2 = new GregorianCalendar(2022, 5, 26);
		cont2.setExpireDate(new Date(veC2.getTimeInMillis()));
		cont2.setPrice(1860.55);
		cont2.setCustomerId(cust2);
		cont2.setUpdatedDate(updatedDate);
		cont2.setUpdatedUser(updatedUser);

		final NttDataContract cont3 = new NttDataContract();
		final GregorianCalendar vdC3 = new GregorianCalendar(2021, 0, 1);
		cont3.setValidityDate(new Date(vdC3.getTimeInMillis()));
		final GregorianCalendar veC3 = new GregorianCalendar(2025, 0, 1);
		cont3.setExpireDate(new Date(veC3.getTimeInMillis()));
		cont3.setPrice(2935.63);
		cont3.setCustomerId(cust1);
		cont3.setUpdatedDate(updatedDate);
		cont3.setUpdatedUser(updatedUser);

		// Insert customers first so there are no problems with FKs.
		customerService.insertNewCustomer(cust1);
		customerService.insertNewCustomer(cust2);

		// Insert new contracts.
		contractService.insertNewContract(cont1);
		contractService.insertNewContract(cont2);
		contractService.insertNewContract(cont3);

		// Contracts are now added to Customers and updated in the table to avoid problems.
		final List<NttDataContract> listContCust1 = new ArrayList<NttDataContract>();
		listContCust1.add(cont1);
		listContCust1.add(cont3);
		cust1.setContractList(listContCust1);

		final List<NttDataContract> listContCust2 = new ArrayList<NttDataContract>();
		listContCust2.add(cont2);
		cust2.setContractList(listContCust2);

		customerService.updateCustomer(cust1);
		customerService.updateCustomer(cust2);

		// Obtain from all customers and contracts. 
		List<NttDataCustomer> custList = customerService.searchAll();
		List<NttDataContract> contList = contractService.searchAll();

		System.out.println(custList);
		System.out.println(contList);

		// Search for a customers by name and the contracts of said client.
		List<NttDataCustomer> searchCust = customerService.searchByFullName("Tomás", "Mota", "Sánchez");
		System.out.println("Customer reference to search:" + searchCust.get(0));
		List<NttDataContract> searchCont = contractService.searchContractsByCustomerId(searchCust.get(0).getId());
		System.out.println("Previous customer contracts: ");
		System.out.println(searchCont);
		
		System.out.println("Customer and contracts at the same time:");
		System.out.println(searchCust.get(0).getContractList());
		

	}

}
