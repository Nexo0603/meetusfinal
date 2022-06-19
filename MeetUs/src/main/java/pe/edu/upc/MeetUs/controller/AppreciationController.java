package pe.edu.upc.MeetUs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MeetUs.models.entities.Appreciation;
import pe.edu.upc.MeetUs.models.entities.Guest;
import pe.edu.upc.MeetUs.services.AppreciationService;
import pe.edu.upc.MeetUs.services.GuestService;

@Controller
@RequestMapping("/appreciation")	// GET y POST
@SessionAttributes("{appreciation}")
public class AppreciationController {
	
	@Autowired
	private GuestService guestService;
	

	@GetMapping		//	/students
	public String listAppreciations(Model model) {
		
		try {
			List<Appreciation> appreciations = AppreciationService.getAll();
			model.addAttribute("appreciations", appreciations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "appreciations/list-appreciations";
	}
	
	@GetMapping("new")	//	/students/new
	public String newAppreciation(Model model) {
		Appreciation appreciation = new Appreciation();
		model.addAttribute("appreciation", appreciation);
		try {
			List<Guest> careers = guestService.getAll();
			model.addAttribute("careers", careers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "students/new-student";
	}
	
}
