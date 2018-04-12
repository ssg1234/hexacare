package com.hexa.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hexa.dao.HexaCareRemote;
import com.hexa.entity.Appointment;
import com.hexa.entity.DoctorSchedule;
import com.hexa.entity.Doctors;
import com.hexa.entity.Specialization;
import com.hexa.service.ServiceRemote;

/**
 * @author Harshini
 * @author Monisha
 * @version 1.0
 *          <p>
 *          controller class for booking an appointment
 *          </p>
 *
 */
@Controller
public class ServiceController {

	@Autowired
	private ServiceRemote ser;

	@Autowired
	private HexaCareRemote dao;

	/**
	 * @param model
	 *            Model instance
	 * @return the url AddAptFrm
	 *         <p>
	 *         The AddAptFrm url provides the book appointment page.
	 *         </p>
	 */
	@RequestMapping("/bookapt")
	public String displayAptFrm(Model model) {
		Appointment apt = new Appointment();
		Doctors doc = new Doctors();
		DoctorSchedule dsc = new DoctorSchedule();
		Specialization spec = new Specialization();
		apt.setAptdoc(doc);
		apt.setSch(dsc);
		apt.setSpeci(spec);
		model.addAttribute("aptbean", apt);
		model.addAttribute("spemap", getSpecAsMap());
		model.addAttribute("docmap", getDocAsMap());
		model.addAttribute("schmap", getSchAsMap());

		return "AddAptFrm";
	}

	/**
	 * @param apt
	 *            appointment instance
	 * @param br
	 *            binding result
	 * @param model
	 *            contains all required attributes
	 * @param did
	 *            doctor id
	 * @param schId
	 *            schedule Id
	 * @return an url "AddAptFrm"
	 * @throws IOException
	 *             <p>
	 *             throws IOException
	 *             </p>
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addApt(@Valid @ModelAttribute("aptbean") Appointment apt, BindingResult br, Model model,
			@RequestParam("cbodoc") Integer did, @RequestParam("cboavail") Integer schId) throws IOException {
		if (br.hasErrors()) {
			model.addAttribute("spemap", getSpecAsMap());
			return "AddAptFrm";

		}
		Doctors doctor = new Doctors();
		doctor.setDocId(did);
		DoctorSchedule sch = new DoctorSchedule();
		sch.setSchId(schId);
		System.out.println("schId" + schId);
		apt.setAptdoc(doctor);
		apt.setSch(sch);
		int aptdays = ser.checkAvailability(apt);
		System.out.println("aptdays " + aptdays);
		if (aptdays > 0) {
			model.addAttribute("msg", "Appointment booked successfully");
		} else {
			model.addAttribute("msg", "Sorry, No appointments available");
		}
		System.out.println("Inserted successfully");

		return "Main";

	}

	/**
	 * @return map of doctors
	 *         <p>
	 *         provides map of doctors with id and name
	 *         </p>
	 */
	public Map<Integer, String> getDocAsMap() {
		List<Doctors> lst = dao.showDoctors();
		Map<Integer, String> map = new HashMap<>();
		for (Doctors doc : lst) {
			map.put(doc.getDocId(), doc.getDname());
		}
		return map;

	}

	/**
	 * @return map of schedule
	 *         <p>
	 *         provides map of schedule with id and name
	 *         </p>
	 */
	public Map<Integer, Date> getSchAsMap() {
		List<DoctorSchedule> lst = dao.showSchedule();
		Map<Integer, Date> map = new HashMap<>();
		for (DoctorSchedule dsc : lst) {
			map.put(dsc.getSchId(), dsc.getSchDate());
		}
		return map;

	}

	/**
	 * @return map of specializations
	 *         <p>
	 *         provides map of specializations with name
	 *         </p>
	 */
	public Map<String, String> getSpecAsMap() {
		List<Specialization> lst = dao.showSpecializations();
		Map<String, String> map = new HashMap<>();
		for (Specialization spe : lst) {
			map.put(spe.getSpecName(), spe.getSpecName());
		}
		return map;

	}

	/**
	 * @param specName
	 *            specialization name
	 * @param model
	 *            contains all required attributes
	 * @return DocCombo
	 *         <p>
	 *         returns a url which displays the doctors details
	 *         </p>
	 */
	@RequestMapping("/choosespec")
	public String viewDoctor(@RequestParam("spname") String specName, Model model) {
		model.addAttribute("doctlist", dao.doctorWithSpecialization(specName));
		return "DocCombo";
	}

	/**
	 * @param docId
	 *            Doctor Id
	 * @param model
	 *            contains all required attributes
	 * @return AvailCombo
	 */
	@RequestMapping("/choosedoc")
	public String showDoctorSch(@RequestParam("cbodoc") Integer docId, Model model) {
		model.addAttribute("availlist", dao.appointmentSchedule(docId));
		return "AvailCombo";
	}

	/**
	 * @param ex
	 *            IOException
	 * @return ModelAndView
	 */
	@ExceptionHandler(IOException.class)
	public ModelAndView handleRequest(IOException ex) {

		return new ModelAndView("MyErr", "err", ex.getMessage());
	}

}
