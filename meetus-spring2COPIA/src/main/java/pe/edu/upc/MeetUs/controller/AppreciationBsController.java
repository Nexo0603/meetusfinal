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
import pe.edu.upc.MeetUs.business.crud.AppreciationService;
import pe.edu.upc.MeetUs.business.crud.GuestService;
import pe.edu.upc.MeetUs.models.entities.Appreciation;
import pe.edu.upc.MeetUs.models.entities.Guest;

@Controller
@RequestMapping("/appreciations-bs")	// GET y POST
@SessionAttributes("{appreciation}")
public class AppreciationBsController {
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
		
		return "appreciations-bs/list-appreciations";
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
		return "appreciations-bs/new-appreciation";
	}
	
	@PostMapping("savenew")	//	/appreciations/savenew
	public String saveAppreciation(Model model, @ModelAttribute("appreciation") Appreciation appreciation) {
		try {
			Appreciation appreciationSaved = appreciationService.create(appreciation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/appreciations-bs";
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
				return "redirect:/appreciations-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "appreciations-bs/edit-appreciation";
	}
	
	@PostMapping("{id}/update")	//	/appreciations/1/update
	public String updateAppreciation(Model model, @ModelAttribute("appreciation") Appreciation appreciation, 
			@PathVariable("id") Integer id) {
		try {
			if (appreciationService.existsById(id)) {
				appreciationService.update(appreciation);
			} else {
				return "redirect:/appreciations-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/appreciations-bs";
	}
	
	@GetMapping("{id}/del")	//	/appreciations/1/del
	public String deleteAppreciation(Model model, @PathVariable("id") Integer id) {
		try {
			if (appreciationService.existsById(id)) {
				appreciationService.deleteById(id);
			} else {
				return "redirect:/appreciations-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/appreciations-bs";
	}
	
	@GetMapping(value = "{id}/view")
	public String viewAppreciation(@PathVariable("id") Integer id, Model model/*, RedirectAttributes flash*/) {
		
		try {
		/*if(paymentService.existsById(id)){*/
			Optional<Appreciation> optional = appreciationService.findById(id);
			model.addAttribute("appreciation", optional.get());
		/*}else {*/
			/*flash.addFlashAttribute("error", "El /pago no existe en la base de datos");
			return "redirect:/payments-bs";*/
		/*}*/
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		
		return "appreciations-bs/view-appreciation";
	}
	
	
}














