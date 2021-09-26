package tankProject.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import strings.EStrings;
import tankProject.Frame.MyFrame;

public class ChoosePlayerPanel extends BasicPanel {

	public ChoosePlayerPanel(MyFrame mainFrame, MyFrame ChoosePlayerFrame) {
		setLayout(null);

		add(new ExitButton(mainFrame, ChoosePlayerFrame, this));
	}

	class ExitButton extends MyButton {

		public ExitButton(MyFrame mainFrame, MyFrame ChoosePlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
			super(EStrings.BACK.text);
			setBounds(choosePlayerPanel.returnScreenWidth() - getWidth() - choosePlayerPanel.returnScreenWidth() / 16,
					choosePlayerPanel.returnScreenHeight() - getHeight() - choosePlayerPanel.returnScreenWidth() / 16,
					getWidth(), getHeight());

			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.dispose();
					ChoosePlayerFrame.dispose();
					mainFrame.setVisible(true);
				}
			});
		}
	}
}
