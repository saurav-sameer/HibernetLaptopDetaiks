package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.Update;

import dto.LaptopDetails;
import util.MySesstionFacrory;

public class LaptopDao {
	public static void laptoDetailsSave(LaptopDetails laptopDetails) {
		SessionFactory sessionFactory = MySesstionFacrory.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(laptopDetails);
		transaction.commit();
	}
	
	public static LaptopDetails searchById(int id) {
		SessionFactory SessionFactory = MySesstionFacrory.getSessionFactory();
		Session session = SessionFactory.openSession();
		LaptopDetails laptopDao = session.get(LaptopDetails.class,id);
		return laptopDao;
	}
	public static String deleteLaptopDetails(int id) {
		SessionFactory sessionFactory = MySesstionFacrory.getSessionFactory();
		Session session = sessionFactory.openSession();
		LaptopDetails laptopDetails = searchById(id);
		if(laptopDetails!=null) {
			session.delete(laptopDetails);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			return "Data deleted";
		}
		return "data not delated";
			
	}
	public static LaptopDetails UpdateLptopDetails(int id , int ram,String lpname,String processer) {
		SessionFactory sessionFactory = MySesstionFacrory.getSessionFactory();
		Session session = sessionFactory.openSession();
		LaptopDetails laptopDetails = searchById(id);
		if(laptopDetails!=null) {
			laptopDetails.setLaptopName(lpname);
			laptopDetails.setProcesser(processer);
			laptopDetails.setRam(ram);
			session.update(laptopDetails);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			return laptopDetails;
		}
		return laptopDetails;
	}
}
