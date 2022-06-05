package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Organizer;



public interface OrganizerService extends CrudService<Organizer, Integer>{
List<Organizer> findByName(String name) throws Exception;
}
