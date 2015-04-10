package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "m_muster")
public class Muster implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "m_id")
	private int id;

	@Column(name = "m_age")
	private int age;

	@Column(name = "m_female")
	private Boolean female;
	
	@Column(name = "m_u_id")
	private int ursache;

	@Column(name = "m_te_testeinstellungen")
	private int testsettings;
	
	public Muster() {

	}
	
	@Override
	public String toString() {
		return "Muster: " + id + " Ursache: " + ursache;
	}
	
	public static Muster findMusterById(ArrayList<Muster> musters, int id) {
		for(Muster muster:musters) {
			if(muster.getId()==id) {
				return muster;
			}
		}
		return new Muster();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getFemale() {
		return female;
	}

	public void setFemale(Boolean female) {
		this.female = female;
	}

	public int getUrsache() {
		return ursache;
	}

	public void setUrsache(int ursache) {
		this.ursache = ursache;
	}
	
	public int getTestsettings() {
		return testsettings;
	}

	public void setTestsettings(int testsettings) {
		this.testsettings = testsettings;
	}
}
