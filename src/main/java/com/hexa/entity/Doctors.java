package com.hexa.entity;

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
 *          This class is used to represent Doctors.
 *          </p>
 *
 */
@Entity
@Table(name = "doctors")
public class Doctors {

	@Id
	@Column(name = "did")
	private int docId;

	@Column(name = "dname")
	private String dname;

	@Column(name = "demail")
	private String demail;

	@Column(name = "dcontact")
	private long dcontact;

	@ManyToOne
	@JoinColumn(name = "dspecid", referencedColumnName = "specid")
	private Specialization spec;

	@OneToMany(mappedBy = "aptdoc", fetch = FetchType.LAZY) // ---TO FETCH DATA FAST NOT LAZILY
	private Set<Appointment> alist;
	@OneToMany(mappedBy = "schdoc", fetch = FetchType.LAZY) // ---TO FETCH DATA FAST NOT LAZILY
	private Set<DoctorSchedule> dslist;

	/**
	 * 
	 * @return Doctor id
	 *         <p>
	 *         This getter returns the Doctor id of the Doctor.
	 *         </p>
	 */
	public int getDocId() {
		return docId;
	}

	/**
	 * 
	 * @param deptId
	 *            doctor Id
	 *            <p>
	 *            Changes the department Id of this Doctor.
	 *            </p>
	 */
	public void setDocId(int deptId) {
		this.docId = deptId;
	}

	/**
	 * 
	 * @return Doctor name
	 *         <p>
	 *         This getter returns the Doctor name of the Doctor.
	 *         </p>
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * 
	 * @param dname
	 *            doctor name.
	 *            <p>
	 *            Changes the name of this doctor.
	 *            </p>
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	/**
	 * 
	 * @return Doctor Email
	 *         <p>
	 *         This getter returns the Doctor Email of the Doctor.
	 *         </p>
	 */
	public String getDemail() {
		return demail;
	}

	/**
	 * 
	 * @param demail
	 *            doctor email
	 *            <p>
	 *            Changes the email of this Doctor.
	 *            </p>
	 */
	public void setDemail(String demail) {
		this.demail = demail;
	}

	/**
	 * 
	 * @return Doctor contact
	 *         <p>
	 *         This getter returns the Doctor contact of the Doctor.
	 *         </p>
	 */
	public long getDcontact() {
		return dcontact;
	}

	/**
	 * 
	 * @param dcontact
	 *            doctor contact
	 *            <p>
	 *            Changes the contact number of this doctor.
	 *            </p>
	 */
	public void setDcontact(long dcontact) {
		this.dcontact = dcontact;
	}

	public Set<Appointment> getAlist() {
		return alist;
	}

	public Set<DoctorSchedule> getDslist() {
		return dslist;
	}

	public Specialization getSpec() {
		return spec;
	}

	public void setSpec(Specialization spec) {
		this.spec = spec;
	}

	public void setAlist(Set<Appointment> alist) {
		this.alist = alist;
	}

	public void setDslist(Set<DoctorSchedule> dslist) {
		this.dslist = dslist;
	}

	@Override
	public String toString() {
		return "dId=" + docId + ", dName=" + dname + ", dEmail=" + demail + ", dContact=" + dcontact;
	}

}
