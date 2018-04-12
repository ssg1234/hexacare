package com.hexa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hexa.dao.HexaCareRemote;
import com.hexa.dao.NotFoundException;

/**
 * @author Monisha
 * @author Harshini
 * @version 1.0
 *          <p>
 *          This class provides controller methods for viewing
 *          </p>
 */

@Controller
public class ViewController {
	@Autowired
	private HexaCareRemote dao;

	/**
	 * @return Main
	 *         <p>
	 *         / or /main which is the main page
	 *         </p>
	 */
	@RequestMapping(value = { "/", "/main" })
	public String displayHome() {

		return "Main";
	}

	/**
	 * @param model
	 *            Model instance
	 * @return DoctorView
	 *         <p>
	 *         Displays the doctor details
	 *         </p>
	 */
	@RequestMapping("/viewdocs")
	public String displayDoctors(Model model) {
		model.addAttribute("doclist", dao.showDoctors());
		return "DoctorView";
	}

	/**
	 * @param model
	 *            Model instance
	 * @return SpecView
	 *         <p>
	 *         Displays the Specialization details
	 *         </p>
	 */
	@RequestMapping("/viewspec")
	public String displaySpecialization(Model model) {
		model.addAttribute("speclist", dao.showSpecializations());
		return "SpecView";
	}

	/**
	 * @param model
	 *            Model instance
	 * @return HistoryView
	 *         <p>
	 *         Displays appointment details
	 *         </p>
	 */
	@RequestMapping("/viewhistory")
	public String displayAllHistory(Model model) {
		model.addAttribute("hislist", dao.showHistory());
		return "HistoryView";
	}

	/**
	 * @return PatientHis
	 *         <p>
	 *         To provide contact number
	 *         </p>
	 */
	@RequestMapping("/patientlog")
	public String displayByPhn() {
		return "PatientHis";
	}

	/**
	 * @param num
	 *            Contact Number
	 * @param model
	 *            Model instance
	 * @return HistoryView
	 * @throws NotFoundException
	 *             <p>
	 *             Display the patient appointment details from given contact number
	 *             </p>
	 */
	@RequestMapping("/patienthistory")
	public String historyByContact(@RequestParam("txtnum") long num, Model model) throws NotFoundException {
		model.addAttribute("hislist", dao.showPatientHistory(num));
		return "HistoryView";

	}

	/**
	 * @param ex
	 *            NotFoundException instance
	 * @return ModelAndView
	 *         <p>
	 *         If any exception occurs controller navigates to the error page
	 *         </p>
	 */
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleException(NotFoundException ex) {
		return new ModelAndView("MyErr", "err", ex.getMessage());
	}
}
