package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.PaymentService;
import pe.edu.upc.MeetUs.models.entities.Payment;
import pe.edu.upc.MeetUs.models.repository.PaymentRepository;


@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public JpaRepository<Payment, Integer> getJpaRepository() {
		
		return this.paymentRepository;
	}
	
	@Override
	public List<Payment> findByName(String name) throws Exception {
		
		return this.paymentRepository.findByName(name);
	}

}
