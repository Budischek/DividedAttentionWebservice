package at.budischek.dividedattentionwebservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "t_test")
public class Test implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "t_id")
	private int id;

	@Column(name = "t_age")
	private int age;

	@Column(name = "t_date")
	private Date date;

	@Column(name = "t_female")
	private Boolean female;
	
	@Column(name = "t_resolutionx")
	private int resolutionx;

	@Column(name = "t_resolutiony")
	private int resolutiony;

	public Test() {

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getFemale() {
		return female;
	}

	public void setFemale(Boolean female) {
		this.female = female;
	}

	public int getResolutionx() {
		return resolutionx;
	}

	public void setResolutionx(int resolutionx) {
		this.resolutionx = resolutionx;
	}

	public int getResolutiony() {
		return resolutiony;
	}

	public void setResolutiony(int resolutiony) {
		this.resolutiony = resolutiony;
	}
	
	@Override
	public String toString() {
		return "Test: " + id + " Date: " + date;
	}
}
