package Database;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {

	private Session session;

	public DatabaseManager() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	}

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
	}

	public int verifyIfNicknameExist(String nickname) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			String hql = "FROM Players WHERE nickname ='" + nickname + "'";
			Query query = session.createQuery(hql);
			return query.getResultList().size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void closeSession() {
		if (session != null) {
			session.close();
			System.out.println("session closed");
		}
	}

}
