package pe.edu.upc.meetusparcial.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Appreciation save(Appreciation entity) throws Exception {
		return appreciationRepository.save(entity);
	}


	@Override
	public void deleteById(Integer id) throws Exception {
		appreciationRepository.deleteById(id);
		
	}

	@Override
	public Optional<Appreciation> findById(Integer id) throws Exception {
		return appreciationRepository.findById(id);
	}

	@Override
	public List<Appreciation> findAll() throws Exception {
		return appreciationRepository.findAll();
	}

	@Override
	public List<Appreciation> findByReview(String review) throws Exception {
		return appreciationRepository.findByReview(review);
	}

}
