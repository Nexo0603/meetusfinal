package pe.edu.upc.MeetUsSpring.business.crud;

import java.util.List;

import pe.edu.upc.MeetUsSpring.model.entity.Appreciation;

public interface AppreciationService extends CrudService<Appreciation, Integer> {
	List<Appreciation> findByReview(String review) throws Exception;

}
