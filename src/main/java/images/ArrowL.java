package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArrowL {
	BufferedImage image;

	public ArrowL() {
		try {
			image = ImageIO.read(new File("src//images//arrowL.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
}
