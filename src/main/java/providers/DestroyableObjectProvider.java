package providers;

import java.util.ArrayList;
import java.util.List;

import images.IDestroyable;
import images.MineImg;
import images.ReactorImg;

public class DestroyableObjectProvider {
	private List<List<IDestroyable>> destroyableObjectsList = new ArrayList<List<IDestroyable>>();
	
	
	public DestroyableObjectProvider() {
		destroyableObjectsList.add(new MinesProvider().getMinesList());
		destroyableObjectsList.add(new ReactorsProvider().getReactorsList());

	}

	public List<List<IDestroyable>> getDestroyableObjects() {
		return destroyableObjectsList;
	}
}
