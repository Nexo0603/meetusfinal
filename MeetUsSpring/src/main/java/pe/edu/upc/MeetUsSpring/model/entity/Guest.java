package pe.edu.upc.MeetUsSpring.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "guests", indexes = {@Index(columnList = "G_lastname, G_firstname", name = "G_index_G_lastname_G_firstname" )})
public class Guest {
	@Id
	@Column(name = "guest_id", length = 3)
	private String id;
	
	@Column(name = "G_firstname",length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "G_lastname",length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "G_phone",length = 9, nullable = false)
	private String phone;
	
	@Column(name = "G_dni",length = 8, nullable = false)
	private String dni;
	
	@Column(name = "G_address",length = 30, nullable = false)
	private String address;
	
	@Column(name = "lo_urltoimage", length = 200, nullable = true)
	private String UrlToImage;
	
	public String getUrlToImage() {
		return UrlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		UrlToImage = urlToImage;
	}

	@OneToMany(mappedBy = "guest")
	private List<Appreciation> appreciations;

	public Guest() {
		appreciations = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
}
