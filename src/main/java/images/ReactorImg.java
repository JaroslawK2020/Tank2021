package images;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReactorImg implements IDestroyable {
	private BufferedImage image;
	private int objectXPositon;
	private int objectYPosition;
	private int heigth=100;
	private int width=100;
	
	public ReactorImg() {
		try {
			image = ImageIO.read(new File("src//images//reactor.png"));
		} catch (IOException e) {
			e.getMessage();
		}
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}

	@Override
	public boolean isDestroyAble() {
		return true;
	}
	
	private int returnScreenWidth() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getWidth();
	}

	private int returnScreenHeight() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getHeight();
	}
	
	@Override
	public int drawDestroyableObjectPositionX() {
		final int LOWER_RANGE = 100;
		final int UPPER_RANGE = returnScreenWidth() - 200;
		int drawNum = (int)(Math.random() * (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE);
		while(drawNum % 100 != 0)
			drawNum = (int)(Math.random() * (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE);
		return drawNum;
	}

	@Override
	public int getObjectXPosition() {
		return objectXPositon;
	}

	@Override
	public void setObjectXPosition() {
		objectXPositon = drawDestroyableObjectPositionX();
	}

	@Override
	public int drawDestroyableObjectPositionY() {
		final int LOWER_RANGE = 100;
		final int UPPER_RANGE = returnScreenHeight() - 100;
		int drawNum = (int)(Math.random() * (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE);
		while(drawNum % 100 != 0)
			drawNum = (int)(Math.random() * (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE);
		return drawNum;
	}

	@Override
	public int getObjectYPosition() {
		return objectYPosition;
	}

	@Override
	public void setObjectYPosition() {
		objectYPosition = drawDestroyableObjectPositionY();
	}

	public int getHeigth() {
		return heigth;
	}

	public int getWidth() {
		return width;
	}
	
	@Override
	public void mediumLVL() {

	}

	@Override
	public void hardLVL() {

	}

	@Override
	public void expertLVL() {
	
	}

	@Override
	public void madnessLVL() {
	
	}
}
