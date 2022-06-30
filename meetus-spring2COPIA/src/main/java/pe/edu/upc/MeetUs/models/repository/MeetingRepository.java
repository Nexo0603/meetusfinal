package pe.edu.upc.MeetUs.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUs.models.entities.Guest;
import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;
import pe.edu.upc.MeetUs.models.entities.Meeting;
import pe.edu.upc.MeetUs.models.entities.Organizer;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
	
	List<Meeting> findByName(String name) throws Exception;
	
	List<Meeting> findByOrganizer(Organizer organizer) throws Exception;

}
