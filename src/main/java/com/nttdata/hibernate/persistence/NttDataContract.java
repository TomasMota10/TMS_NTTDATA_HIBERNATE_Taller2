package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Table Entity NTTDATA_TH1_CONTRACT
 * 
 * @author tmotasan
 *
 */
@Entity
@Table(name = "NTTDATA_TH1_CONTRACT")
public class NttDataContract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date validityDate;

	private Date expireDate;

	private Double price;

	private NttDataCustomer customerId;

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
	 * @return the validityDate
	 */
	@Column(name = "VALIDITY_DATE", nullable = false)
	public Date getValidityDate() {
		return validityDate;
	}

	/**
	 * @param validityDate
	 *            the validityDate to set
	 */
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	/**
	 * @return the expireDate
	 */
	@Column(name = "EXPIRE_DATE", nullable = false)
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * @param expireDate
	 *            the expireDate to set
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * @return the price
	 */
	@Column(name = "PRICE", nullable = false)
	@Digits(fraction = 2, integer = 4)
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the customerId
	 */
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	public NttDataCustomer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(NttDataCustomer customerId) {
		this.customerId = customerId;
	}
	
	
	
	@Override
	public String toString() {
		return "NttDataContract [validityDate=" + validityDate + ", expireDate=" + expireDate + ", price=" + price + ", customerId=" + customerId + "]\n";
	}

	@Transient
	public Class<?> getClase() {
		return NttDataContract.class;
	}

}
