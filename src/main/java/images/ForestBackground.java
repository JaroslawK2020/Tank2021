package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ForestBackground {
	private BufferedImage image;
	
	public ForestBackground() {
		try {
			image = ImageIO.read(new File("src//images//forestArenaBackground.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
}
