package com.hexa.dao;

import java.util.List;

import com.hexa.entity.Appointment;
import com.hexa.entity.DoctorSchedule;
import com.hexa.entity.Doctors;
import com.hexa.entity.Specialization;

/**
 * @author Harshini
 * @author Monisha
 *         <p>
 *         Interface to provide methods to do CRUD operations.
 *         </p>
 *
 */
public interface HexaCareRemote {
	public List<Doctors> showDoctors();

	public List<Specialization> showSpecializations();

	public List<DoctorSchedule> showSchedule();

	public List<Doctors> doctorWithSpecialization(String specName);

	public List<DoctorSchedule> appointmentSchedule(int docId);

	public List<Appointment> showHistory();

	public List<Appointment> showPatientHistory(long mobnum) throws NotFoundException;

	public int bookAppointment(Appointment apt);

	public DoctorSchedule getScheduleWithId(int schId);

	public int updateNoOfAppointment(int reducedApt, int schId);

	public Specialization getSpecialization(String specName);
}
