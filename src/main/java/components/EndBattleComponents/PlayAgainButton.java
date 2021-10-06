package components.EndBattleComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.ChoosePlayerComponents.StartBattle;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.MyButton;

public class PlayAgainButton extends MyButton {

	public PlayAgainButton(MyFrame mainFrame, MyFrame exitBattleFrame, MyFrame choosePlayerFrame,
			MyFrame battleFrame, ChoosePlayerPanel choosePlayerPanel, TanksListProvider tanksListProvider,
			String nickname, int selectedMap) {
		super(EStrings.PLAY_AGAIN.text);
		setBounds((int) choosePlayerPanel.calculateWidth(35), (int) choosePlayerPanel.calculateHeight(38), getWidth(), getHeight());

		StartBattle startBattle = new StartBattle(mainFrame, choosePlayerFrame, choosePlayerPanel,
				tanksListProvider);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				startBattle.navigateToBattlePanel(mainFrame, choosePlayerPanel, tanksListProvider, nickname,
						selectedMap, choosePlayerPanel.lvl);

				battleFrame.dispose();
				exitBattleFrame.dispose();

			}
		});
	}
}
