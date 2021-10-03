package components.BattlePanel;

import providers.TanksListProvider;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.EndBattlePanel;

public class EscKeyService {

	public EscKeyService(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider, String nickname, int selectedMap, int initScore) {

		launchEndBattlePanel(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank, tanksListProvider,
				nickname, selectedMap, initScore);

	}

	private void launchEndBattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider, String nickname, int selectedMap, int initScore) {
		MyFrame exitBattleFrame = new MyFrame();
		EndBattlePanel endBattlePanel = new EndBattlePanel(mainFrame, choosePlayerFrame, exitBattleFrame, battleFrame,
				choosePlayerPanel, myTank, tanksListProvider, nickname, selectedMap, initScore);
		
		exitBattleFrame.add(endBattlePanel);
		exitBattleFrame.settupFrame();
		battleFrame.setEnabled(false);
	}

}