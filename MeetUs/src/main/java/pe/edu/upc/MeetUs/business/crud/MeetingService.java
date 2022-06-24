package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Meeting;

public interface MeetingService extends CrudService<Meeting, Integer> {
	
	List<Meeting> findByName(String name) throws Exception;
	
}
