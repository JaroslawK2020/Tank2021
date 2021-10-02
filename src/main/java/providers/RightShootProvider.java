package providers;

import java.util.ArrayList;
import java.util.List;

import components.BattlePanel.IShoot;
import components.BattlePanel.MyTank;
import components.BattlePanel.ShootRight;

public class RightShootProvider {
	public List<IShoot> shootsList = new ArrayList<IShoot>();

	public void newShoot(MyTank myTank) {
		shootsList.add(new ShootRight(myTank));
	}
	public void destroyShoot() {
		shootsList.remove(0);
	}
	public List<IShoot> getShootsList() {
		return shootsList;
	}
}
