package pe.edu.upc.MeetUsSpring.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUsSpring.business.crud.AppreciationService;
import pe.edu.upc.MeetUsSpring.model.entity.Appreciation;
import pe.edu.upc.MeetUsSpring.model.repository.AppreciationRepository;

@Service
public class AppreciationServiceImpl implements AppreciationService {

	@Autowired
	private AppreciationRepository appreciationRepository;
	
	@Override
	public JpaRepository<Appreciation, Integer> getJpaRepository() {
		return this.appreciationRepository;
	}

	@Override
	public List<Appreciation> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return this.appreciationRepository.findByLastNameAndFirstName(lastName, firstName);
	}

}
