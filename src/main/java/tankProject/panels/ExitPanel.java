package tankProject.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class ExitPanel extends BasicPanel {

	MyFrame exitFrame;
	MyFrame mainFrame;

	public ExitPanel(MyFrame exitFrame, MyFrame mainFrame) {
		this.exitFrame = exitFrame;
		this.mainFrame = mainFrame;
		width /= 2;
		height /= 2;

		setLayout(null);
		add(new Tittle(this));
		add(new YesButton(this));
		add(new NoButton(this));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);

	}

	class YesButton extends MyButton {

		public YesButton(ExitPanel exitPanel) {
			super(EStrings.YES.text);
			setBounds((int) calculateWidth(7), (int) calculateHeight(35), getWidth(), getHeight());
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
			setBounds((int) calculateWidth(35), (int) calculateHeight(35), getWidth(), getHeight());

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
			setBounds((int) calculateWidth(12), (int) calculateHeight(18), (int) calculateWidth(50), (int) calculateHeight(5));
			setFont(fontFamily);
			setForeground(Color.WHITE);
		}
	}
}
