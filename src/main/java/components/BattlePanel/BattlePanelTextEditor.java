package components.BattlePanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import strings.EStrings;

public class BattlePanelTextEditor extends JLabel {
	private Font fontFamily = new Font("Arial", Font.BOLD, 40);
	
	public BattlePanelTextEditor(String text) {
		setText(text);
		setFont(fontFamily);
		setForeground(Color.WHITE);
	}

}
