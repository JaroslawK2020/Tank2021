package providers;

import java.util.ArrayList;
import java.util.List;

import components.BattlePanel.IShoot;
import components.BattlePanel.MyTank;
import components.BattlePanel.ShootDown;

public class DownShootProvider {
	public List<IShoot> shootsList = new ArrayList<IShoot>();

	public void newShoot(MyTank myTank) {
		shootsList.add(new ShootDown(myTank));
	}
	public void destroyShoot() {
		shootsList.remove(0);
	}
}
