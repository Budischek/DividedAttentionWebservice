package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "sb_storyboard")
public class Storyboard implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "sb_id")
	private int id;
	
	public Storyboard() {

	}
	
	@Override
	public String toString() {
		return "Storyboard: " + id;
	}
	
	public static Storyboard findStoryboardById(ArrayList<Storyboard> storyboards, int id) {
		for(Storyboard storyboard:storyboards) {
			if(storyboard.getId()==id) {
				return storyboard;
			}
		}
		return new Storyboard();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
