package tankProject.panels;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	BufferedImage image;

	public Background() {
		try {
			image = ImageIO.read(new File("tankBackground.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
	
}
