package components.BattlePanel;

import java.awt.event.KeyEvent;

import tankProject.Frame.MyFrame;
import tankProject.panels.EndBattlePanel;

public class EscKeyService {
	private KeyEvent escKey;
	private MyFrame endBattleFrame;
	private MyFrame mainFrame;

	public EscKeyService(KeyEvent escKey, MyFrame endBattleFrame, MyFrame mainFrame) {
		this.escKey = escKey;
		this.endBattleFrame = endBattleFrame;
		this.mainFrame = mainFrame;
		launchEndBattlePanel();
		
	}
	
	private void launchEndBattlePanel() {
		MyFrame exitBattleFrame = new MyFrame();
		EndBattlePanel endBattlePanel = new EndBattlePanel(endBattleFrame,mainFrame);
		exitBattleFrame.add(endBattlePanel);
		exitBattleFrame.settupFrame();
//		endBattleFrame.setEnabled(false);
	}
	

}
