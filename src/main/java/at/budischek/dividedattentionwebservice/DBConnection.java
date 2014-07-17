package at.budischek.dividedattentionwebservice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import at.budischek.dividedattentionwebservice.HibernateSessionManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class DBConnection {

	Session session;
	
	public DBConnection() {
		session = HibernateSessionManager.getSessionFactory()
				.openSession();
	}
	
	public void printDB() {
		ArrayList<Test>tests = queryTests();
		for(Test test : tests) { 
			Gson gson = new Gson(); 
			String json = gson.toJson(test);
			System.out.println(json); 
		 }
		
		 ArrayList<TestDistance> tdistances = queryTestDistances();
		 for(TestDistance distances : tdistances) { 
			Gson gson = new Gson(); 
			String json = gson.toJson(distances);
			System.out.println(json); 
		 }
		 
		 ArrayList<TestReaction> treactions = queryTestReactions();
		 for(TestReaction reaction : treactions) { 
			Gson gson = new Gson(); 
			String json = gson.toJson(reaction);
			System.out.println(json); 
		 }
	}
	
	public void test() {
		Gson gson = new Gson();
		ArrayList<Test> tests = queryTests();
		String temp = gson.toJson(tests);
		System.out.println(temp);
		tests = gson.fromJson(temp, new TypeToken<List<Test>>(){}.getType());
		for(Test t : tests) {
			System.out.println(t.toString());
		}
	}
	
	public ArrayList<Test> queryTests() {
		Query query = session.createQuery("from Test");
		 List list = query.list();
		 ArrayList<Test> tests = (ArrayList<Test>) list;
		 return tests;
	}
	
	public ArrayList<TestDistance> queryTestDistances() {
		Query query = session.createQuery("from TestDistance");
		 List list = query.list();
		 ArrayList<TestDistance> testdistances = (ArrayList<TestDistance>) list;
		 return testdistances;
	}
	
	public ArrayList<TestReaction> queryTestReactions() {
		Query query = session.createQuery("from TestReaction");
		 List list = query.list();
		 ArrayList<TestReaction> testreactions = (ArrayList<TestReaction>) list;
		 return testreactions;
	}

}