package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import providers.IMaps;

public class DesertMap implements IMaps{
	BufferedImage image;
	int hoverValue = 0;
	boolean isSelected = false;
	int index = 2;

	public DesertMap() {
		try {
			image = ImageIO.read(new File("src//images//desert.jpg"));
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getHoverValue() {
		return hoverValue;
	}

	public void setHoverValue(int hoverValue) {
		this.hoverValue = hoverValue;
	}

	public boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;

	}

	public int getIndex() {
		return index;
	}
}
