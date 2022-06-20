package pe.edu.upc.MeetUsSpring.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUsSpring.business.crud.CourseService;
import pe.edu.upc.MeetUsSpring.model.entity.Course;
import pe.edu.upc.MeetUsSpring.model.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public JpaRepository<Course, String> getJpaRepository() {
		return null;
	}

	@Override
	public List<Course> findByName(String name) throws Exception {
		return courseRepository.findByName(name);
	}

}
