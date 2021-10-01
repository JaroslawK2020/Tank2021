package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class RedTank implements ITanks {
	List<BufferedImage> images = new ArrayList<BufferedImage>();

	public RedTank() {
		try {
			images.add(ImageIO.read(new File("src//images//RedTankRight.png")));
			images.add(ImageIO.read(new File("src//images//RedTankLeft.png")));
			images.add(ImageIO.read(new File("src//images//RedTankDown.png")));
			images.add(ImageIO.read(new File("src//images//RedTankUp.png")));
		} catch (IOException e) {
			e.getMessage();
		}
	}
	public BufferedImage getImage() {
		return images.get(0);
	}

	public BufferedImage getImage(int key) {
		return images.get(key);
	}
}
