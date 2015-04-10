package at.budischek.dividedattentionwebservice;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import at.budischek.dividedattentionwebservice.model.Test;
import at.budischek.dividedattentionwebservice.model.TestDistance;
import at.budischek.dividedattentionwebservice.model.TestReaction;

public class HibernateSessionManager {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Test.class);
			configuration.addAnnotatedClass(TestDistance.class);
			configuration.addAnnotatedClass(TestReaction.class);
		    configuration.configure();
		    serviceRegistry = new ServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}