package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Table Entity NTTDATA_TH1_CUSTOMER
 * 
 * @author tmotasan
 *
 */
@Entity
@Table(name = "NTTDATA_TH1_CUSTOMER")
public class NttDataCustomer extends AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long id;

	/** Nombre del cliente */
	private String nombre;

	/** Primer apellido */
	private String primerApellido;

	/** Segundo apellido */
	private String segundoApellido;

	/** DNI del cliente */
	private String dni;

	/** Lista de contratos del cliente */
	private List<NttDataContract> contractList;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the primerApellido
	 */
	@Column(name = "PRIMER_APELLIDO", nullable = false)
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @param primerApellido
	 *            the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return the segundoApellido
	 */
	@Column(name = "SEGUNDO_APELLIDO", nullable = false)
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param segundoApellido
	 *            the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni
	 *            the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the contractList
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
	public List<NttDataContract> getContractList() {
		return contractList;
	}

	/**
	 * @param contractList
	 *            the contractList to set
	 */
	public void setContractList(List<NttDataContract> contractList) {
		this.contractList = contractList;
	}

	@Override
	public String toString() {
		return "NttDataCustomer [nombre=" + nombre + ", primer_apellido=" + primerApellido + ", segundo_apellido=" + segundoApellido + ", dni=" + dni + "]\n";
	}

	@Transient
	public Class<?> getClase() {
		return NttDataCustomer.class;
	}

}
