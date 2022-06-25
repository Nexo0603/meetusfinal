package pe.edu.upc.MeetUs.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;

@Repository
public interface LocalOwnerRepository extends JpaRepository<LocalOwner, Integer> {

	List<LocalOwner> findByName(String name) throws Exception;
	
}
