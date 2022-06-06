package pe.edu.upc.meetusparcial.services;

import java.util.List;

import pe.edu.upc.meetusparcial.models.entities.Appreciation;

public interface AppreciationService extends CrudService<Appreciation, Integer> {
	
	List<Appreciation> findByReview(String review) throws Exception;

}
