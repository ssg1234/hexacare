package com.hexa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexa.dao.HexaCareRemote;
import com.hexa.entity.Appointment;
import com.hexa.entity.DoctorSchedule;
import com.hexa.entity.Specialization;

/**
 * @author Harshini
 * @author Monisha
 *         <p>
 *         This class is used to provide the check availability functionality.
 *         </p>
 * 
 */
@Service("myser")
public class ServiceHexa implements ServiceRemote {
	@Autowired
	private HexaCareRemote dao;

	/**
	 * @param apt
	 *            Appointment Instance
	 * @return an Integer value
	 *         <p>
	 *         This method provides transaction for booking appointments.
	 *         </p>
	 */
	@Transactional(readOnly = false)
	@Override
	public int checkAvailability(Appointment apt) {
		int res = 0;
		int schId = apt.getSch().getSchId();
		int dId = apt.getAptId();
		String specName = apt.getSpeci().getSpecName();
		System.out.println(schId);

		DoctorSchedule dosc = dao.getScheduleWithId(schId);
		int canBook = dosc.getNoOfApt();
		if (canBook > 0) {
			canBook = canBook - 1;
			res = dao.updateNoOfAppointment(canBook, schId);
		}

		if (res == 1) {

			Specialization speci = dao.getSpecialization(specName);
			apt.setSpeci(speci);
			dao.bookAppointment(apt);
		}

		else
			System.out.println("appointment not available");

		return canBook;

	}
}
