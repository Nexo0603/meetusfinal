package pe.edu.upc.MeetUsSpring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUsSpring.model.entity.Appreciation;

@Repository
public interface AppreciationRepository extends JpaRepository<Appreciation, Integer> {
	List<Appreciation> findByReview(String Review) throws Exception;

}
