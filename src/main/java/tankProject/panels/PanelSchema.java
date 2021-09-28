package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Database.DatabaseManager;

public abstract class PanelSchema extends JPanel {
	
	DatabaseManager databaseManager;
	
	public PanelSchema() {
		setLayout(null);
		databaseManager = new DatabaseManager();
	}
	
	public int returnScreenWidth() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getWidth();
	}

	public int returnScreenHeight() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getHeight();
	}

	protected float calculateWidth(float x) {
		return  (returnScreenWidth() / 100) * x;
	}

	protected float calculateHeight(float x) {
		return (returnScreenHeight() / 100) * x;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(), returnScreenHeight());

	}
}
