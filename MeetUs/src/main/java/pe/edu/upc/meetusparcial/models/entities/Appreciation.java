package pe.edu.upc.meetusparcial.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "appreciations")
public class Appreciation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "A_Id",columnDefinition = "NUMERIC(10)")
	private Integer id;
	
	@Column(name = "A_Review",length = 50, nullable = false)
	private String review;
	
	@Column(name = "A_Puntuation",length = 2,nullable = false)
	private String puntuation;
	
	@ManyToOne
	@JoinColumn(name = "Guest_G_Id")
	private Guest guest;
	
	@Transient
	private Integer guestId;

	public Appreciation() {
		this.guestId = 0;
	}

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

	public void setGuest(Guest guest) {
		this.guest = guest;
		if (this.guest != null) {
			this.guestId = this.guest.getId();
		}
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}
	
	

}
