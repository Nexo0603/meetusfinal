package pe.edu.upc.MeetUs.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.MeetUs.models.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	List<Payment> findByName(String name) throws Exception;
}
