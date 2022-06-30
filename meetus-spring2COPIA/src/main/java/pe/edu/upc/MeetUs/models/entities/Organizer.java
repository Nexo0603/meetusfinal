package pe.edu.upc.MeetUs.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "organizers", indexes = {@Index(columnList = "organizer_name", name = "organizers_index_organizer_name")})
public class Organizer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
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
	
	@Column(name = "organizer_urltoimage", length = 200, nullable = true)
	private String urlToImage;
	
	@OneToMany(mappedBy = "organizer")
	private List<Payment> payments;
	
	@OneToMany(mappedBy = "organizer")
	private List<Meeting> meetings;
	
	@OneToMany(mappedBy = "organizer")
	private List<Appreciation> appreciations;
	
	@OneToMany(mappedBy = "organizer")
	private List<Suggestion> suggestions;


	public Organizer() {
		payments = new ArrayList<Payment>();
		meetings = new ArrayList<Meeting>();
		appreciations = new ArrayList<Appreciation>();
		suggestions = new ArrayList<Suggestion>();
	}

	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
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
	
	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}
	
}
