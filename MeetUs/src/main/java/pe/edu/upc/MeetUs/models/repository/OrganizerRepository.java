package pe.edu.upc.MeetUs.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUs.models.entities.Organizer;



@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer>{
List<Organizer> findByName(String name) throws Exception;
}
