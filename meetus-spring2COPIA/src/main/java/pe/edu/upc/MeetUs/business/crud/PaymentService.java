package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Payment;



public interface PaymentService extends CrudService<Payment, Integer>{
	List<Payment> findByName(String name) throws Exception;
}
