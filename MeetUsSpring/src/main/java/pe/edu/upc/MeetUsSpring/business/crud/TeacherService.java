package pe.edu.upc.MeetUsSpring.business.crud;

import java.util.List;

import pe.edu.upc.MeetUsSpring.model.entity.Teacher;

public interface TeacherService extends CrudService<Teacher, Integer> {
	List<Teacher> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
