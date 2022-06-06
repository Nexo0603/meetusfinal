package pe.edu.upc.MeetUs.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.models.entities.Guest;
import pe.edu.upc.MeetUs.models.repositories.GuestRepository;
import pe.edu.upc.MeetUs.services.GuestService;

@Service
public class GuestServiceImpl implements GuestService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GuestRepository guestRepository;

	@Override
	public Guest save(Guest entity) throws Exception {
		return guestRepository.save(entity);
	}
	

	@Override
	public void deleteById(Integer id) throws Exception {
		guestRepository.deleteById(id);

	}

	@Override
	public Optional<Guest> findById(Integer id) throws Exception {
		return guestRepository.findById(id);
	}

	@Override
	public List<Guest> findAll() throws Exception {
		return guestRepository.findAll();
	}

	@Override
	public List<Guest> findByName(String name) throws Exception {
		return guestRepository.findByName(name);
	}

	@Override
	public Optional<Guest> findByDni(String dni) throws Exception {
		return guestRepository.findByDni(dni);
	}

}
