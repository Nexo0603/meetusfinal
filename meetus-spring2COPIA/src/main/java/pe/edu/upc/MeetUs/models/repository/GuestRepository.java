package pe.edu.upc.MeetUs.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUs.models.entities.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
	List<Guest> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
