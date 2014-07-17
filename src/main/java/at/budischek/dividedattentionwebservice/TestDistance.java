package at.budischek.dividedattentionwebservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "td_testdistance")
public class TestDistance implements Serializable {

	@Id
	@Column(name = "td_id")
	private int id;

	@Column(name = "td_distance")
	private int distance;

	/*@ManyToOne
    @JoinColumn(name = "t_id")*/
	@Column(name = "td_t_test")
	private int test;

	public TestDistance() {

	}
	
	@Override
	public String toString() {
		return "Test: " + test + " DistanceTimeStamp: " + id + " Distance: " + distance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
}
