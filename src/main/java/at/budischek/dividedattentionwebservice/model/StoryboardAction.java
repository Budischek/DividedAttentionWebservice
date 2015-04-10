package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "s_storyboardaction")
public class StoryboardAction implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "s_id")
	private int id;

	@Column(name = "s_time")
	private int timestamp;

	@Column(name = "s_action")
	private int action;
	
	@Column(name = "s_duration")
	private int duration;
	
	public StoryboardAction() {

	}
	
	@Override
	public String toString() {
		return "StoryboardAction: " + id + " Action: " + action;
	}
	
	public static StoryboardAction findStoryboardActionById(ArrayList<StoryboardAction> storyboardactions, int id) {
		for(StoryboardAction storyboardaction:storyboardactions) {
			if(storyboardaction.getId()==id) {
				return storyboardaction;
			}
		}
		return new StoryboardAction();
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

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
