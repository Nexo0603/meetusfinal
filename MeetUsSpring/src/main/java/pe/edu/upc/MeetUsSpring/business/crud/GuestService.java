package pe.edu.upc.MeetUsSpring.business.crud;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUsSpring.model.entity.Guest;

@Service
public interface GuestService extends CrudService<Guest, Integer> {
	List<Guest> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
