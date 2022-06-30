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
@Table(name = "suggestions",
		indexes = {@Index(columnList = "suggestion_name", name = "suggestions_index_suggestion_name")})
public class Suggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "suggestion_description", length = 50, nullable=false)
	private String description;
	
	@Column(name = "suggestion_name", length = 30, nullable=false)
	private String name;
	
	@Column(name = "suggestion_importance", length = 10, nullable=false)
	private String importance;
	
	@ManyToOne
	@JoinColumn(name = "meeting_id")	//Conexion Meeting
	private Meeting meeting;

	@ManyToOne
	@JoinColumn(name = "guest_id")		//Conexion Guest
	private Guest guest;
	
	@ManyToOne
	@JoinColumn(name = "organizer_id")		
	private Organizer organizer;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	
	
		
}
