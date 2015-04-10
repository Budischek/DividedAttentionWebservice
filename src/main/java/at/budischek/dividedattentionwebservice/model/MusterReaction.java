package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "mr_musterreaction")
public class MusterReaction implements Serializable {

	@Id
	@Column(name = "mr_timestamp")
	private int timestamp;

	@Column(name = "mr_reactiontimemin")
	private int reactiontimemin;
	
	@Column(name = "mr_reactiontimemax")
	private int reactiontimemax;

	@Column(name = "mr_m_muster")
	private int muster;

	public MusterReaction() {

	}
	
	@Override
	public String toString() {
		return "Muster: " + muster + " ReactionTimestamp: " + timestamp + " Reaction: " + reactiontimemin + "-" + reactiontimemax;
	}
	
	public static ArrayList<MusterReaction> findMusterReactionByTestId(ArrayList<MusterReaction> musterReactions, int id) {
		ArrayList<MusterReaction> outputReactions = new ArrayList<MusterReaction>();
		for(MusterReaction mr:musterReactions) {
			if(mr.muster==id) {
				outputReactions.add(mr);
			}
		}
		return outputReactions;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getReactiontimemin() {
		return reactiontimemin;
	}

	public void setReactiontimemin(int reactiontimemin) {
		this.reactiontimemin = reactiontimemin;
	}

	public int getReactiontimemax() {
		return reactiontimemax;
	}

	public void setReactiontimemax(int reactiontimemax) {
		this.reactiontimemax = reactiontimemax;
	}

	public int getMuster() {
		return muster;
	}

	public void setMuster(int muster) {
		this.muster = muster;
	}
}
