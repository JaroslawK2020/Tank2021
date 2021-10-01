package components.BattlePanel;

import providers.TanksListProvider;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.EndBattlePanel;

public class EscKeyService {
	private MyFrame battleFrame;
	private MyFrame mainFrame;
	private MyFrame choosePlayerFrame;
	private ChoosePlayerPanel choosePlayerPanel;
	private MyTank myTank;
	private String nickname;

	public EscKeyService(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider) {
		this.battleFrame = battleFrame;
		this.mainFrame = mainFrame;
		this.choosePlayerFrame = choosePlayerFrame;
		this.choosePlayerPanel = choosePlayerPanel;
		this.myTank = myTank;
		this.nickname = nickname;
		launchEndBattlePanel();

	}

	private void launchEndBattlePanel() {
		MyFrame exitBattleFrame = new MyFrame();
		EndBattlePanel endBattlePanel = new EndBattlePanel(mainFrame, choosePlayerFrame, exitBattleFrame, battleFrame,
				choosePlayerPanel, myTank,nickname);

		exitBattleFrame.add(endBattlePanel);
		exitBattleFrame.settupFrame();
		battleFrame.setEnabled(false);
	}

}