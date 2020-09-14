package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dto.LaptopDetails;
import util.MySesstionFacrory;

public class LaptopDaoHql {
	public static LaptopDetails searchById(int id) {
		LaptopDetails laptopDetails=null;
		SessionFactory sessionFactory = MySesstionFacrory.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hql="from LaptopDetails where id=:newid";
		Query query = session.createQuery(hql);
		query.setParameter("newid", id);
		laptopDetails= (LaptopDetails) query.uniqueResult();
		if(laptopDetails!=null)
			return laptopDetails;
		return laptopDetails;
	}
	public static LaptopDetails updateLpDetails(int id , int ram,String lpname,String processer) {
		LaptopDetails laptopDetails=null;
		SessionFactory sessionFactory = MySesstionFacrory.getSessionFactory();
		Session session = sessionFactory.openSession();
		String hql="update LaptopDetails set laptopName=:newlaptopName,processer=:newprocesser,ram=:newram where id=:newid";
		Query query = session.createQuery(hql);
		query.setParameter("newlaptopName",lpname);
		query.setParameter("newprocesser", processer);
		query.setParameter("newram", ram);
		query.setParameter("newid", id);
		int executeUpdate = query.executeUpdate();
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		if(executeUpdate>0) {
		  return searchById(id);
		}
		return laptopDetails;
	}
	public static String delateLaptopDetails(int id) {
		SessionFactory factory = MySesstionFacrory.getSessionFactory();
		Session session = factory.openSession();
		String hql="delete from LaptopDetails where id=:newid";
		Query query = session.createQuery(hql);
		query.setParameter("newid", id);
		int executeUpdate = query.executeUpdate();
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		if(executeUpdate>0)
			return "data delete";
		return "Not data delete";
	}
}
