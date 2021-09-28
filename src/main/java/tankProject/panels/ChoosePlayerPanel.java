package tankProject.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import components.ChoosePlayerComponents.BackButton;
import components.ChoosePlayerComponents.StartBattle;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class ChoosePlayerPanel extends BasicPanel {

	public ChoosePlayerPanel(MyFrame mainFrame, MyFrame ChoosePlayerFrame) {
		BackButton backtButton = new BackButton(mainFrame, ChoosePlayerFrame, this);
		StartBattle startBattle = new StartBattle(mainFrame, ChoosePlayerFrame, this);
		add(backtButton);
		add(startBattle);
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth(), super.returnScreenHeight());

	}
}
