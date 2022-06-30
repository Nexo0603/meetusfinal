package pe.edu.upc.MeetUs.controller;

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

import pe.edu.upc.MeetUs.business.crud.OrganizerService;
import pe.edu.upc.MeetUs.business.crud.PaymentService;
import pe.edu.upc.MeetUs.models.entities.Organizer;

@Controller
@RequestMapping("/organizers-bs")
@SessionAttributes("{organizer}")
public class OrganizerBsController {
	
	@Autowired
	private OrganizerService organizerService;
	
	@Autowired
	private PaymentService paymentService; 
	
	@GetMapping
	public String listOrganizers(Model model) {
		
		try {
			List<Organizer> organizers = organizerService.getAll();
			model.addAttribute("organizers", organizers);
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "organizers-bs/list-organizers";
	}
	
	@GetMapping("new")
	public String newOrganizer (Model model) {
		Organizer organizer = new Organizer();
		model.addAttribute("organizer", organizer);
		
		return "organizers-bs/new-organizer";
	}
	
	@PostMapping("savenew")
	public String saveOrganizer(Model model, @ModelAttribute("organizer") Organizer organizer) {
		try {
			Organizer organizerSaved = organizerService.create(organizer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/organizers-bs";
	}
	
	@GetMapping("{id}/edit")	
	public String editOrganizer(Model model, @PathVariable("id") Integer id) {				
		try {
			if (organizerService.existsById(id)) {
				Optional<Organizer> optional = organizerService.findById(id);
				model.addAttribute("organizer", optional.get());
				List<Organizer> organizers = organizerService.getAll();
				model.addAttribute("organizers", organizers);
			} else {
				return "redirect:/organizers-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "organizers-bs/edit-organizer";
	}
	
	@PostMapping("{id}/update")	
	public String updateOrganizer(Model model, @ModelAttribute("organizer") Organizer organizer, 
			@PathVariable("id") Integer id) {
		try {
			if (organizerService.existsById(id)) {
				organizerService.update(organizer);
			} else {
				return "redirect:/organizers-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/organizers-bs";
	}
	
	@GetMapping("{id}/del")	
	public String deleteOrganizer(Model model, @PathVariable("id") Integer id) {
		try {
			if (organizerService.existsById(id)) {
				organizerService.deleteById(id);
			} else {
				return "redirect:/organizers-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/organizers-bs";
	}
	
	@GetMapping(value = "{id}/view")
	public String viewOrganizer(@PathVariable("id") Integer id, Model model/*, RedirectAttributes flash*/) {
		
		try {
		/*if(paymentService.existsById(id)){*/
			Optional<Organizer> optional = organizerService.findById(id);
			model.addAttribute("organizer", optional.get());
		/*}else {*/
			/*flash.addFlashAttribute("error", "El /pago no existe en la base de datos");
			return "redirect:/payments-bs";*/
		/*}*/
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		
		return "organizers-bs/view-organizer";
	}
}
