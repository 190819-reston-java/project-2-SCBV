package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.revature.models.User;

public class CipherDriver {

	private static Configuration configuration;
	private static StandardServiceRegistryBuilder ssrb;
	private static SessionFactory sf;
	private static Session session;
	
	public static void main(String[] args) {
		
		// boilerplate for hibernate
		configuration = new Configuration().configure();
		ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sf = configuration.buildSessionFactory(ssrb.build());
		// boilerplate for hibernate
		
		// Methods for Database Operations
		//addRecord(); // works - adding new record to db
		//fetchAndUpdate(); // works - fetching and updating record from db
		
	}

	// Adds a record to the database
	private static void addRecord() {
		
		// required session headers
		session = sf.openSession();
		session.beginTransaction();

		// testing adding new record
		User newUser = new User();
		newUser.setUserlastname("Hikari");
		newUser.setUserfirstname("Netto");
		newUser.setUseremail("NHikari@rockmanexe.com");
		newUser.setUserpassword("SlotIn");

		session.save(newUser);
		System.out.println(newUser);

		// required session footer
		session.getTransaction().commit();
		session.close();
		
	}

	// Fetches and Updates a record in the database
	private static void fetchAndUpdate() {
		
		// required session headers
		session = sf.openSession();
		session.beginTransaction();

		// fetching from DB
		System.out.println("getting from DB");
		User fetchUser = (User) session.get(User.class, 1L); // need to be able to set that "#L" to some varable when called by frontend
		System.out.println(fetchUser);

		// updating the fetch
		fetchUser.setUserfirstname("Lan");
		session.update(fetchUser);

		System.out.println(fetchUser);

		// required session footer
		session.getTransaction().commit();
		session.close();
		
	}
//class closed	
}
