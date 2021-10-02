package components.BattlePanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ShootRight implements IShoot {

	BufferedImage image;
	int Xposition;
	int Yposition;
	int height = 10;
	int width = 40;
	boolean remove = false;

	boolean isVisible = false;

	public ShootRight(MyTank myTank) {
		Xposition = myTank.getTankStartXposition()+ (myTank.getHeight()/2);
		Yposition = myTank.getTankStartYposition()+ (myTank.getHeight()/2);
		try {
			image = ImageIO.read(new File("src//images//LaserRight.png"));
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
