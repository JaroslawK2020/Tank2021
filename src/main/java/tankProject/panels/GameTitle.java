package tankProject.panels;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameTitle {
	private BufferedImage image;

	public GameTitle() {
		try {
			image = ImageIO.read(new File("gameName.png"));
		}catch(IOException e) {
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
}
