package images;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class MineImg implements IDestroyable {
	private BufferedImage image;
	private int objectXPositon;
	private int objectYPosition;

	public MineImg() {
		try {
			image = ImageIO.read(new File("src//images//mine.png"));
		}catch(IOException e) {
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
		final int LOWER_RANGE = 50;
		final int UPPER_RANGE = returnScreenWidth() - 50;
		int drawNum = (int)(Math.random() * (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE);
		if(drawNum % 100 == 0)
			return drawNum;
		else 
			drawDestroyableObjectPositionX();
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
		final int LOWER_RANGE = 50;
		final int UPPER_RANGE = returnScreenHeight() - 50;
		int drawNum = (int)(Math.random() * (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE);
		if(drawNum % 100 == 0)
			return drawNum;
		else 
			drawDestroyableObjectPositionY();
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
