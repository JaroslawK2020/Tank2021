package components.ChoosePlayerComponents;

import javax.swing.JButton;

import tankProject.panels.ChoosePlayerPanel;

public class ForestMapImage extends JButton {

	public ForestMapImage(ChoosePlayerPanel choosePlayerPanel) {
		setBounds((int) choosePlayerPanel.calculateWidth(34), (int) choosePlayerPanel.calculateHeight(60), (int) choosePlayerPanel.calculateWidth(20), (int) choosePlayerPanel.calculateHeight(20) );
		setForeground(getBackground());
	}
}
