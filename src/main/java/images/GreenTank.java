package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class GreenTank implements ITanks {
	List<BufferedImage> images = new ArrayList<BufferedImage>();

	public GreenTank() {
		try {
			images.add(ImageIO.read(new File("src//images//GreenTankRight.png")));
			images.add(ImageIO.read(new File("src//images//GreenTankLeft.png")));
			images.add(ImageIO.read(new File("src//images//GreenTankDown.png")));
			images.add(ImageIO.read(new File("src//images//GreenTankUp.png")));
		} catch (IOException e) {
			e.getMessage();
		}
	}

	@Override
	public BufferedImage getImage() {
		return images.get(0);
	}

	@Override
	public BufferedImage getImage(int key) {
		return images.get(key);
	}
}
