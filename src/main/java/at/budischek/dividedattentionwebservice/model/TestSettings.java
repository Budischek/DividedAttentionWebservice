package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "te_testeinstellungen")
public class TestSettings implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "te_id")
	private int id;
	
	@Column(name = "te_pf_pfad")
	private int pfad;
	
	@Column(name = "te_sb_id")
	private int storyboard;
	
	public TestSettings() {

	}
	
	@Override
	public String toString() {
		return "Storyboard: " + id;
	}
	
	public static TestSettings findStoryboardById(ArrayList<TestSettings> storyboards, int id) {
		for(TestSettings storyboard:storyboards) {
			if(storyboard.getId()==id) {
				return storyboard;
			}
		}
		return new TestSettings();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPfad() {
		return pfad;
	}

	public void setPfad(int pfad) {
		this.pfad = pfad;
	}

	public int getStoryboard() {
		return storyboard;
	}

	public void setStoryboard(int storyboard) {
		this.storyboard = storyboard;
	}
}
