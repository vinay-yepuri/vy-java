/**
 * 
 */
package com.vinay.hibernate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author VINAY
 *
 */
public class HibernateBasicTestClass {
	
	private SessionFactory factory;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HibernateBasicTestClass test = new HibernateBasicTestClass();
		Configuration config = new Configuration();
		config.configure();
		test.factory = config.buildSessionFactory();
		
		Employee e = new Employee();
		e.setId(400);
		e.setName("ABC");
		e.setSal(50000);
		test.createEmployeee(e);
	}
	
	public void createEmployeee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		// Opens new session
		try {
				session = factory.openSession();
				tx = session.beginTransaction();
				session.save(emp);
				tx.commit();
				System.out.println("Employee crearted with ID : "+emp.getId());
			
		}catch(HibernateException he) {
			tx.rollback();
			System.out.println("Excception in creating employee");
		}
		finally {
			session.close();
		}
	}

}
