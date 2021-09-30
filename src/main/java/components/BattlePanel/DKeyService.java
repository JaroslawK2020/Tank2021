package components.BattlePanel;

import java.awt.event.KeyEvent;

public class DKeyService {
	private MyTank myTank;
	private int tankXCurrentPosition;
	private int screenWidth;

	public DKeyService(MyTank myTank, int screenWidth) {
		this.myTank = myTank;
		this.tankXCurrentPosition = myTank.getTankStartXposition();
		this.screenWidth = screenWidth;
		myTank.setTankStartXposition(tankXCurrentPosition += 20);
		checkTankPosition();
	}
	
	private void checkTankPosition() {
		if(tankXCurrentPosition > (screenWidth - myTank.getWidth()))
			myTank.setTankStartXposition(screenWidth - myTank.getWidth());
	}
}
