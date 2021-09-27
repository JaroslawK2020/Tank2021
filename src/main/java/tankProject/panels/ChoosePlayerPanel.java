package tankProject.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class ChoosePlayerPanel extends BasicPanel {

	public ChoosePlayerPanel(MyFrame mainFrame, MyFrame ChoosePlayerFrame) {
		setLayout(null);

		add(new BacktButton(mainFrame, ChoosePlayerFrame, this));
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth(), super.returnScreenHeight());

	}
	class BacktButton extends MyButton {

		public BacktButton(MyFrame mainFrame, MyFrame ChoosePlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
			super(EStrings.BACK.text);
			setBounds(choosePlayerPanel.returnScreenWidth() / 16,
					choosePlayerPanel.returnScreenHeight() - getHeight() * 2, getWidth(), getHeight());

			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ChoosePlayerFrame.dispose();
					mainFrame.setVisible(true);
				}
			});
		}
	}
}
