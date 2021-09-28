package components.CreateNewPlayerComponent;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import tankProject.panels.CreateNewPlayerPanel;


public class NickNameTextField extends JTextField {
	private Font fontFamily = new Font("Arial", Font.BOLD, 40);

	public NickNameTextField(CreateNewPlayerPanel createNewPlayerPanel) {
		setBounds((int) createNewPlayerPanel.calculateWidth(10), (int) createNewPlayerPanel.calculateHeight(23),
				(int) createNewPlayerPanel.calculateWidth(30), (int) createNewPlayerPanel.calculateHeight(7));
		setFont(fontFamily);
		setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		setCaretColor(Color.ORANGE);
	}
}
