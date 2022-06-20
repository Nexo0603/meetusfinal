package pe.edu.upc.MeetUsSpring.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.MeetUsSpring.business.crud.EnrollmentService;
import pe.edu.upc.MeetUsSpring.model.entity.Enrollment;
import pe.edu.upc.MeetUsSpring.model.repository.EnrollmentRepository;

public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public JpaRepository<Enrollment, Integer> getJpaRepository() {
		return enrollmentRepository;
	}

}
