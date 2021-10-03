package providers;

import java.util.ArrayList;
import java.util.List;
import images.IDestroyable;
import images.ReactorImg;

public class ReactorsProvider {
	private int fromRange = 1;
	private int toRange = 2;

	private List<IDestroyable> reactorsList = new ArrayList<IDestroyable>();

	public ReactorsProvider(int lvl) {

		for (int i = 0; i < (int) ((Math.random() * ((toRange + lvl) - (fromRange + lvl)) + (fromRange + lvl))); i++)
			reactorsList.add(new ReactorImg());	

	}

	public List<IDestroyable> getReactorsList() {
		return reactorsList;
	}
		
}
