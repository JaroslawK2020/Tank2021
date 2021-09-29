package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DesertMap {
	BufferedImage image;

	public DesertMap() {
		try {
			image = ImageIO.read(new File("src//images//desert.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
}
