package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TankImage_1 implements ITanks{
	BufferedImage image;

	public TankImage_1() {
		try {
			image = ImageIO.read(new File("src//images//tank1bigBlueTank.png"));
		}catch(IOException e){
			e.getMessage();
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
