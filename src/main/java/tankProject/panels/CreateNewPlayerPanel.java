package tankProject.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class CreateNewPlayerPanel extends BasicPanel {

	public CreateNewPlayerPanel(MyFrame mainFrame, MyFrame createNewPlayerFrame) {
		setLayout(null);

		add(new ExitButton(mainFrame, createNewPlayerFrame, this));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth(), super.returnScreenHeight());

	}

	class ExitButton extends MyButton {

		public ExitButton(MyFrame mainFrame, MyFrame createNewPlayerFrame, CreateNewPlayerPanel createNewPlayerPanel) {
			super(EStrings.BACK.text);
			setBounds(createNewPlayerPanel.returnScreenWidth() / 16,
					createNewPlayerPanel.returnScreenHeight() - getHeight() * 2, getWidth(), getHeight());

			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.dispose();
					createNewPlayerFrame.dispose();
					mainFrame.setVisible(true);
				}
			});
		}
	}
}
