package pe.edu.upc.MeetUs.services;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Appreciation;

public interface AppreciationService extends CrudService<Appreciation, Integer> {
	
	List<Appreciation> findByReview(String review) throws Exception;

}
