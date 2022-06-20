package pe.edu.upc.MeetUsSpring.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "guests")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "G_id",columnDefinition = "NUMERIC(10)")
	private Integer id;
	
	@Column(name = "G_name",length = 30, nullable = false)
	private String name;
	
	@Column(name = "G_lastname",length = 30, nullable = false)
	private String lastname;
	
	@Column(name = "G_phone",length = 9, nullable = false)
	private String phone;
	
	@Column(name = "G_dni",length = 8, nullable = false)
	private String dni;
	
	@Column(name = "G_address",length = 30, nullable = false)
	private String address;
	
	@OneToMany(mappedBy = "guest", fetch = FetchType.LAZY)
	private List<Appreciation> apreciaciones;

	public Guest() {
		apreciaciones = new ArrayList<Appreciation>();
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public List<Appreciation> getApreciaciones() {
		return apreciaciones;
	}

	public void setApreciaciones(List<Appreciation> apreciaciones) {
		this.apreciaciones = apreciaciones;
	}
}
