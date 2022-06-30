package pe.edu.upc.MeetUs.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pe.edu.upc.MeetUs.business.crud.AppreciationService;
import pe.edu.upc.MeetUs.business.crud.CrudService;
import pe.edu.upc.MeetUs.business.crud.GuestService;
import pe.edu.upc.MeetUs.business.crud.LocalOwnerService;
import pe.edu.upc.MeetUs.business.crud.LocalService;
import pe.edu.upc.MeetUs.business.crud.MeetingService;
import pe.edu.upc.MeetUs.business.crud.OrganizerService;
import pe.edu.upc.MeetUs.business.crud.PaymentService;
import pe.edu.upc.MeetUs.business.crud.SuggestionService;
import pe.edu.upc.MeetUs.models.entities.Segment;
import pe.edu.upc.MeetUs.models.entities.Organizer;
import pe.edu.upc.MeetUs.models.entities.Guest;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;
import pe.edu.upc.MeetUs.security.MyUserDetails;

@Service
public class UserAuthentication {
	
	// Cambiar los service de acuerdo al segmento que tengan
	@Autowired
	private OrganizerService organizerService;
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private LocalOwnerService localownerService;
	
	public boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof AnonymousAuthenticationToken) { // Si no hay nadie autenticado
			return false;			
		} else {
			return true;
		}
	}
	
	public void getSegment(Model model) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(!(authentication instanceof AnonymousAuthenticationToken)) {	// Si Hay alguien autenticado
				
				MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
				model.addAttribute("segment", myUserDetails.getSegment());
				
				// Para el segmento 1: Cambiar STUDENT por su segmento
				if (myUserDetails.getSegment().equals(Segment.GUEST)) {
					if (guestService.existsById(myUserDetails.getIdSegment())) {
						Optional<Guest> optional = guestService.findById(myUserDetails.getIdSegment());
						model.addAttribute("guest", optional.get());
					}					
				} 
				// Para el segmento 2: Cambiar TEACHER por su segmento
				else if (myUserDetails.getSegment().equals(Segment.LOCALOWNER)) {
					if (localownerService.existsById(myUserDetails.getIdSegment())) {
						Optional<LocalOwner> optional = localownerService.findById(myUserDetails.getIdSegment());
						model.addAttribute("localowner", optional.get());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Integer getIdSegment() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {	// Si Hay alguien autenticado
			
			MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
			return myUserDetails.getIdSegment();
		}
		return null;
	}
	
}