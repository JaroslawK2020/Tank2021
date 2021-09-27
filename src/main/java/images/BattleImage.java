package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BattleImage {
	BufferedImage image;

	public BattleImage() {
		try {
			image = ImageIO.read(new File("src//images//battlefield.jpg"));
		}catch(IOException e){
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
	
}
