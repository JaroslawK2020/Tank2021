package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpeakerImg {
	private BufferedImage image;
	private String speakerPath = "src//images//speaker.png";
	
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

	public String getSpeakerPath() {
		return speakerPath;
	}
	
	
	

	
}
