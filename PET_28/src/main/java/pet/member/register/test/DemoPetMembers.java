package pet.member.register.test;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import pet.member.register.model.PetMembers;
import util.HibernateUtil;

public class DemoPetMembers {

	public static void main(String[] args) {
		
		 SessionFactory factory = HibernateUtil.getSessionFactory();
		 Session session = factory.getCurrentSession();		 
		 
		 try {		
		 	session.beginTransaction();
		 	
		 	PetMembers pm = new PetMembers();		 	
		 	
		 	pm.setEmail("123@oulook.com");
		 	pm.setPassword("123");
		 	pm.setUsername("咚咚");
		 	pm.setGender("M");
		 	pm.setBday(Date.valueOf("2020-02-02"));
		 	pm.setAge(28);
		 	pm.setAddress("台北市");
		 	pm.setPhone("23456789");
		 	
		 	pm.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		 	
		 	session.save(pm);
		 
		 	session.getTransaction().commit();
		 
		 }catch(Exception e) {
			 e.printStackTrace();
			 session.getTransaction().rollback();
		 }
		 
		 HibernateUtil.closeSessionFactory();
	}

}
