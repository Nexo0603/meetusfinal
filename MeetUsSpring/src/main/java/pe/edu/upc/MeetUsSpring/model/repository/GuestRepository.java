package pe.edu.upc.MeetUsSpring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUsSpring.model.entity.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
	List<Guest> findByLastNameAndFirstName(String lastname, String firstname) throws Exception;
}
