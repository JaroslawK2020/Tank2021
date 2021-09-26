package tankProject.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import strings.EStrings;
import tankProject.Frame.MyFrame;

public class ExitPanel extends BasicPanel {

	MyFrame exitFrame;
	MyFrame mainFrame;
	
	public ExitPanel(MyFrame exitFrame, MyFrame mainFrame) {
		this.exitFrame = exitFrame;
		this.mainFrame = mainFrame;
		
		setLayout(null);
		add(new Tittle(this));
		add(new YesButton(this));
		add(new NoButton(this));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth() / 2, super.returnScreenHeight() / 2);

	}

	class YesButton extends MyButton {

		public YesButton(ExitPanel exitPanel) {
			super(EStrings.YES.text);
			setBounds(exitPanel.returnScreenWidth() / 16,
					exitPanel.returnScreenHeight() / 2 - getHeight() - exitPanel.returnScreenWidth() / 16,
					getWidth(), getHeight());
			
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					exitFrame.dispose();
					mainFrame.dispose();
				}
			});
		}
	}
	
	class NoButton extends MyButton {

		public NoButton(ExitPanel exitPanel) {
			super(EStrings.NO.text);
			setBounds(exitPanel.returnScreenWidth() / 2 - getWidth() - exitPanel.returnScreenWidth() / 16,
					exitPanel.returnScreenHeight() / 2 - getHeight() - exitPanel.returnScreenWidth() / 16,
					getWidth(), getHeight());
			
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setEnabled(true);
					exitFrame.dispose();
				}
			});
		}
	}
	
	class Tittle extends JLabel {

		private Font fontFamily = new Font("Arial", Font.BOLD, 40);

		public Tittle(ExitPanel exitPanel) {
			setText(EStrings.CONFIRM_IF_QUITE.text);
			setBounds(exitPanel.returnScreenWidth() / 8, exitPanel.returnScreenWidth() / 9, exitPanel.returnScreenWidth() / 2,
					exitPanel.returnScreenHeight() / 8);
			setFont(fontFamily);
			setForeground(Color.WHITE);
		}
	}
}
