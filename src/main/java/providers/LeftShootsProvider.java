package providers;

import java.util.ArrayList;
import java.util.List;

import components.BattlePanel.IShoot;
import components.BattlePanel.MyTank;
import components.BattlePanel.ShootLeft;
import components.BattlePanel.ShootRight;

public class LeftShootsProvider {
	public List<IShoot> shootsList = new ArrayList<IShoot>();

	public void newShoot(MyTank myTank) {
		shootsList.add(new ShootLeft(myTank));
	}
	public void destroyShoot() {
		shootsList.remove(0);
	}
}
