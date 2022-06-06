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
	
	@GetMapping("{id}/edit")	
	public String editPayment(Model model, @PathVariable("id") Integer id) {				
		try {
			if (paymentService.existsById(id)) {
				Optional<Payment> optional = paymentService.findById(id);
				model.addAttribute("payment", optional.get());
				List<Organizer> organizers = organizerService.getAll();
				model.addAttribute("organizers", organizers);
			} else {
				return "redirect:/payments";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "payments/edit-payment";
	}
	
	@PostMapping("{id}/update")	
	public String updatePayment(Model model, @ModelAttribute("payment") Payment payment, 
			@PathVariable("id") Integer id) {
		try {
			if (paymentService.existsById(id)) {
				paymentService.update(payment);
			} else {
				return "redirect:/payments";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/payments";
	}
	
	@GetMapping("{id}/del")	
	public String deletePayment(Model model, @PathVariable("id") Integer id) {
		try {
			if (paymentService.existsById(id)) {
				paymentService.deleteById(id);
			} else {
				return "redirect:/payments";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/payments";
	}
}
