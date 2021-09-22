package tankProject.panels;

import java.util.ArrayList;
import java.util.List;

public class ImagePathManager {
	
	private final String backgroundPath = "tankBackground.jpg";
	private List<String> pathList = new ArrayList<>();
	
	
	public ImagePathManager() {
		createList();
	}

	private void createList() {
		pathList.add(backgroundPath);
	}

	public List<String> getPathList() {
		return pathList;
	}
	

}
