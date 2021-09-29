package components.StartPanelComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import tankProject.Frame.MyFrame;
import tankProject.panels.CreateNewPlayerPanel;
import tankProject.panels.StartPanel;

public class NewPlayerButton extends MyButton {

	public NewPlayerButton(String text, MyFrame mainFrame, StartPanel startPanel) {
		super(text);
		setBounds((int) startPanel.calculateWidth(10), (int) startPanel.calculateHeight(55), super.getWidth(),
				super.getHeight());

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MyFrame createNewPlayerFrame = new MyFrame();
				CreateNewPlayerPanel createNewPlayerPanel = new CreateNewPlayerPanel(mainFrame, createNewPlayerFrame);
				mainFrame.setVisible(false);

				createNewPlayerFrame.add(createNewPlayerPanel);
				createNewPlayerFrame.settupFrame();
			}
		});
	}
}
