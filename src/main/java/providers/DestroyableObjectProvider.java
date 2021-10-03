package providers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import images.IDestroyable;
import images.MineImg;
import images.ReactorImg;

public class DestroyableObjectProvider {
	private List<List<IDestroyable>> destroyableObjectsList = new ArrayList<List<IDestroyable>>();
	
	public DestroyableObjectProvider(int lvl) {
		destroyableObjectsList.add(new MinesProvider(lvl).getMinesList());
		destroyableObjectsList.add(new ReactorsProvider(lvl).getReactorsList());
		setUpObjectPosition();
	}
	
	private void setUpObjectPosition() {
		for (int i = 0; i < destroyableObjectsList.size(); i++) {
			for (int j = 0; j < destroyableObjectsList.get(i).size(); j++) {
				destroyableObjectsList.get(i).get(j).setObjectXPosition();
				destroyableObjectsList.get(i).get(j).setObjectYPosition();
			}
		}
	}

	public List<List<IDestroyable>> getDestroyableObjects() {
		return destroyableObjectsList;
	}
	
}
