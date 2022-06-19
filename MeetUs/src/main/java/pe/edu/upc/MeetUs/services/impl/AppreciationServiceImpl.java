package pe.edu.upc.MeetUs.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.MeetUs.models.entities.Appreciation;
import pe.edu.upc.MeetUs.models.repository.AppreciationRepository;
import pe.edu.upc.MeetUs.services.AppreciationService;


@Service
public class AppreciationServiceImpl implements AppreciationService, Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private AppreciationRepository appreciationRepository;

	@Transactional
	@Override
	public Appreciation save(Appreciation entity) throws Exception {
		return appreciationRepository.save(entity);
	}

	@Transactional
	@Override
	public Appreciation update(Appreciation entity) throws Exception {
		return appreciationRepository.save(entity);
	}

	@Transactional
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
