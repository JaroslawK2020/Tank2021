package components.ChoosePlayerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.CreateNewPlayerPanel;

public class BackButton extends MyButton {

	public BackButton(MyFrame mainFrame, MyFrame createNewPlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
		super(EStrings.BACK.text);
		setBounds((int) choosePlayerPanel.calculateWidth(10), (int) choosePlayerPanel.calculateHeight(90), getWidth(), getHeight());

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewPlayerFrame.dispose();
				mainFrame.setVisible(true);
			}
		});
	}
}