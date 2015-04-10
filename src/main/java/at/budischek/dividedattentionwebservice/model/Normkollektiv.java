package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "n_normkollektiv")
public class Normkollektiv implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "n_id")
	private int id;

	@Column(name = "n_version")
	private int version;

	@Column(name = "n_ageFrom")
	private int ageFrom;
	
	@Column(name = "n_ageTo")
	private int ageTo;

	@Column(name = "n_female")
	private Boolean female;

	@Column(name = "n_m_muster")
	private int muster;
	
	public Normkollektiv() {

	}
	
	@Override
	public String toString() {
		return "Normkollektiv: " + id + " Muster: " + muster;
	}
	
	public static Normkollektiv findNormkollektivById(ArrayList<Normkollektiv> normkollektivs, int id) {
		for(Normkollektiv normkollektiv:normkollektivs) {
			if(normkollektiv.getId()==id) {
				return normkollektiv;
			}
		}
		return new Normkollektiv();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getAgeFrom() {
		return ageFrom;
	}

	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public Boolean getFemale() {
		return female;
	}

	public void setFemale(Boolean female) {
		this.female = female;
	}

	public int getMuster() {
		return muster;
	}

	public void setMuster(int muster) {
		this.muster = muster;
	}
	
}
