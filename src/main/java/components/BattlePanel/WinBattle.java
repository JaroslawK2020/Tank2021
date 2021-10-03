package components.BattlePanel;

import providers.TanksListProvider;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.EndBattlePanel;

public class WinBattle {

	public WinBattle(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider, String nickname, int selectedMap, int initScore) {

		int newlvl = choosePlayerPanel.databaseManager.getLvl(nickname)+1;
		launchEndBattlePanel(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank, tanksListProvider,
				nickname, selectedMap, initScore, newlvl);

	}

	private void launchEndBattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider, String nickname, int selectedMap, int initScore, int newlvl) {
		MyFrame exitBattleFrame = new MyFrame();
		EndBattlePanel endBattlePanel = new EndBattlePanel(mainFrame, choosePlayerFrame, exitBattleFrame, battleFrame,
				choosePlayerPanel, myTank, tanksListProvider, nickname, selectedMap, initScore, newlvl);
		
		exitBattleFrame.add(endBattlePanel);
		exitBattleFrame.settupFrame();
		battleFrame.setEnabled(false);
	}

}
