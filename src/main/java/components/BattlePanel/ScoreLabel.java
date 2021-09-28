package components.BattlePanel;

import strings.EStrings;
import tankProject.panels.BattlePanel;

public class ScoreLabel extends BattlePanelTextEditor {

	public ScoreLabel(BattlePanel battlePanel) {
		super(EStrings.SCORES.text);
		setBounds((int) battlePanel.calculateWidth(1), (int) battlePanel.calculateHeight(1), 
				(int) battlePanel.calculateWidth(15), (int) battlePanel.calculateHeight(5));
	}

}
