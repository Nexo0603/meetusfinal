package pe.edu.upc.meetusparcial.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.meetusparcial.models.entities.Guest;

public interface GuestService extends CrudService<Guest, Integer> {
	
	List<Guest> findByName(String name) throws Exception;
	Optional<Guest> findByDni(String dni) throws Exception;

}
