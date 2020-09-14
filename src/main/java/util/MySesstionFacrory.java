package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySesstionFacrory {
private static SessionFactory sessionFactory=null;
	
	private MySesstionFacrory() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) 
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		return sessionFactory;
	}
}
