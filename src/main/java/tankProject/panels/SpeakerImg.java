package tankProject.panels;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpeakerImg {
	private BufferedImage image;
	
	public SpeakerImg() {
		try {
			image = ImageIO.read(new File("src//images//speaker.png"));
		}catch(IOException e) {
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	
}
