package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.AppreciationService;
import pe.edu.upc.MeetUs.models.entities.Appreciation;
import pe.edu.upc.MeetUs.models.repository.AppreciationRepository;

@Service
public class AppreciationServiceImpl implements AppreciationService {

	@Autowired
	private AppreciationRepository appreciationRepository;
	
	@Override
	public JpaRepository<Appreciation, Integer> getJpaRepository() {
		return this.appreciationRepository;
	}

	@Override
	public List<Appreciation> findByReview(String review) throws Exception {
		return this.appreciationRepository.findByReview(review);
	}

}
