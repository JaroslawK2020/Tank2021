package components.ChoosePlayerComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import strings.EStrings;
import tankProject.panels.CreateNewPlayerPanel;

public class MyLabel extends JLabel {

	private Font fontFamily = new Font("Arial", Font.BOLD, 40);

	public MyLabel() {
		setFont(fontFamily);
		setForeground(Color.WHITE);
	}
}