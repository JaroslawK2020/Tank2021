package components.BattlePanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShootLeft implements IShoot{

	BufferedImage image;
	int Xposition;
	int Yposition;
	int height = 10;
	int width = 40;
	boolean remove = false;

	boolean isVisible = false;

	public ShootLeft(MyTank myTank) {
		Xposition = myTank.getTankStartXposition();
		Yposition = myTank.getTankStartYposition();
		try {
			image = ImageIO.read(new File("src//images//LaserLeft.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getXposition() {
		return Yposition;
	}

	public int getYposition() {
		return Xposition;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
