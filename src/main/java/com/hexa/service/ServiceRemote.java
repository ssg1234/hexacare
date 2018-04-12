package com.hexa.service;

import com.hexa.entity.Appointment;

/**
 * @author Harshini
 * @author Monisha
 *         <p>
 *         Interface to provide a method to check availability of the doctor to
 *         book appointments.
 *         </p>
 *
 */
public interface ServiceRemote {

	public int checkAvailability(Appointment apt);
}
