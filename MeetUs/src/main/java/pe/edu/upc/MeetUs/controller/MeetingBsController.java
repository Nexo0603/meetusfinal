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
import pe.edu.upc.MeetUs.business.crud.MeetingService;
import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.Meeting;

@Controller
@RequestMapping("/meetings-bs")	// GET y POST
@SessionAttributes("{meeting}")
public class MeetingBsController {

	@Autowired
	private LocalService localService;
	
	@Autowired
	private MeetingService meetingService; 
	
	@GetMapping		//	/locals
	public String listMeetings(Model model) {
		
		try {
			List<Meeting> meetings = meetingService.getAll();
			model.addAttribute("meetings", meetings);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "meetings-bs/list-meetings";
	}
	
	@GetMapping("new")	//	/locals/new
	public String newMeeting(Model model) {
		Meeting meeting = new Meeting();
		model.addAttribute("meeting", meeting);
		try {
			List<Local> locals = localService.getAll();
			model.addAttribute("locals", locals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "meetings-bs/new-meeting";
	}
	
	@PostMapping("savenew")	//	/locals/savenew
	public String saveMeeting(Model model, @ModelAttribute("meeting") Meeting meeting) {
		try {
			Meeting meetingSaved = meetingService.create(meeting);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/meetings-bs";
	}
	
	@GetMapping("{id}/edit")	//	/locals/1/edit
	public String editMeeting(Model model, @PathVariable("id") Integer id) {				
		try {
			if (meetingService.existsById(id)) {
				Optional<Meeting> optional = meetingService.findById(id);
				model.addAttribute("meeting", optional.get());
				List<Local> locals = localService.getAll();
				model.addAttribute("locals", locals);
			} else {
				return "redirect:/meetings-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "meetings-bs/edit-meeting";
	}
	
	@PostMapping("{id}/update")	//	/locals/1/update
	public String updateMeeting(Model model, @ModelAttribute("meeting") Meeting meeting, 
			@PathVariable("id") Integer id) {
		try {
			if (meetingService.existsById(id)) {
				meetingService.update(meeting);
			} else {
				return "redirect:/meetings-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/meetings-bs";
	}
	
	@GetMapping("{id}/del")	//	/locals/1/del
	public String deleteMeeting(Model model, @PathVariable("id") Integer id) {
		try {
			if (meetingService.existsById(id)) {
				meetingService.deleteById(id);
			} else {
				return "redirect:/meetings-bs";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/meetings-bs";
	}
}
