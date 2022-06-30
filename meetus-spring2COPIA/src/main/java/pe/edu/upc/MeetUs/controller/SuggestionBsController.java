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

import pe.edu.upc.MeetUs.business.crud.SuggestionService;
import pe.edu.upc.MeetUs.models.entities.Suggestion;

@Controller
@RequestMapping("/suggestions-bs")
@SessionAttributes("{suggestion}")
public class SuggestionBsController {

	@Autowired
	private SuggestionService suggestionService;
	
	@GetMapping
	public String listSuggestions(Model model) {
		
		try	{
			List<Suggestion> suggestions = suggestionService.getAll();
			model.addAttribute("suggestions", suggestions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "suggestions-bs/list-suggestions";
	}
	
	@GetMapping("new")	
	public String newSuggestion(Model model) {
		Suggestion suggestion = new Suggestion();
		model.addAttribute("suggestion", suggestion);
		
		return "suggestions-bs/new-suggestion";
	}
	
	@PostMapping("savenew")	
	public String saveSuggestion(Model model, @ModelAttribute("suggestion") Suggestion suggestion) {
		try {
			Suggestion suggestionSaved = suggestionService.create(suggestion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/suggestions-bs";
	}
	
	@GetMapping("{id}/edit")	
	public String editSuggestion(Model model, @PathVariable("id") Integer id) {				
		try {
			if (suggestionService.existsById(id)) {
				Optional<Suggestion> optional = suggestionService.findById(id);
				model.addAttribute("suggestion", optional.get());
				
			} else {
				return "redirect:/suggestions-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "suggestions-bs/edit-suggestion";
	}
	
	@PostMapping("{id}/update")	
	public String updateSuggestion(Model model, @ModelAttribute("suggestion") Suggestion suggestion, 
			@PathVariable("id") Integer id) {
		try {
			if (suggestionService.existsById(id)) {
				suggestionService.update(suggestion);
			} else {
				return "redirect:/suggestions-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/suggestions-bs";
	}
	
	@GetMapping("{id}/del")	
	public String deleteSuggestion(Model model, @PathVariable("id") Integer id) {
		try {
			if (suggestionService.existsById(id)) {
				suggestionService.deleteById(id);
			} else {
				return "redirect:/suggestions-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/suggestions-bs";
	}
	
	@GetMapping(value = "{id}/view")
	public String viewSuggestion(@PathVariable("id") Integer id, Model model/*, RedirectAttributes flash*/) {
		
		try {
		/*if(paymentService.existsById(id)){*/
			Optional<Suggestion> optional = suggestionService.findById(id);
			model.addAttribute("suggestion", optional.get());
		/*}else {*/
			/*flash.addFlashAttribute("error", "El /pago no existe en la base de datos");
			return "redirect:/payments-bs";*/
		/*}*/
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		
		return "suggestions-bs/view-suggestion";
	}
}
