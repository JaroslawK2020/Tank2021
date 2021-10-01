package components.BattlePanel;

import java.awt.image.BufferedImage;

public class MyTank {
	private BufferedImage tankImg;
	private int tankStartXposition;
	private int tankStartYposition;
	private int width = 60;
	private int height = 50;

	public MyTank(BufferedImage tankImg, int tankStartXposition, int tankStartYposition) {
		this.tankImg = tankImg;
		this.tankStartXposition = tankStartXposition;
		this.tankStartYposition = tankStartYposition;
	}

	public int getTankStartXposition() {
		return tankStartXposition;
	}

	public void setTankStartXposition(int tankStartXposition) {
		this.tankStartXposition = tankStartXposition;
	}

	public int getTankStartYposition() {
		return tankStartYposition;
	}

	public void setTankStartYposition(int tankStartYposition) {
		this.tankStartYposition = tankStartYposition;
	}

	public BufferedImage getTankImg() {
		return tankImg;
	}

	public void setTankImg(BufferedImage image) {
		tankImg = image;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
