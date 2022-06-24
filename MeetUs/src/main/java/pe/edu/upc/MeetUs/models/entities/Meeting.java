package pe.edu.upc.MeetUs.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name= "meetings", indexes = {@Index(columnList = "meeting_name", name = "meetings_index_meeting_name")})
public class Meeting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "m_name", length = 30,nullable = false)
	private String name;
	
	@Column(name = "m_date", length = 10,nullable = false)
	private String date;
	
	@Column(name = "m_hour", length = 8,nullable = false)
	private String hour;
	
	@Column(name = "m_type", length = 20,nullable = false)
	private String type;
	
	@Column(name = "m_description", length = 50,nullable = false)
	private String description;
	
	@Column(name = "m_urltoimage", length = 200, nullable = true)
	private String UrlToImage;
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	private Local local;	//local_owner id

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlToImage() {
		return UrlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		UrlToImage = urlToImage;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
}
