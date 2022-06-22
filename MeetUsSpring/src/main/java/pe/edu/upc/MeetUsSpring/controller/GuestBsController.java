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
@RequestMapping("/guests-bs")	// GET y POST
@SessionAttributes("{guest}")
public class GuestBsController {

	@Autowired
	private GuestService guestService;
	
	@Autowired
	private AppreciationService appreciationService; 

	@GetMapping		//	/guests
	public String listGuests(Model model) {
		
		try {
			List<Guest> guests = guestService.getAll();
			model.addAttribute("guests", guests);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "guests-bd/list-guests";
	}
	
	@GetMapping("new")	//	/guests/new
	public String newStudent(Model model) {
		Guest guest = new Guest();
		model.addAttribute("guest", guest);
		try {
			List<Appreciation> appreciations = appreciationService.getAll();
			model.addAttribute("appreciations", appreciations);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "guests-bd/new-guest";
	}
	
	@PostMapping("savenew")	//	/guests/savenew
	public String saveGuest(Model model, @ModelAttribute("guest") Guest guest) {
		try {
			Guest guestSaved = guestService.create(guest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/guests-bd";
	}
	
	@GetMapping("{id}/edit")	//	/guests/1/edit
	public String editGuest(Model model, @PathVariable("id") Integer id) {				
		try {
			if (guestService.existsById(id)) {
				Optional<Guest> optional = guestService.findById(id);
				model.addAttribute("guest", optional.get());
				List<Appreciation> appreciation = appreciationService.getAll();
				model.addAttribute("appreciation", appreciation);
			} else {
				return "redirect:/guests-bd";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "guests-bd/edit-guest";
	}
	
	@PostMapping("{id}/update")	//	/guests/1/update
	public String updateGuest(Model model, @ModelAttribute("guest") Guest guest, 
			@PathVariable("id") Integer id) {
		try {
			if (guestService.existsById(id)) {
				guestService.update(guest);
			} else {
				return "redirect:/guests-bd";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/guests-bd";
	}
	
	@GetMapping("{id}/del")	//	/guests/1/del
	public String deleteGuest(Model model, @PathVariable("id") Integer id) {
		try {
			if (guestService.existsById(id)) {
				guestService.deleteById(id);
			} else {
				return "redirect:/guests-bd";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/guests-bd";
	}
	
	
}














