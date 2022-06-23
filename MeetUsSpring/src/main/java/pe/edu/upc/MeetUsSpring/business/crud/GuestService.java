package pe.edu.upc.MeetUsSpring.business.crud;

import java.util.List;

import pe.edu.upc.MeetUsSpring.model.entity.Guest;

public interface GuestService extends CrudService<Guest, Integer> {
	List<Guest> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
