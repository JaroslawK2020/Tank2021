package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReactorImg implements IDestroyable {
	private BufferedImage image;

	public ReactorImg() {
		try {
			image = ImageIO.read(new File("src//images//reactor.png"));
		} catch (IOException e) {
			e.getMessage();
		}
	}

	@Override
	public BufferedImage getImage() {
		return image;
	}

	@Override
	public boolean isDestroyAble() {
		return true;
	}
}
