package pe.edu.upc.MeetUsSpring.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "appreciations", indexes = {@Index(columnList = "A_Review", name = "Appreciation_index_A_Review" )})
public class Appreciation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "A_Review",length = 50, nullable = false)
	private String review;
	
	@Column(name = "A_Puntuation",length = 2,nullable = false)
	private String puntuation;
	
	@ManyToOne
	@JoinColumn(name = "Guest_G_Id")
	private Guest guest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getPuntuation() {
		return puntuation;
	}

	public void setPuntuation(String puntuation) {
		this.puntuation = puntuation;
	}

	public Guest getGuest() {
		return guest;
	}

}
