package providers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import images.BlueTank;
import images.GreenTank;
import images.ITanks;
import images.RedTank;
import tankProject.panels.BasicPanel;

public class TanksListProvider {
	private List<ITanks> tanksList = new ArrayList<ITanks>();

	public TanksListProvider(BasicPanel basicPanel, String nickname) {
		tanksList.add(new BlueTank());
		tanksList.add(new GreenTank());
		tanksList.add(new RedTank());

	}

	public List<ITanks> getTanksList() {
		return tanksList;
	}

	public BufferedImage getTankByUser(BasicPanel basicPanel, String nickname) {
		int index = basicPanel.databaseManager.getUserTank(nickname);
		return getTanksList().get(index).getImage();
	}
	
	public BufferedImage getTankByUserForMove(BasicPanel basicPanel, String nickname, int key) {
		int index = basicPanel.databaseManager.getUserTank(nickname);
		return getTanksList().get(index).getImage(key);
	}
}