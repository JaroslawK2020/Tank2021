package components.ChoosePlayerComponents;

import strings.EStrings;
import tankProject.panels.ChoosePlayerPanel;

public class NickNameLabel extends MyLabel {

	public NickNameLabel(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		chooseNickname(nickname);
		setBounds((int) choosePlayerPanel.calculateWidth(40), (int) choosePlayerPanel.calculateHeight(10),
				(int) choosePlayerPanel.calculateWidth(15), (int) choosePlayerPanel.calculateHeight(30));
	}
	
	public void chooseNickname(String nickname) {
		if(nickname!="")setText(EStrings.PLAYER.text+nickname);
	}
}