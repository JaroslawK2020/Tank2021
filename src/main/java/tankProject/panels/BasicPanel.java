package tankProject.panels;

import java.awt.Graphics;

import images.BattleImage;

public class BasicPanel extends PanelSchema {
	
	protected int width = returnScreenWidth();
	protected int height = returnScreenHeight();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new BattleImage().getImage(), 0, 0, width, height,null);

	}
}
