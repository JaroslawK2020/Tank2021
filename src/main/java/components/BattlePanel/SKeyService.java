package components.BattlePanel;

import java.awt.event.KeyEvent;

public class SKeyService {
	private MyTank myTank;
	private int tankYCurrentPosition;
	private int screenHeight;

	public SKeyService(MyTank myTank, int screenHeight) {
		this.myTank = myTank;
		this.tankYCurrentPosition = myTank.getTankStartYposition();
		this.screenHeight = screenHeight;
		myTank.setTankStartYposition(tankYCurrentPosition += 20);
		checkTankPosition();
	}
	
	private void checkTankPosition() {
		if(tankYCurrentPosition > (screenHeight - myTank.getHeight()))
			myTank.setTankStartYposition(screenHeight - myTank.getHeight());
	}
	
	
}
