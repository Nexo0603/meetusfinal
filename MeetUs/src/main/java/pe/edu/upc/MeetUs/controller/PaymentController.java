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

import pe.edu.upc.MeetUs.business.crud.OrganizerService;
import pe.edu.upc.MeetUs.business.crud.PaymentService;
import pe.edu.upc.MeetUs.models.entities.Organizer;
import pe.edu.upc.MeetUs.models.entities.Payment;



@Controller
@RequestMapping("/payments")
@SessionAttributes("{payment}")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private OrganizerService organizerService; 
	
	@GetMapping
	public String listPayments(Model model) {
		
		try {
			List<Payment> payments = paymentService.getAll();
			model.addAttribute("payments", payments);
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "payments/list-payments";
	}
	
	@GetMapping("new")
	public String newPayment (Model model) {
		Payment payment = new Payment();
		model.addAttribute("payment", payment);
		try {
			List<Organizer> organizers = organizerService.getAll();
			model.addAttribute("organizers", organizers);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "payments/new-payment";
	}
	
	@PostMapping("savenew")
	public String savePayment(Model model, @ModelAttribute("payment") Payment payment) {
		try {
			Payment paymentSaved = paymentService.create(payment);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:/payments";
	}
}
