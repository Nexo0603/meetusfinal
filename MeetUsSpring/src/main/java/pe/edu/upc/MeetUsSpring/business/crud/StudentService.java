package pe.edu.upc.MeetUsSpring.business.crud;

import java.util.List;

import pe.edu.upc.MeetUsSpring.model.entity.Student;

public interface StudentService extends CrudService<Student, Integer> {
	List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
