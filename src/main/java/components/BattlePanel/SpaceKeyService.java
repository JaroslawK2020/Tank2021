package components.BattlePanel;

import java.awt.event.KeyEvent;

public class SpaceKeyService {
	private KeyEvent spaceKey;

	public SpaceKeyService(KeyEvent spaceKey) {
		this.spaceKey = spaceKey;
		System.out.println("space pressed");
	}
}
