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
		setBounds((int) (createNewPlayerPanel.calculateWidth(42)),
				(int) (createNewPlayerPanel.calculateHeight(3)),
				(int) (createNewPlayerPanel.calculateWidth(40)),
				(int) (createNewPlayerPanel.calculateHeight(7)));
		setFont(fontFamily);
		setForeground(Color.WHITE);
	}
}