package components.BattlePanel;

import java.awt.image.BufferedImage;

public interface IShoot {
	
	BufferedImage getImage();

	int getYposition();

	int getXposition();

	int getWidth();

	int getHeight();
	
	void move();
}
