package components.CreateNewPlayerComponent;

import strings.EStrings;
import tankProject.panels.CreateNewPlayerPanel;

public class NickNameLabel extends Tittle {

	public NickNameLabel(CreateNewPlayerPanel createNewPlayerPanel) {
		super(createNewPlayerPanel);
		setText(EStrings.PROVIDE_NICKNAME.text);
		setBounds((int) createNewPlayerPanel.calculateWidth(10), (int) createNewPlayerPanel.calculateHeight(14),
				(int) createNewPlayerPanel.calculateWidth(90), (int) createNewPlayerPanel.calculateHeight(7));
	}
}