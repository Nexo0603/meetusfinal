package pe.edu.upc.MeetUsSpring.business.crud;

import java.util.List;

import pe.edu.upc.MeetUsSpring.model.entity.Course;

public interface CourseService extends CrudService<Course, String> {
	List<Course> findByName(String name) throws Exception;
}
