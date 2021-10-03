package images;

import java.awt.image.BufferedImage;

public interface IDestroyable {
	BufferedImage getImage();

	boolean isDestroyAble();
	
	int drawDestroyableObjectPositionX();
	
	int getObjectXPosition();
	
	void setObjectXPosition();
	
	int drawDestroyableObjectPositionY();
	
	int getObjectYPosition();
	
	void setObjectYPosition();
	
	void mediumLVL();
	
	void hardLVL();
	
	void expertLVL();
	
	void madnessLVL();

}
