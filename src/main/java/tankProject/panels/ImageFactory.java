package tankProject.panels;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageFactory {	
	private HashMap<String,BufferedImage> map = new HashMap<String,BufferedImage>(); 
	private ImagePathManager imagePathManager;
	private ImageManager imageManager;
	
	public ImageFactory() {
		imagePathManager = new ImagePathManager();
		imageManager = new ImageManager();
		try {
			
			System.out.println(imagePathManager.getPathList().get(0));
			
			for(int i = 0; i < imageManager.returnImageManagerSize() ; i++) {
				map.put(imageManager.getImageList().get(i), (BufferedImage) ImageIO.read(new File(imagePathManager.getPathList().get(i))));
			}	

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public HashMap<String, BufferedImage> getMap() {
		return map;
	}
	
	
	
	
	
	
}
