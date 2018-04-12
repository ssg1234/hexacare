package com.hexa.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Harshini
 * @author Monisha
 * @version 1.0
 *          <p>
 *          This class is used to represent DoctorSchedule.
 *          </p>
 *
 */
@Entity
@Table(name = "doctorschedule")
public class DoctorSchedule {

	@Id
	@Column(name = "schid")
	private int schId;
	@Column(name = "schdate")
	private Date schDate;
	@Column(name = "noofapt")
	private int noOfApt;

	@OneToMany(mappedBy = "sch", fetch = FetchType.LAZY) // ---TO FETCH DATA FAST NOT LAZILY
	private Set<Appointment> aptlist;

	@ManyToOne
	@JoinColumn(name = "docid", referencedColumnName = "did")
	private Doctors schdoc;

	/**
	 * 
	 * @return SchId
	 *         <p>
	 *         This getter returns the Schedule Id of the Doctor.
	 *         </p>
	 */
	public int getSchId() {
		return schId;
	}

	/**
	 * 
	 * @param schId
	 *            Schedule Id
	 *            <p>
	 *            Changes the Schedule Id of this Doctor.
	 *            </p>
	 */
	public void setSchId(int schId) {
		this.schId = schId;
	}

	/**
	 * 
	 * @return SchDate
	 *         <p>
	 *         This getter returns the Schedule Date of the Doctor.
	 *         </p>
	 */
	public Date getSchDate() {
		return schDate;
	}

	/**
	 * 
	 * @param schDate
	 *            Schedule Date
	 *            <p>
	 *            Changes the Schedule Date of this Doctor.
	 *            </p>
	 */
	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public int getNoOfApt() {
		return noOfApt;
	}

	public void setNoOfApt(int noOfApt) {
		this.noOfApt = noOfApt;
	}

	public Doctors getSchdoc() {
		return schdoc;
	}

	public void setSchdoc(Doctors schdoc) {
		this.schdoc = schdoc;
	}

	public void setAptlist(Set<Appointment> aptlist) {
		this.aptlist = aptlist;
	}
}
