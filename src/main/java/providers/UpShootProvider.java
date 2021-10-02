package providers;

import java.util.ArrayList;
import java.util.List;

import components.BattlePanel.IShoot;
import components.BattlePanel.MyTank;
import components.BattlePanel.ShootUp;

public class UpShootProvider {
	public List<IShoot> shootsList = new ArrayList<IShoot>();

	public void newShoot(MyTank myTank) {
		shootsList.add(new ShootUp(myTank));
	}
	public void destroyShoot() {
		shootsList.remove(0);
	}
	public List<IShoot> getShootsList() {
		return shootsList;
	}
}
