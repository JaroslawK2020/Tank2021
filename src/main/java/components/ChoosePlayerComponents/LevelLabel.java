package components.ChoosePlayerComponents;

import strings.EStrings;
import tankProject.panels.ChoosePlayerPanel;

public class LevelLabel extends MyLabel {

	public LevelLabel(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		chooseLvl(choosePlayerPanel, nickname);
		setBounds((int) choosePlayerPanel.calculateWidth(35), (int) choosePlayerPanel.calculateHeight(20),
				(int) choosePlayerPanel.calculateWidth(50), (int) choosePlayerPanel.calculateHeight(30));
	}
	
	public String getLvl(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		return String.valueOf(choosePlayerPanel.databaseManager.getLvl(nickname));
	}
	
	public void chooseLvl(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		if(nickname!="")setText(EStrings.LVL.text+getLvl(choosePlayerPanel, nickname));
	}
}