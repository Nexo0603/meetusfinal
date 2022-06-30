package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Guest;

public interface GuestService extends CrudService<Guest, Integer> {
	List<Guest> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
