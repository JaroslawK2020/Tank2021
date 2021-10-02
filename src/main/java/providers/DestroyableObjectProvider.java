package providers;

import java.util.ArrayList;
import java.util.List;

import images.IDestroyable;
import images.MineImg;
import images.ReactorImg;

public class DestroyableObjectProvider {
	private List<IDestroyable> destroyableObjectsList = new ArrayList<IDestroyable>();
	
	public DestroyableObjectProvider() {
		destroyableObjectsList.add(new MineImg());
		destroyableObjectsList.add(new ReactorImg());		
	}

	public List<IDestroyable> getDestroyableObjects() {
		return destroyableObjectsList;
	}
	
	
}
