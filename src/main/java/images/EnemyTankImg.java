package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyTankImg {
	private BufferedImage image;

	public EnemyTankImg() {
		try {
			image = ImageIO.read(new File("src//images//enemyTank.png"));
		}catch(IOException e) {
			e.getMessage();
		}
	}

	public BufferedImage getImage() {
		return image;
	}
}
