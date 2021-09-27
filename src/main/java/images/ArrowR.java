package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArrowR {
	BufferedImage image;

	public ArrowR() {
		try {
			image = ImageIO.read(new File("src//images//arrowR.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
}