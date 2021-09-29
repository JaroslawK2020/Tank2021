package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ForestMap {
	BufferedImage image;

	public ForestMap() {
		try {
			image = ImageIO.read(new File("src//images//forest.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
}
