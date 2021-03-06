package hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();

	//method buildSessionFactory
	private static SessionFactory buildSessionFactory(){
		
		Configuration configuration = new Configuration();
		configuration.configure("properties/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    
		//build a session factory from the service registry
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
