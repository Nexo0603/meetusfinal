package pe.edu.upc.MeetUs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.MeetUs.business.crud.UserBsService;
import pe.edu.upc.MeetUs.models.entities.Segment;
import pe.edu.upc.MeetUs.models.entities.User;
import pe.edu.upc.MeetUs.utils.UserAuthentication;



/**
 * Este Controller requiere que exista previamente el student o Teacher.
 * @author Pc
 *
 */

@Controller
@RequestMapping("/users")	
@SessionAttributes("{user}")
public class UserBsController {

	@Autowired
	private UserBsService userBsService;
	
	@Autowired
	private UserAuthentication userAuthentication;
	
	@GetMapping("sign-up")
	public String signUp(Model model) {
		User user = new User();
		user.setEnable(true);
		model.addAttribute("user", user);		
		model.addAttribute("segments", getSegments());
		return "users/sign-up";
	}
	
	@PostMapping("register-user")
	public String registerUser(Model model, @ModelAttribute("user") User user) {
		try {
			if (!userBsService.existsByUsername(user.getUsername())) {
				userBsService.register(user);
				return "redirect:/login";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/";
	}
	
	@GetMapping("view-profile")
	public String getIndex(Model model) {	
		
		if (userAuthentication.isAuthenticated()) {	// Enviar los datos del Segmento al html
			userAuthentication.getSegment(model);
		}
				
		return "users/view-profile";
	}
	
	// Creando la lista de segmentos
	private List<Segment> getSegments() {
		List<Segment> segments = new ArrayList<>();
		segments.add(Segment.GUEST);
		segments.add(Segment.LOCALOWNER);
		segments.add(Segment.ORGANIZER);
		return segments;
	}
	
}