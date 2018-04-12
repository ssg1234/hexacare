package com.hexa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hexa.entity.Appointment;
import com.hexa.entity.DoctorSchedule;
import com.hexa.entity.Doctors;

import com.hexa.entity.Specialization;

/**
 * 
 * 
 * @author Monisha
 * @author Harshini
 * @version 1.0
 *          <p>
 *          It is used to perform crud operations.
 *          </p>
 */
@Repository("mydao")
public class HexaCareImplementation implements HexaCareRemote {
	private Logger logger = LoggerFactory.getLogger("empapp");
	private SessionFactory sfac;

	@Autowired
	public void setSfac(SessionFactory sfac) {

		this.sfac = sfac;
	}

	/**
	 * @return list of Doctors
	 *         <p>
	 *         This method returns a list of Doctors instances.
	 *         </p>
	 * 
	 */
	@Override
	public List<Doctors> showDoctors() {
		logger.debug("Inside show all doctors method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from Doctors d inner join fetch d.spec";
		Query qry = sess.createQuery(hql);
		List<Doctors> lst = qry.list();
		sess.close();
		return lst;
	}

	/**
	 * 
	 * @return list of Specialization
	 *         <p>
	 *         This method is used to return list of Specialization instances.
	 *         </p>
	 */
	@Override
	public List<Specialization> showSpecializations() {
		logger.debug("Inside show specializations method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from Specialization";
		Query qry = sess.createQuery(hql);
		List<Specialization> lst = qry.list();
		sess.close();
		return lst;
	}

	/**
	 * @param specName
	 *            specialization name
	 * @return list of Doctors
	 *         <p>
	 *         This method returns a list of Doctors for the given specialization
	 *         name.
	 *         </p>
	 */
	@Override
	public List<Doctors> doctorWithSpecialization(String specName) {
		logger.debug("Inside show doctor with specialization method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from Doctors d inner join fetch d.spec s where s.specName=?";

		Query qry = sess.createQuery(hql);
		qry.setString(0, specName);
		List<Doctors> lst = qry.list();
		sess.close();
		return lst;
	}

	/**
	 * @return list of Appointments
	 *         <p>
	 *         This method returns a list of appointments.
	 *         </p>
	 */
	@Override
	public List<Appointment> showHistory() {
		logger.debug("Inside show all patient history method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from Appointment";
		Query qry = sess.createQuery(hql);
		List<Appointment> lst = qry.list();
		sess.close();
		return lst;
	}

	/**
	 * @param mobnum
	 *            mobile number
	 * @return list of Patient History
	 *         <p>
	 *         This method returns a list of appointments for a provided contact
	 *         number.
	 *         </p>
	 * @throws NotFoundException
	 *             <p>
	 *             This method throws NotFoundException.
	 *             </p>
	 */
	@Override
	public List<Appointment> showPatientHistory(long mobnum) throws NotFoundException {
		logger.debug("Inside show particular patient history method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from Appointment where pContactNum=?";

		Query qry = sess.createQuery(hql);
		qry.setLong(0, mobnum);
		List<Appointment> lst = qry.list();
		sess.close();

		if (lst.size() == 0) {
			logger.error("NotFoundException raised");
			throw new NotFoundException("You have no appointments yet ");
		}
		logger.info(lst.toString());

		return lst;

	}

	/**
	 * @param docId
	 *            doctor Id
	 * @return list of DoctorSchedule
	 *         <p>
	 *         This method returns a list of doctor Schedule for the docId.
	 *         </p>
	 */
	@Override
	public List<DoctorSchedule> appointmentSchedule(int docId) {
		logger.debug("Inside show appointmen schedule of a doctor  method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from DoctorSchedule ds inner join fetch ds.schdoc s where s.docId=?";

		Query qry = sess.createQuery(hql);
		qry.setInteger(0, docId);
		List<DoctorSchedule> lst = qry.list();
		sess.close();
		return lst;
	}

	/**
	 * @param apt
	 *            Appointment instance
	 * @return an integer value
	 *         <p>
	 *         return an int value to show whether the row is inserted or not.
	 *         </p>
	 * 
	 */
	@Override
	public int bookAppointment(Appointment apt) {
		logger.debug("Inside book appointment method in dao impl");
		Session sess = sfac.getCurrentSession();

		sess.save(apt);

		System.out.println("Row Inserted");

		return 1;
	}

	/**
	 * @param reducedApt
	 *            reduced appointment days
	 * @param schId
	 *            Schedule Id
	 * @return an integer value
	 *         <p>
	 *         return an int value to show whether the appointment days are updated
	 *         or not.
	 *         </p>
	 * 
	 */
	@Override
	public int updateNoOfAppointment(int reducedApt, int schId) {
		logger.debug("Inside update no of appointment days method in dao impl");
		Session sess = sfac.getCurrentSession();
		DoctorSchedule docs = (DoctorSchedule) sess.get(DoctorSchedule.class, schId);
		docs.setNoOfApt(reducedApt);
		sess.update(docs);

		return 1;
	}

	/**
	 * @param schId
	 *            scheduleId
	 * @return an DoctorSchedule instance
	 *         <p>
	 *         This method returns an DoctorSchedule instance for given schId.
	 */
	@Override
	public DoctorSchedule getScheduleWithId(int schId) {
		logger.debug("Inside get schedule with id method in dao impl");
		Session sess = sfac.openSession();
		String hql1 = " from DoctorSchedule where schId=?";
		Query qry = sess.createQuery(hql1);
		qry.setInteger(0, schId);
		DoctorSchedule dsch = (DoctorSchedule) qry.uniqueResult();
		sess.close();
		return dsch;
	}

	/**
	 * @return list of DoctorSchedule.
	 *         <p>
	 *         This method returns a list of Doctor Schedules .
	 *         </p>
	 */
	@Override
	public List<DoctorSchedule> showSchedule() {
		logger.debug("Inside show all schedule method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from DoctorSchedule";
		Query qry = sess.createQuery(hql);
		List<DoctorSchedule> lst = qry.list();
		sess.close();
		return lst;
	}

	/**
	 * @param specName
	 *            specialization name
	 * @return instance of Specialization.
	 *         <p>
	 *         This method returns an Specialization for given specialization name.
	 *         </p>
	 * 
	 */
	@Override
	public Specialization getSpecialization(String specName) {
		logger.debug("Inside get specialization name method in dao impl");
		Session sess = sfac.openSession();
		String hql = "from Specialization s where specName=?";
		Query qry = sess.createQuery(hql);
		qry.setParameter(0, specName);
		Specialization obj = (Specialization) qry.uniqueResult();
		sess.close();
		return obj;
	}

}
