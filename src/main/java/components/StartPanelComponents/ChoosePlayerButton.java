package components.StartPanelComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.StartPanel;

public class ChoosePlayerButton extends MyButton {

	public ChoosePlayerButton(String text, MyFrame mainFrame, StartPanel startPanel) {
		super(text);
		setBounds((int) startPanel.calculateWidth(75), (int) startPanel.calculateHeight(55), super.getWidth(),
				super.getHeight());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame choosePlayerFrame = new MyFrame();
				ChoosePlayerPanel choosePlayerPanel = new ChoosePlayerPanel(mainFrame, choosePlayerFrame);

				choosePlayerFrame.add(choosePlayerPanel);
				choosePlayerFrame.settupFrame();
				mainFrame.setVisible(false);

			}
		});
	}
}
