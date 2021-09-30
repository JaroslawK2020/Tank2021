package providers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import images.ITanks;
import images.TankImage_1;
import images.TankImage_2;
import images.TankImage_3;
import tankProject.panels.ChoosePlayerPanel;

public class TanksListProvider {
	private List<ITanks> tanksList = new ArrayList<ITanks>();

	public TanksListProvider(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		tanksList.add(new TankImage_1());
		tanksList.add(new TankImage_2());
		tanksList.add(new TankImage_3());

	}

	public List<ITanks> getTanksList() {
		return tanksList;
	}

	public BufferedImage getTankByUser(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		int index = choosePlayerPanel.databaseManager.getUserTank(nickname);
		return getTanksList().get(index).getImage();
	}
}