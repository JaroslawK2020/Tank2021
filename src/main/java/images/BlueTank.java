package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BlueTank implements ITanks {
	List<BufferedImage> images = new ArrayList<BufferedImage>();

	public BlueTank() {
		try {
			images.add(ImageIO.read(new File("src//images//BlueTankRight.png")));
			images.add(ImageIO.read(new File("src//images//BlueTankLeft.png")));
			images.add(ImageIO.read(new File("src//images//BlueTankDown.png")));
			images.add(ImageIO.read(new File("src//images//BlueTankUp.png")));
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