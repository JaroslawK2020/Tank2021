package providers;

import java.util.ArrayList;
import java.util.List;
import images.IDestroyable;
import images.ReactorImg;

public class ReactorsProvider {

	private List<IDestroyable> reactorsList = new ArrayList<IDestroyable>();

	public ReactorsProvider() {
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());

	}

	public List<IDestroyable> getReactorsList() {
		return reactorsList;
	}

}
