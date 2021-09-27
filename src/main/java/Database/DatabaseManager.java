package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {
	
	Session session; 
	public DatabaseManager() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.getCurrentSession();
		x();
	}
	
	public void x() {
		try {
			session.beginTransaction();
			
			Players players = new Players();
			
			players.setNickname("Jaro");
			players.setScores(250);
			
			
			session.save(players);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

