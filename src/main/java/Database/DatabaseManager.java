package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {
	Session session;
	
	public void addNewUser(String nickname, int tankId) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();
			
			Players players = new Players();
			
			players.setNickname(nickname);
			players.setTankId(tankId);
			
			
			session.save(players);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	
	public void verifyIfNicknameExist(String nickname) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();
			
			Players players = new Players();
			
			players.getNickname();
			
			
			session.save(players);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}

