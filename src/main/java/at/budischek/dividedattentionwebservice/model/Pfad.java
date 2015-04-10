package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "pf_pfad")
public class Pfad implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "pf_id")
	private int id;
	
	public Pfad() {

	}
	
	@Override
	public String toString() {
		return "Pfad: " + id;
	}
	
	public static Pfad findPfadById(ArrayList<Pfad> pfads, int id) {
		for(Pfad pfad:pfads) {
			if(pfad.getId()==id) {
				return pfad;
			}
		}
		return new Pfad();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
