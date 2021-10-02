package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class MineImg implements IDestroyable {
	private BufferedImage image;

	public MineImg() {
		try {
			image = ImageIO.read(new File("src//images//mine.png"));
		}catch(IOException e) {
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
