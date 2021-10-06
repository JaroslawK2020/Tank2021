package components.EndBattleComponents;

import javax.swing.SwingConstants;

import components.ChoosePlayerComponents.MyLabel;
import strings.EStrings;
import tankProject.panels.ChoosePlayerPanel;

public class LabelsOnEndBattle extends MyLabel {
	public LabelsOnEndBattle(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		String playerLvl = Integer.toString(choosePlayerPanel.databaseManager.getLvl(nickname));
		String playerScores = Integer.toString(choosePlayerPanel.databaseManager.getUserScores(nickname));
		this.setText("<html>" + nickname + "<br/>" + EStrings.LVL + " : " + playerLvl
				+ "<br/>" + EStrings.SCORES+ " : " + playerScores + "</html>");
		this.setBounds((int) choosePlayerPanel.calculateWidth(5), (int) choosePlayerPanel.calculateHeight(7),
				(int) choosePlayerPanel.calculateWidth(50), (int) choosePlayerPanel.calculateHeight(30));
	}

}
