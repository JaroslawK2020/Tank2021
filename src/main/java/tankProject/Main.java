package tankProject;

import java.awt.EventQueue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Database.DatabaseManager;
import appRunner.AppRunner;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new AppRunner();
				new DatabaseManager();
				
			}
		});
	}
}
