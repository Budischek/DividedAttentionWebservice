package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "me_mustererkennung")
public class TestMuster implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "me_id")
	private int id;

	
	@Column(name = "me_t_test")
	private int test;

	@Column(name = "me_m_muster")
	private int muster;

	public TestMuster() {

	}
	
	@Override
	public String toString() {
		return "TestMuster: Test:" + test + " Muster: " + muster;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public int getMuster() {
		return muster;
	}

	public void setMuster(int muster) {
		this.muster = muster;
	}

}
