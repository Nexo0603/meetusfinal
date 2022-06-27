package pe.edu.upc.MeetUs.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUs.models.entities.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
