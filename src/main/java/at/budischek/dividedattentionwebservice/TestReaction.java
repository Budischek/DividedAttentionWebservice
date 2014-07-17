package at.budischek.dividedattentionwebservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tr_testreaction")
public class TestReaction implements Serializable {

	@Id
	@Column(name = "tr_timestamp")
	private int timestamp;

	@Column(name = "tr_reactiontime")
	private int reactiontime;

	/*@ManyToOne
    @JoinColumn(name = "t_id")*/
	@Column(name = "tr_t_test")
	private int test;

	public TestReaction() {

	}
	
	@Override
	public String toString() {
		return "Test: " + test + " ReactionTimestamp: " + timestamp + " Reaction: " + reactiontime;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getReactiontime() {
		return reactiontime;
	}

	public void setReactiontime(int reactiontime) {
		this.reactiontime = reactiontime;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

}
