package com.hexa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Harshini
 * @author Monisha
 * @version 1.0
 *          <p>
 *          This class is used to represent Specialization.
 *          </p>
 *
 */
@Entity
@Table(name = "specialization")
public class Specialization {

	@Id
	@Column(name = "specid")
	private int specId;
	@Column(name = "specname")
	private String specName;

	@OneToMany(mappedBy = "spec", fetch = FetchType.LAZY) // ---TO FETCH DATA FAST NOT LAZILY
	private Set<Doctors> dlist;
	@OneToMany(mappedBy = "speci", fetch = FetchType.LAZY) // ---TO FETCH DATA FAST NOT LAZILY
	private Set<Appointment> aptlist;

	public void setDlist(Set<Doctors> dlist) {
		this.dlist = dlist;
	}

	/**
	 * 
	 * @return specId
	 *         <p>
	 *         This getter returns the Specialization Id.
	 *         </p>
	 */
	public int getSpecId() {
		return specId;
	}

	/**
	 * 
	 * @param specId
	 *            Specialization Id
	 *            <p>
	 *            Changes the Specialization id.
	 *            </p>
	 */
	public void setSpecId(int specId) {
		this.specId = specId;
	}

	/**
	 * 
	 * @return specName
	 *         <p>
	 *         This getter returns the Specialization Name.
	 *         </p>
	 */
	public String getSpecName() {
		return specName;
	}

	/**
	 * 
	 * @param specName
	 *            Specialization Name.
	 *            <p>
	 *            Changes the Specialization name.
	 *            </p>
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public void setAptlist(Set<Appointment> aptlist) {
		this.aptlist = aptlist;
	}

}
