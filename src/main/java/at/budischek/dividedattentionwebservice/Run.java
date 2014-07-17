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


public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateSessionManager.getSessionFactory()
				.openSession();
		 Query query = session.createQuery("from Test");
		 List list = query.list();
		 ArrayList<Test> tests = (ArrayList<Test>) list;
		 for(Test test : tests) { 
			Gson gson = new Gson(); 
			String json = gson.toJson(test);
			System.out.println(json); 
			/*Type collectionType = new TypeToken<Collection <WishItem>>(){}.getType();
			ArrayList<WishItem> wishes = gson.fromJson(json, collectionType);
			for(WishItem wish : wishes) {
				 System.out.println(gson.toJson(wish)); 
			}*/
		 }
				 
	}

}