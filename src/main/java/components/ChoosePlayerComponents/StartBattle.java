package components.ChoosePlayerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.MyButton;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.BattlePanel;
import tankProject.panels.ChoosePlayerPanel;

public class StartBattle extends MyButton {

	public StartBattle(MyFrame mainFrame, MyFrame choosePlayerFrame, ChoosePlayerPanel choosePlayerPanel,
			TanksListProvider tanksListProvider, String nickname) {
		super(EStrings.START_BATTLE.text);
		setEnabled(false);
		setBounds((int) choosePlayerPanel.calculateWidth(80), (int) choosePlayerPanel.calculateHeight(90), getWidth(),
				getHeight());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				choosePlayerFrame.setVisible(false);
				mainFrame.setVisible(false);
				navigateToBattlePanel(mainFrame, choosePlayerFrame, choosePlayerPanel, tanksListProvider, nickname);

			}
		});
	}

	public void navigateToBattlePanel(MyFrame mainFrame, MyFrame choosePlayerFrame, ChoosePlayerPanel choosePlayerPanel,
			TanksListProvider tanksListProvider, String nickname) {
		MyFrame battleFrame = new MyFrame();
<<<<<<< HEAD

		BattlePanel battlePanel = new BattlePanel(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel,
				tanksListProvider, nickname);
=======
		BattlePanel battlePanel = new BattlePanel(battleFrame,mainFrame,choosePlayerFrame,choosePlayerPanel);
>>>>>>> 1eb0e357bd67cee77c631b5277627296d395e2c6
		battleFrame.add(battlePanel);
		battleFrame.settupFrame();
	}

}