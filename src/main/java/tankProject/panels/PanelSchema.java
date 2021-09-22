package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public abstract class PanelSchema extends JPanel {
	private ImageFactory imageFactory = new ImageFactory();
	
	private int returnScreenWidth() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getWidth();
	}
	
	private int returnScreenHeight() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getHeight();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(imageFactory.getMap().get("background"), 0, 0, returnScreenWidth(), returnScreenHeight(), null);
	}
	
	
	
	
	@Override
	public Dimension getPreferredSize() {
		
		return new Dimension(returnScreenWidth(),returnScreenHeight());
	}
}
