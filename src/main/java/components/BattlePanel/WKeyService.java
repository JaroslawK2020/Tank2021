package components.BattlePanel;

import java.awt.event.KeyEvent;

public class WKeyService {
	private MyTank myTank;
	private int tankYCurrentPosition;

	public WKeyService(MyTank myTank) {
		this.myTank = myTank;
		this.tankYCurrentPosition = myTank.getTankStartYposition();
		myTank.setTankStartYposition(tankYCurrentPosition -= 20);
		checkTankPosition();
	}
	
	private void checkTankPosition() {
		if(tankYCurrentPosition <= 0)
			myTank.setTankStartYposition(0);
	}

}
