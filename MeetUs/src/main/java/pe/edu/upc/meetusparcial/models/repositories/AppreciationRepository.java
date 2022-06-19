package pe.edu.upc.meetusparcial.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.meetusparcial.models.entities.Appreciation;

@Repository
public interface AppreciationRepository extends JpaRepository<Appreciation, Integer>{
	
	List<Appreciation> findByReview(String review) throws Exception;


}
