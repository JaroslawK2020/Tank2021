package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public abstract class PanelSchema extends JPanel {
	
	ImageFactory imageFactory = new ImageFactory();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imageFactory.getMap().get("Background"), 0, 0, 100, 100, null);
	}
	
	
	
	
	@Override
	public Dimension getPreferredSize() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return new Dimension((int)size.getWidth(),(int)size.getHeight());
	}
}
