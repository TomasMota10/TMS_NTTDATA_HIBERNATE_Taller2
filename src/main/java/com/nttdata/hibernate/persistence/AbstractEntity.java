package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * TMS_NTTDATA_HIBERNATE_Taller2
 * 
 * Abstract Entity.
 * 
 * @author tmotasan
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Audit | Update user. */
	private String updatedUser;

	/** Audit | Update day. */
	private Date updatedDate;

	/**
	 * @return the updatedUser
	 */
	@Column(name="AUDIT_UPDATED_USER", nullable=false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser
	 *            the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name="AUDIT_UPDATED_DATE", nullable=false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
