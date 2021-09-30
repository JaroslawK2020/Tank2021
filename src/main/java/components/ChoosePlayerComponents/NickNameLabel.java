package components.ChoosePlayerComponents;

import strings.EStrings;
import tankProject.panels.ChoosePlayerPanel;

public class NickNameLabel extends MyLabel {

	public NickNameLabel(ChoosePlayerPanel choosePlayerPanel, String nickname) {
		chooseNickname(nickname);
		setBounds((int) choosePlayerPanel.calculateWidth(35), (int) choosePlayerPanel.calculateHeight(10),
				(int) choosePlayerPanel.calculateWidth(50), (int) choosePlayerPanel.calculateHeight(30));
	}
	
	public void chooseNickname(String nickname) {
		if(nickname!="")setText(EStrings.PLAYER.text+nickname);
	}
}