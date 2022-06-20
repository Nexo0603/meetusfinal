package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.SuggestionService;
import pe.edu.upc.MeetUs.models.entities.Suggestion;
import pe.edu.upc.MeetUs.models.repository.SuggestionRepository;


@Service
public class SuggestionServiceImpl implements SuggestionService{

	@Autowired
	private SuggestionRepository suggestionRepository;
	
	@Override
	public JpaRepository<Suggestion, Integer> getJpaRepository() {
		
		return this.suggestionRepository;
	}

	@Override
	public List<Suggestion> findByName(String name) throws Exception {
		
		return this.suggestionRepository.findByName(name);
	}
}
