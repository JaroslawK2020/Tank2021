package components.CreateNewPlayerComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.CreateNewPlayerPanel;

public class BackButton extends MyButton {

	public BackButton(MyFrame mainFrame, MyFrame createNewPlayerFrame, CreateNewPlayerPanel createNewPlayerPanel) {
		super(EStrings.BACK.text);
		setBounds((int) createNewPlayerPanel.calculateWidth(10), (int) createNewPlayerPanel.calculateHeight(90), getWidth(), getHeight());

		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewPlayerFrame.dispose();
				mainFrame.setVisible(true);
			}
		});
	}
}