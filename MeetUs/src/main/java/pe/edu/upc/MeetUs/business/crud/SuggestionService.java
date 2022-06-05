package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Suggestion;

public interface SuggestionService extends CrudService<Suggestion, Integer>{
	List<Suggestion> findByName(String name) throws Exception;
}
