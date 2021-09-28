package components.CreateNewPlayerComponent;

import tankProject.panels.CreateNewPlayerPanel;

public class NickNameLabel extends Tittle {

	public NickNameLabel(CreateNewPlayerPanel createNewPlayerPanel) {
		super(createNewPlayerPanel);
		setText("Provide player nickname:");
		setBounds((int) createNewPlayerPanel.calculateWidth(10), (int) createNewPlayerPanel.calculateHeight(14),
				(int) createNewPlayerPanel.calculateWidth(90), (int) createNewPlayerPanel.calculateHeight(7));
	}
}