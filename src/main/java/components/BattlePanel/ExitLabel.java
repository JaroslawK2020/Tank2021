package components.BattlePanel;

import java.awt.Font;

import strings.EStrings;
import tankProject.panels.BattlePanel;

public class ExitLabel extends BattlePanelTextEditor{

	public ExitLabel(BattlePanel battlePanel) {
		super(EStrings.ESC_BATTLE_PANEL.text);
		setFont(new Font("Arial", Font.BOLD, 30));
		setBounds((int) battlePanel.calculateWidth(82), (int) battlePanel.calculateHeight(1), 
				(int) battlePanel.calculateWidth(20), (int) battlePanel.calculateHeight(5));
	}

}
