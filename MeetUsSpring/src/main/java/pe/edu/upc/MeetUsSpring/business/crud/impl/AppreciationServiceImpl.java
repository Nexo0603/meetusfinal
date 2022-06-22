package pe.edu.upc.MeetUsSpring.business.crud.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
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
	public List<Appreciation> findByReview(String review) throws Exception {
		return this.appreciationRepository.findByReview(review);
	}

}
