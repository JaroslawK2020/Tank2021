package Database;

import java.util.ArrayList;
import java.util.List;

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
			players.setTankId(0);
			players.setScores(0);
			players.setLvl(0);

			session.save(players);
			session.getTransaction().commit();
			// should session be closed?
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
			// should session be closed?
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getUserScores(String nickname) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			String hql = "SELECT scores FROM Players WHERE nickname ='" + nickname + "'";
			Query query = session.createQuery(hql);
			return (int) query.getResultList().get(0);
			// should session be closed?
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getLvl(String nickname) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			String hql = "SELECT lvl FROM Players WHERE nickname ='" + nickname + "'";
			Query query = session.createQuery(hql);
			return (int) query.getResultList().get(0);
			// should session be closed?
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<String> getPlayers() {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			String hql = "SELECT nickname FROM Players";
			Query query = session.createQuery(hql);

			return query.getResultList();

			// should session be closed?
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
	
	public int getUserTank(String nickname) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			String hql = "SELECT tankId FROM Players WHERE nickname ='" + nickname + "'";
			Query query = session.createQuery(hql);
			return (int) query.getResultList().get(0);
			// should session be closed?
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
