package components.BattlePanel;
import java.awt.image.BufferedImage;

import images.EnemyTankImg;

public class EnemyTank {
	private BufferedImage tankImage;
	private EnemyTankImg enemyTankImg = new EnemyTankImg();
	private int width = 50;
	private int height = 50;
	private int tankXposition;
	private int tankYposition;
	private boolean isAlive = true;
	

	public EnemyTank() {
		this.tankImage = enemyTankImg.getImage();
	}


	public EnemyTankImg getEnemyTankImg() {
		return enemyTankImg;
	}


	public void setEnemyTankImg(EnemyTankImg enemyTankImg) {
		this.enemyTankImg = enemyTankImg;
	}


	public int getTankXposition() {
		return tankXposition;
	}


	public void setTankXposition(int tankXposition) {
		this.tankXposition = tankXposition;
	}


	public int getTankYposition() {
		return tankYposition;
	}


	public void setTankYposition(int tankYposition) {
		this.tankYposition = tankYposition;
	}


	public boolean isAlive() {
		return isAlive;
	}


	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}
	
	
	
	
	
}
