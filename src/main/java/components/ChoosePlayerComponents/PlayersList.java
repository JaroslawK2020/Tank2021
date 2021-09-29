package components.ChoosePlayerComponents;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JList;

import tankProject.panels.ChoosePlayerPanel;

public class PlayersList extends JList{

//DefaultListModel model = new DefaultListModel();

	public PlayersList(ChoosePlayerPanel choosePlayerPanel) { //,DefaultListModel model) {
		setBounds((int) choosePlayerPanel.calculateWidth(3), (int) choosePlayerPanel.calculateHeight(5),
				(int) choosePlayerPanel.calculateWidth(30), (int) choosePlayerPanel.calculateHeight(80));
		setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
	//	model.addElement("Maciej");
	}
}
