package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "p_punktbewegung")
public class Punktbewegung implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "p_id")
	private int id;
	
	@Column(name = "p_timestamp")
	private int timestamp;

	@Column(name = "p_pf_id")
	private int pfad;

	@Column(name = "p_positionx")
	private int positionX;
	
	@Column(name = "p_positiony")
	private int positionY;
	
	public Punktbewegung() {

	}
	
	@Override
	public String toString() {
		return "Punktbewegung: " + id + " Timestamp: " + timestamp;
	}
	
	public static Punktbewegung findPunktbewegungById(ArrayList<Punktbewegung> punktbewegungs, int id) {
		for(Punktbewegung punktbewegung:punktbewegungs) {
			if(punktbewegung.getId()==id) {
				return punktbewegung;
			}
		}
		return new Punktbewegung();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getPfad() {
		return pfad;
	}

	public void setPfad(int pfad) {
		this.pfad = pfad;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

}
