package tankProject.panels;

import java.util.ArrayList;
import java.util.List;

public class ImageManager {
	private final String background = "background";
	private List<String> imageList = new ArrayList<>();
	
	
	public ImageManager() {
		createList();
	}

	private void createList() {
		imageList.add(background);
	}

	public List<String> getImageList() {
		return imageList;
	}
	
	public int returnImageManagerSize() {
		return imageList.size();
	}

}
