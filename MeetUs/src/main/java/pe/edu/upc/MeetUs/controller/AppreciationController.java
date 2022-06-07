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
	
	@PostMapping("savenew")	//	/students/savenew
	public String saveAppreciation(Model model, @ModelAttribute("appreciation") Appreciation appreciation) {
		try {
			Appreciation appreciationSaved = AppreciationService.create(appreciation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/appreciation";
	}
	
	@GetMapping("{id}/edit")	//	/students/1/edit
	public String editAppreciation(Model model, @PathVariable("id") Integer id) {				
		try {
			if (studentService.existsById(id)) {
				Optional<Student> optional = studentService.findById(id);
				model.addAttribute("student", optional.get());
				List<Career> careers = careerService.getAll();
				model.addAttribute("careers", careers);
			} else {
				return "redirect:/students";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "students/edit-student";
	}
	
	@PostMapping("{id}/update")	//	/students/1/update
	public String updateStudent(Model model, @ModelAttribute("student") Student student, 
			@PathVariable("id") Integer id) {
		try {
			if (studentService.existsById(id)) {
				studentService.update(student);
			} else {
				return "redirect:/students";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/students";
	}
	
	@GetMapping("{id}/del")	//	/students/1/del
	public String deleteStudent(Model model, @PathVariable("id") Integer id) {
		try {
			if (studentService.existsById(id)) {
				studentService.deleteById(id);
			} else {
				return "redirect:/students";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/students";
	}
	
	
}
