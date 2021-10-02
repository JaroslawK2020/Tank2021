package components.BattlePanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShootDown implements IShoot{

	BufferedImage image;
	int Xposition;
	int Yposition;
	int height = 40;
	int width = 10;
	boolean remove = false;

	boolean isVisible = false;

	public ShootDown(MyTank myTank) {
		Xposition = myTank.getTankStartXposition()+ (myTank.getHeight() / 2);
		Yposition = myTank.getTankStartYposition();
		try {
			image = ImageIO.read(new File("src//images//LaserDown.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	public int getXposition() {
		return Xposition;
	}

	public int getYposition() {
		return Yposition;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void move() {
		Yposition += 60;
	}
}
