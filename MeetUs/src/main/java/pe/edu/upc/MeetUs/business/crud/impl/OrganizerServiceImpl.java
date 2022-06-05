package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.OrganizerService;
import pe.edu.upc.MeetUs.models.entities.Organizer;
import pe.edu.upc.MeetUs.models.repository.OrganizerRepository;



@Service
public class OrganizerServiceImpl implements OrganizerService {

	@Autowired
	private OrganizerRepository organizerRepository;

	@Override
	public JpaRepository<Organizer, Integer> getJpaRepository() {
		return organizerRepository;
	}

	@Override
	public List<Organizer> findByName(String name) throws Exception {
		return organizerRepository.findByName(name);
	}
}
