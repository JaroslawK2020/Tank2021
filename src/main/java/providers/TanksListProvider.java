package providers;

import java.util.ArrayList;
import java.util.List;

import images.ITanks;
import images.TankImage_1;
import images.TankImage_2;
import images.TankImage_3;

public class TanksListProvider {

		private List<ITanks> tanksList = new ArrayList<ITanks>();

		public TanksListProvider() {
			tanksList.add(new TankImage_1());
			tanksList.add(new TankImage_2());
			tanksList.add(new TankImage_3());

		}

		public List<ITanks> getTanksList() {
			return tanksList;
		}
	}