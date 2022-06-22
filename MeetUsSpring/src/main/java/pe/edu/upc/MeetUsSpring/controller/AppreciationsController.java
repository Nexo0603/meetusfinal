package pe.edu.upc.MeetUsSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MeetUsSpring.business.crud.AppreciationService;
import pe.edu.upc.MeetUsSpring.business.crud.GuestService;
import pe.edu.upc.MeetUsSpring.model.entity.Appreciation;
import pe.edu.upc.MeetUsSpring.model.entity.Guest;

@Controller
@RequestMapping("/appreciations")
@SessionAttributes("{appreciation}")
public class AppreciationsController {
	@Autowired
	private GuestService guestService;
	@Autowired
	private AppreciationService appreciationService; 

	@GetMapping		//	/appreciations
	public String listAppreciations(Model model) {
		
		try {
			List<Appreciation> appreciations = appreciationService.getAll();
			model.addAttribute("appreciations", appreciations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "appreciations/list-appreciation";
	}
	
	@GetMapping("new")	//	/appreciations/new
	public String newAppreciation(Model model) {
		Appreciation appreciation = new Appreciation();
		model.addAttribute("appreciation", appreciation);
		try {
			List<Guest> guests = guestService.getAll();
			model.addAttribute("guests", guests);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "appreciations/new-appreciation";
	}
	
	@PostMapping("savenew")	//	/appreciations/savenew
	public String saveAppreciation(Model model, @ModelAttribute("appreciation") Appreciation appreciation) {
		try {
			Appreciation AppreciationSaved = appreciationService.create(appreciation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/appreciations";
	}
	
	@GetMapping("{id}/edit")	//	/appreciations/1/edit
	public String editAppreciation(Model model, @PathVariable("id") Integer id) {				
		try {
			if (appreciationService.existsById(id)) {
				Optional<Appreciation> optional = appreciationService.findById(id);
				model.addAttribute("appreciation", optional.get());
				List<Guest> guests = guestService.getAll();
				model.addAttribute("guests", guests);
			} else {
				return "redirect:/appreciations";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "appreciations/edit-appreciations";
	}
	
	@PostMapping("{id}/update")	//	/appreciations/1/update
	public String updateAppreciation(Model model, @ModelAttribute("appreciation") Appreciation appreciation, 
			@PathVariable("id") Integer id) {
		try {
			if (appreciationService.existsById(id)) {
				appreciationService.update(appreciation);
			} else {
				return "redirect:/appreciations";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/appreciations";
	}
	
	@GetMapping("{id}/del")	//	/appreciations/1/del
	public String deleteAppreciation(Model model, @PathVariable("id") Integer id) {
		try {
			if (appreciationService.existsById(id)) {
				appreciationService.deleteById(id);
			} else {
				return "redirect:/appreciations";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/appreciations";
	}
	
	
}














