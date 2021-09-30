package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StartPlatform {
	BufferedImage image;

	public StartPlatform() {
		try {
			image = ImageIO.read(new File("src//images//StartPlatform.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
}
