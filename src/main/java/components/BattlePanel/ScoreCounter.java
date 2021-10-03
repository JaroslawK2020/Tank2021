package components.BattlePanel;

import tankProject.panels.BattlePanel;

public class ScoreCounter extends BattlePanelTextEditor {

	public ScoreCounter(String pointCounter, BattlePanel battlePanel) {
		super(pointCounter);
		setBounds((int) battlePanel.calculateWidth(14), (int) battlePanel.calculateHeight(1), 
				(int) battlePanel.calculateWidth(15), (int) battlePanel.calculateHeight(5));
	}
}
