package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CityMap {
	BufferedImage image;

	public CityMap() {
		try {
			image = ImageIO.read(new File("src//images//city.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
}
