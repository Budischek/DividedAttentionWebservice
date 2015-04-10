package at.budischek.dividedattentionwebservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "md_musterdistance")
public class MusterDistance implements Serializable {

	@Id
	@Column(name = "md_id")
	private int id;

	@Column(name = "md_distancemin")
	private int distancemin;
	
	@Column(name = "md_distancemax")
	private int distancemax;

	@Column(name = "md_m_muster")
	private int muster;

	public MusterDistance() {

	}
	
	@Override
	public String toString() {
		return "Muster: " + muster + " DistanceTimeStamp: " + id + " Distance: " + distancemin + "-" + distancemax;
	}
	
	public static ArrayList<MusterDistance> findMusterDistanceByTestId(ArrayList<MusterDistance> musterDistances, int id) {
		ArrayList<MusterDistance> outputDistances = new ArrayList<MusterDistance>();
		for(MusterDistance md:musterDistances) {
			if(md.muster==id) {
				outputDistances.add(md);
			}
		}
		return outputDistances;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMuster() {
		return muster;
	}

	public void setMuster(int muster) {
		this.muster = muster;
	}

	public int getDistancemin() {
		return distancemin;
	}

	public void setDistancemin(int distancemin) {
		this.distancemin = distancemin;
	}

	public int getDistancemax() {
		return distancemax;
	}

	public void setDistancemax(int distancemax) {
		this.distancemax = distancemax;
	}
}
