package pe.edu.upc.MeetUs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MeetUs.business.crud.LocalService;
import pe.edu.upc.MeetUs.business.crud.LocalOwnerService;
import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;

@Controller
@RequestMapping("/locals")	// GET y POST
@SessionAttributes("{local}")
public class LocalController {

	@Autowired
	private LocalService localService;
	
	@Autowired
	private LocalOwnerService localownerService; 

	@GetMapping		//	/students
	public String listLocals(Model model) {
		
		try {
			List<Local> locals = localService.getAll();
			model.addAttribute("locals", locals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "locals/list-locals";
	}
	
	@GetMapping("new")	//	/locals/new
	public String newLocal(Model model) {
		Local local = new Local();
		model.addAttribute("local", local);
		try {
			List<LocalOwner> localowners = localownerService.getAll();
			model.addAttribute("localowners", localowners);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "locals/new-local";
	}
	
	@PostMapping("savenew")	//	/locals/savenew
	public String saveLocal(Model model, @ModelAttribute("local") Local local) {
		try {
			Local localSaved = localService.create(local);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/locals";
	}
}
