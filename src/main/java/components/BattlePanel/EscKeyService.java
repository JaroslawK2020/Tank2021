package components.BattlePanel;

import providers.TanksListProvider;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.EndBattlePanel;

public class EscKeyService {

	public EscKeyService(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider, String nickname, int selectedMap) {

		launchEndBattlePanel(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank, tanksListProvider,
				nickname, selectedMap);

	}

	private void launchEndBattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider, String nickname, int selectedMap) {
		MyFrame exitBattleFrame = new MyFrame();
		EndBattlePanel endBattlePanel = new EndBattlePanel(mainFrame, choosePlayerFrame, exitBattleFrame, battleFrame,
				choosePlayerPanel, myTank, tanksListProvider, nickname, selectedMap);
		
		exitBattleFrame.add(endBattlePanel);
		exitBattleFrame.settupFrame();
		battleFrame.setEnabled(false);
	}

}