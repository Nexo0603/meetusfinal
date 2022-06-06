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

import pe.edu.upc.MeetUs.business.crud.LocalService;
import pe.edu.upc.MeetUs.business.crud.LocalOwnerService;
import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;

@Controller
@RequestMapping("/localowners")	// GET y POST
@SessionAttributes("{localowner}")
public class LocalOwnerController {

	@Autowired
	private LocalService localService;
	
	@Autowired
	private LocalOwnerService localownerService; 
	
	@GetMapping("new")	//	/localowners/new
	public String newLocalOwner(Model model) {
		LocalOwner localowner = new LocalOwner();
		model.addAttribute("localowner", localowner);
		try {
			List<Local> locals = localService.getAll();
			model.addAttribute("locals", locals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "localowners/new-localowner";
	}
	
	@PostMapping("savenew")	//	/localowners/savenew
	public String saveLocalOwner(Model model, @ModelAttribute("localowner") LocalOwner localowner) {
		try {
			LocalOwner localownerSaved = localownerService.create(localowner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/localowners";
	}
	
	@GetMapping("{id}/edit")	//	/localowners/1/edit
	public String editLocalOwner(Model model, @PathVariable("id") Integer id) {				
		try {
			if (localownerService.existsById(id)) {
				Optional<LocalOwner> optional = localownerService.findById(id);
				model.addAttribute("localowner", optional.get());
				List<Local> locals = localService.getAll();
				model.addAttribute("local", locals);
			} else {
				return "redirect:/localowners";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "localowners/edit-localowner";
	}
	
	@PostMapping("{id}/update")	//	/locals/1/update
	public String updateLocalOwner(Model model, @ModelAttribute("localowner") LocalOwner localowner, 
			@PathVariable("id") Integer id) {
		try {
			if (localownerService.existsById(id)) {
				localownerService.update(localowner);
			} else {
				return "redirect:/localowners";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/localowners";
	}
	
	@GetMapping("{id}/del")	//	/locals/1/del
	public String deleteLocalOwner(Model model, @PathVariable("id") Integer id) {
		try {
			if (localownerService.existsById(id)) {
				localownerService.deleteById(id);
			} else {
				return "redirect:/localowners";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/localowners";
	}
}
