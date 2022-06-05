package pe.edu.upc.MeetUs.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "organizers", indexes = {@Index(columnList = "organizer_name", name = "organizers_index_organizer_name")})
public class Organizer {

	@Id
	@Column(name="organizer_id", length = 3)
	private String id;
	
	@Column(name="organizer_name", length = 30,nullable = false)
	private String name;
	
	@Column(name="organizer_lastName", length = 30, nullable = false)
	private String lastName;
	
	@Column(name="organizer_phone", length = 9, nullable = false)
	private String phone;
	
	@Column(name="organizer_dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name="organizer_address", length = 30, nullable = false)
	private String address;
	
	@Column(name="organizer_email", length = 30, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "organizer")
	private List<Payment> payments;

	public Organizer() {
		payments = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
