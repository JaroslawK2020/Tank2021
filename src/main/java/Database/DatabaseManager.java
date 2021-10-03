package Database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {

	private Session session;

	public DatabaseManager() {
	}

	public void addNewUser(String nickname, int tankId) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			Players players = new Players();

			players.setNickname(nickname);
			players.setTankId(tankId);
			players.setScores(0);
			players.setLvl(1);

			session.save(players);
			session.getTransaction().commit();
			session.close();
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
			int res = (int) query.getResultList().size();
			session.close();
			return res;
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
			int res = (int) query.getResultList().get(0);
			session.close();
			return res;
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
			int res = (int) query.getResultList().get(0);
			session.close();
			return res;
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
			List res = query.getResultList();
			session.close();
			return res;
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
			int res = (int) query.getResultList().get(0);
			session.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void setNewScores(String nickname, int scores) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			Transaction transaction = session.beginTransaction();

			String hql = "update Players set scores =" + scores + " where  nickname = '" + nickname + "'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setNewLvl(String nickname, int newLvl) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.getCurrentSession();

			Transaction transaction = session.beginTransaction();

			String hql = "update Players set lvl =" + newLvl + " where  nickname = '" + nickname + "'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
