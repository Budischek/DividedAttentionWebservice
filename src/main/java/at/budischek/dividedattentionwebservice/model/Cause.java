package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "u_ursache")
public class Cause implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "u_id")
	private int id;

	@Column(name = "u_beschreibung")
	private String description;

	public Cause() {

	}
	
	@Override
	public String toString() {
		return "Ursache: " + id + "  " + description;
	}
	
	public static Cause findCauseById(ArrayList<Cause> causes, int id) {
		for(Cause cause:causes) {
			if(cause.getId()==id) {
				return cause;
			}
		}
		return new Cause();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
