package pe.edu.upc.MeetUsSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Column(name = "section", length = 4, nullable = false)	
	private String section;
	
	@Column(name = "grade_work")
	private float gradeWork;
	
	@Column(name = "grade_exam")
	private float gradeExam;
	
	@Column(name = "grade_final")
	private float gradeFinal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public float getGradeWork() {
		return gradeWork;
	}

	public void setGradeWork(float gradeWork) {
		this.gradeWork = gradeWork;
	}

	public float getGradeExam() {
		return gradeExam;
	}

	public void setGradeExam(float gradeExam) {
		this.gradeExam = gradeExam;
	}

	public float getGradeFinal() {
		return gradeFinal;
	}

	public void setGradeFinal(float gradeFinal) {
		this.gradeFinal = gradeFinal;
	}
	
	

}
