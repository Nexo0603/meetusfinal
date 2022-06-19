package pe.edu.upc.meetusparcial.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.meetusparcial.models.entities.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
	
	List<Guest> findByName(String name) throws Exception;
	Optional<Guest> findByDni(String dni) throws Exception;
	

}
