package pe.edu.upc.MeetUs.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {
	
	List<Local> findByName(String name) throws Exception;
	
	List<Local> findByLocalowner(LocalOwner localowner) throws Exception;

}
