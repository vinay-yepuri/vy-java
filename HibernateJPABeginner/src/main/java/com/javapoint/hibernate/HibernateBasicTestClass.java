package com.javapoint.hibernate;
/**
 * 
 */



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.javabrains.vinay.dto.UserDetails;

/**
 * @author VINAY
 *
 */
public class HibernateBasicTestClass {
	
	private SessionFactory factory;

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
//		UserDetails userDetails = new UserDetails();
//		/* userDetails.setUserId(1); */
//		userDetails.setUserName("First User");
//		userDetails.setJoiningDate(new Date());
//		userDetails.setDescription("Description of the user goes here");
//		
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleName("Car");
//		
//		Vehicle vehicle1 = new Vehicle();
//		vehicle1.setVehicleName("Jeep");
//		
//		userDetails.getVehicle().add(vehicle);
//		userDetails.getVehicle().add(vehicle1);
		
//		vehicle.getUserDetails().add(userDetails);
//		vehicle1.getUserDetails().add(userDetails);
		
		/*
		 * vehicle.setUserDetails(userDetails); vehicle1.setUserDetails(userDetails);
		 */
		/*
		 * Addess homeAddress = new Addess(); homeAddress.setStreet("Home Street name");
		 * homeAddress.setCity("Home City name");
		 * homeAddress.setState("Home State name");
		 * homeAddress.setPincode("Home Pincode name"); //
		 * userDetails.setHomeAddress(homeAddress);
		 * 
		 * Addess officeAddress = new Addess();
		 * officeAddress.setStreet("Office Street name");
		 * officeAddress.setCity("Office City name");
		 * officeAddress.setState("Office State name");
		 * officeAddress.setPincode("Office Pincode name"); //
		 * userDetails.setOfficeAddress(officeAddress);
		 */		
		/*
		 * userDetails.getSetOfAddresses().add(homeAddress);
		 * userDetails.getSetOfAddresses().add(officeAddress);
		 * 
		 */
		
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVehicleName("car");
//		
//		TwoWheeler bike = new TwoWheeler();
//		bike.setVehicleName("Bike");
//		bike.setSteeringHandle("Bike Steering Handle");
//		
//		FourWheeler car = new FourWheeler();
//		car.setVehicleName("Porsche");
//		car.setSteeringWheel("Porsche Steering Wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Implementing first level cache
		UserDetails user = session.get(UserDetails.class, 7);
		
		user.setUserName("Updated user name");
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails user2 = session.get(UserDetails.class, 7);
		
		session2.getTransaction().commit();
		session2.close();
		
//		UserDetails user6 = session.get(UserDetails.class, 5);
//		
//		user6.setUserName("Updated User");
//		session.update(user6);
		
		
		
		//session.delete(user6);
		
//		for(int i = 0;i < 10;i++) {
//			UserDetails user  = new UserDetails();
//			user.setUserName("User "+i);
//			session.save(user);
//		}
		
		//Query query = session.createQuery("select userId,userName from UserDetails");
		//Query query = session.createQuery("from UserDetails where userId > :userID");
		//Query query = session.getNamedQuery("UserDetails.byName");
//		UserDetails exampleUser = new UserDetails();
//		exampleUser.setUserId(5);
//		exampleUser.setUserName("User 7");
//		
//		Example example = Example.create(exampleUser);
//		
//		Criteria criteria = session.createCriteria(UserDetails.class);
//		criteria.add(example);
		//criteria.setProjection(Projections.property("userName")).addOrder(Order.asc("userName"));
	//	criteria.setProjection(Projections.max("userId"));
//		criteria.add(Restrictions.eq("userName", "User 9"))
//				.add(Restrictions.gt("userId", 5));
	//	List<String> list = (List<String>)criteria.list();
		//query.setInteger(1, 5);
		//query.setString(1, "User 6");
		//query.setFirstResult(1);
		//query.setMaxResults(3);
		//List<Object[]> list = (List<Object[]>)query.list();
		//List<UserDetails> list = (List<UserDetails>)query.list();
		//session.save(userDetails);
//		session.save(vehicle);
//		session.save(bike);
//		session.save(car);

		
		
		//System.out.println("User Name : "+user6.getUserName());
		//System.out.println("List size : "+list.size());
		
//		for( String user: list) {
//			//System.out.print(" ID : "+user.getUserId()+"\t");
//			System.out.println("User Name : "+user);
//		}
		
//		for( Object[] user: list) {
//			System.out.println(" ID : "+user[0]);
//			System.out.println("User Name : "+user[1]);
//		}

		/*
		 * userDetails = null;
		 * 
		 * session = sessionFactory.openSession(); session.beginTransaction();
		 * userDetails = session.get(UserDetails.class, 1); session.close();
		 * 
		 * userDetails = null;
		 * 
		 * session = sessionFactory.openSession(); userDetails =
		 * session.get(UserDetails.class, 1); session.close();
		 */
		/* System.out.println("Size : "+userDetails.getSetOfAddresses().size()); */
		

		/*
		 * HibernateBasicTestClass test = new HibernateBasicTestClass(); Configuration
		 * config = new Configuration(); config.configure(); test.factory =
		 * config.buildSessionFactory();
		 * 
		 * Employee e = new Employee(); e.setId(900); e.setName("ABC"); e.setSal(50000);
		 * test.createEmployeee(e);
		 */
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
