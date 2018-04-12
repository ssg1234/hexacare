package com.hexa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Harshini
 * @author Monisha
 * @version 1.0
 *          <p>
 *          This class is used to represent Appointment.
 *          </p>
 *
 */
@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name = "aptid")
	private int aptId;

	@NotEmpty(message = "Name must be entered")
	@Size(min = 3, max = 20, message = "Name can contain 3 to 20 alphabets")
	@Pattern(regexp = "[a-zA-Z]+", message = "Name must contain only alphabets")
	@Column(name = "pname")
	private String pName;

	@NotNull(message = "Contact number must be entered")
	@Min(value = 1000000, message = "Please enter a valid contact number")
	@Column(name = "pcontactnum")
	private long pContactNum;

	@ManyToOne
	@JoinColumn(name = "docid", referencedColumnName = "did")
	private Doctors aptdoc;

	@ManyToOne
	@JoinColumn(name = "schid", referencedColumnName = "schid")
	private DoctorSchedule sch;
	@ManyToOne
	@JoinColumn(name = "specid", referencedColumnName = "specid")
	private Specialization speci;

	/**
	 * 
	 * @return appointment id of the patient
	 *         <p>
	 *         This getter returns the appointment id of the patient
	 *         </p>
	 */
	public int getAptId() {
		return aptId;
	}

	/**
	 * 
	 * @param aptId
	 *            appointment Id
	 *            <p>
	 *            Changes the appointment Id of this patient.
	 *            </p>
	 */
	public void setAptId(int aptId) {
		this.aptId = aptId;
	}

	/**
	 * 
	 * @return Patient Name for the patient.
	 *         <p>
	 *         This getter returns the patient name .
	 *         </p>
	 */
	public String getpName() {
		return pName;
	}

	/**
	 *
	 * @param pName
	 *            patient name.
	 *            <p>
	 *            Changes the Patient Name of this patient.
	 *            </p>
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * 
	 * @return Contact Number for the patient.
	 *         <p>
	 *         This getter returns the contact number for the patient
	 *         </p>
	 */
	public long getpContactNum() {
		return pContactNum;
	}

	/**
	 * @param pContactNum
	 *            patient contact number.
	 *            <p>
	 *            Changes the Contact Number of this patient
	 *            </p>
	 * 
	 */
	public void setpContactNum(long pContactNum) {
		this.pContactNum = pContactNum;
	}

	/**
	 * @return aptdoc
	 *         <p>
	 *         This getter returns the instance of the doctor object
	 *         </p>
	 */
	public Doctors getAptdoc() {
		return aptdoc;
	}

	public void setAptdoc(Doctors aptdoc) {
		this.aptdoc = aptdoc;
	}

	public DoctorSchedule getSch() {
		return sch;
	}

	public void setSch(DoctorSchedule sch) {
		this.sch = sch;
	}

	public Specialization getSpeci() {
		return speci;
	}

	public void setSpeci(Specialization speci) {
		this.speci = speci;
	}

}
