package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public abstract class PanelSchema extends JPanel {
	
	protected int returnScreenWidth() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getWidth();
	}
	
	protected int returnScreenHeight() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getHeight();
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(),returnScreenHeight());
	}
}
