package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	@Column(name = "t_te_testeinstellungen")
	private int testsettings;

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
	
	public int getTestsettings() {
		return testsettings;
	}

	public void setTestsettings(int testsettings) {
		this.testsettings = testsettings;
	}
	
	@Override
	public String toString() {
		return "Test: " + id + " Date: " + date;
	}
	
	public static Test findTestById(ArrayList<Test> tests, int id) {
		for(Test test:tests) {
			if(test.getId()==id) {
				return test;
			}
		}
		return new Test();
	}
}
