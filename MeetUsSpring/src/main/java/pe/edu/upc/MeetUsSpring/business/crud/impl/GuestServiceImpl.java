package pe.edu.upc.MeetUsSpring.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
 
import pe.edu.upc.MeetUsSpring.business.crud.GuestService;
import pe.edu.upc.MeetUsSpring.model.entity.Guest;
import pe.edu.upc.MeetUsSpring.model.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestRepository guestRepository;
	
	@Override
	public JpaRepository<Guest, Integer> getJpaRepository() {
		return this.guestRepository;
	}

	@Override
	public List<Guest> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return this.guestRepository.findByLastNameAndFirstName(lastName, firstName);
	}

}
