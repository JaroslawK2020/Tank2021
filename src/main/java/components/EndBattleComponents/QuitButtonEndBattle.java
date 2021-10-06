package components.EndBattleComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.MyButton;

public class QuitButtonEndBattle extends MyButton {

	public QuitButtonEndBattle(MyFrame mainFrame, MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame,
			String nickname, int initScore, ChoosePlayerPanel choosePlayerPanel, int LVL) {
		super(EStrings.QUIT.text);
		setBounds((int) choosePlayerPanel.calculateWidth(5), (int) choosePlayerPanel.calculateHeight(38), getWidth(), getHeight());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int updateValue = initScore + choosePlayerPanel.databaseManager.getUserScores(nickname);
				int newLvl = LVL;

				choosePlayerPanel.databaseManager.setNewScores(nickname, updateValue);
				choosePlayerPanel.databaseManager.setNewLvl(nickname, newLvl);

				MyFrame choosePlayerFrame = new MyFrame();
				ChoosePlayerPanel choosePlayerPanel = new ChoosePlayerPanel(mainFrame, choosePlayerFrame);

				choosePlayerFrame.add(choosePlayerPanel);
				choosePlayerFrame.settupFrame();

				exitBattleFrame.dispose();
				battleFrame.dispose();
			}
		});
	}
}
