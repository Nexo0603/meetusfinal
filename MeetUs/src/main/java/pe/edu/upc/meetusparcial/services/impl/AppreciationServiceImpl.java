package pe.edu.upc.meetusparcial.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.meetusparcial.models.entities.Appreciation;
import pe.edu.upc.meetusparcial.models.repositories.AppreciationRepository;
import pe.edu.upc.meetusparcial.services.AppreciationService;


@Service
public class AppreciationServiceImpl implements AppreciationService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AppreciationRepository appreciationRepository;


	@Override
	public void deleteById(Integer id) throws Exception {
		appreciationRepository.deleteById(id);
		
	}

	@Override
	public Optional<Appreciation> findById(Integer id) throws Exception {
		return appreciationRepository.findById(id);
	}

	@Override
	public List<Appreciation> findByReview(String review) throws Exception {
		return appreciationRepository.findByReview(review);
	}


	@Override
	public JpaRepository<Appreciation, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

}
