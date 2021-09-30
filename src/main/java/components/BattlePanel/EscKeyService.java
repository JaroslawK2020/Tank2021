package components.BattlePanel;

import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.EndBattlePanel;

public class EscKeyService {
	private MyFrame battleFrame;
	private MyFrame mainFrame;
	private MyFrame choosePlayerFrame;
	private ChoosePlayerPanel choosePlayerPanel;

	public EscKeyService(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
		this.battleFrame = battleFrame;
		this.mainFrame = mainFrame;
		this.choosePlayerFrame = choosePlayerFrame;
		this.choosePlayerPanel = choosePlayerPanel;
		launchEndBattlePanel();
		
	}
	
	private void launchEndBattlePanel() {
		MyFrame exitBattleFrame = new MyFrame();
		EndBattlePanel endBattlePanel = new EndBattlePanel(mainFrame,choosePlayerFrame,exitBattleFrame,battleFrame,choosePlayerPanel);
		exitBattleFrame.add(endBattlePanel);
		exitBattleFrame.settupFrame();
		battleFrame.setEnabled(false);
	}
	

}
