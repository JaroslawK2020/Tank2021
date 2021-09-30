package components.BattlePanel;

import java.awt.event.KeyEvent;

public class AKeyService {
	private MyTank myTank;
	private int tankXCurrentPosition;

	public AKeyService(MyTank myTank) {
		this.myTank = myTank;
		this.tankXCurrentPosition = myTank.getTankStartXposition();
		myTank.setTankStartXposition(tankXCurrentPosition -= 20);
		checkTankPosition();
	}
	
	private void checkTankPosition() {
		if(tankXCurrentPosition <= 0)
			myTank.setTankStartXposition(0);
	}
	
}
