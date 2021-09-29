package components.StartPanelComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import tankProject.Frame.MyFrame;
import tankProject.panels.ExitPanel;
import tankProject.panels.StartPanel;

public class QuitButton extends MyButton {

	public QuitButton(String text, MyFrame mainFrame, StartPanel startPanel) {
		super(text);
		setBounds((int) startPanel.calculateWidth(5), (int) startPanel.calculateHeight(90), getWidth(), getHeight());

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				launchExitPanel(mainFrame, startPanel);
			};
		});
	}

	private void launchExitPanel(MyFrame mainFrame, StartPanel startPanel) {
		MyFrame exitFrame = new MyFrame();
		ExitPanel exitPanel = new ExitPanel(exitFrame, mainFrame);
		exitFrame.add(exitPanel);
		exitFrame.settupFrame();
		mainFrame.setEnabled(false);
	}
}
