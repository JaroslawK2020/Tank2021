package providers;

import java.util.ArrayList;
import java.util.List;

import images.CityMap;
import images.DesertMap;
import images.ForestMap;

public class MapsProvider {
	private List<IMaps> mapsList = new ArrayList<IMaps>();

	public MapsProvider() {

		mapsList.add(new ForestMap());
		mapsList.add(new CityMap());
		mapsList.add(new DesertMap());

	}

	public List<IMaps> getMapsList() {
		return mapsList;
	}

}
