package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Meeting;
import pe.edu.upc.MeetUs.models.entities.Organizer;

public interface MeetingService extends CrudService<Meeting, Integer> {
	
	List<Meeting> findByName(String name) throws Exception;
	
	List<Meeting> findByOrganizer(Integer id) throws Exception;
}
