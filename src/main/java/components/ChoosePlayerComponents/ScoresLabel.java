package components.ChoosePlayerComponents;

import strings.EStrings;
import tankProject.panels.ChoosePlayerPanel;

public class ScoresLabel extends MyLabel {

	public ScoresLabel(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		setText(EStrings.SCORES.text+getScores(choosePlayerPanel, nickname));
		setBounds((int) choosePlayerPanel.calculateWidth(40), (int) choosePlayerPanel.calculateHeight(15),
				(int) choosePlayerPanel.calculateWidth(15), (int) choosePlayerPanel.calculateHeight(30));
	}
	public String getScores(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		return String.valueOf(choosePlayerPanel.databaseManager.getUserScores(nickname));
	}
}