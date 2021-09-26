package tankProject.panels;

import java.awt.Graphics;

import images.BattleImage;

public class BasicPanel extends PanelSchema {
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new BattleImage().getImage(), 0, 0, super.returnScreenWidth()/2,super.returnScreenHeight()/2,null);

	}
}
