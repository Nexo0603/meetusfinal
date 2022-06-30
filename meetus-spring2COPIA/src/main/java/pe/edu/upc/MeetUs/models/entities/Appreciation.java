package pe.edu.upc.MeetUs.models.entities;

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
@Table(name = "appreciations", indexes = {@Index(columnList = "A_Review", name = "appreciations_index_A_Review" )})
public class Appreciation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "A_Review",length = 50, nullable = false)
	private String review;
	
	@Column(name = "A_Puntuation",length = 30,nullable = false)
	private String puntuation;

	@ManyToOne
	@JoinColumn(name = "guest_id")
	private Guest guest;

	@ManyToOne
	@JoinColumn(name = "meeting_id")
	private Meeting meeting;
	
	@ManyToOne
	@JoinColumn(name = "organizer_id")
	private Organizer organizer;
	
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
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

}
