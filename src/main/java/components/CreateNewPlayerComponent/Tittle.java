package components.CreateNewPlayerComponent;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import strings.EStrings;
import tankProject.panels.CreateNewPlayerPanel;

public class Tittle extends JLabel {

	private Font fontFamily = new Font("Arial", Font.BOLD, 40);

	public Tittle(CreateNewPlayerPanel createNewPlayerPanel) {
		setText(EStrings.CREATE_NEW_PLAYER.text);
		setBounds((int) (createNewPlayerPanel.returnScreenWidth() / 2.5),
				(int) (createNewPlayerPanel.returnScreenHeight() / 22),
				(int) (createNewPlayerPanel.returnScreenWidth() / 2),
				(int) (createNewPlayerPanel.returnScreenHeight() / 8));
		setFont(fontFamily);
		setForeground(Color.WHITE);
	}
}