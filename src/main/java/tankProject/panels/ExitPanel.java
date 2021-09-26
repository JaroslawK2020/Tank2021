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

	private Font fontFamily = new Font("Arial", Font.BOLD, 40);
	JLabel title = new JLabel(EStrings.CONFIRM_IF_QUITE.text);
	MyButton yesButton = new MyButton(EStrings.YES.text);
	MyButton noButton = new MyButton(EStrings.NO.text);

	public ExitPanel(MyFrame myFrame, MyFrame mainFrame, MyButton button) {
		setLayout(null);
		title.setBounds(super.returnScreenWidth() / 8, super.returnScreenWidth() / 9, super.returnScreenWidth() / 2, super.returnScreenHeight() / 8);
		add(title);

		title.setFont(fontFamily);
		title.setForeground(Color.WHITE);
		
		
		yesButton.setBounds(super.returnScreenWidth()/16, super.returnScreenHeight() / 2 - yesButton.getHeight() - super.returnScreenWidth()/16, yesButton.getWidth(), yesButton.getHeight());
		noButton.setBounds( super.returnScreenWidth() / 2 - noButton.getWidth() - super.returnScreenWidth()/16, super.returnScreenHeight() / 2 - noButton.getHeight() - super.returnScreenWidth()/16, noButton.getWidth(), noButton.getHeight());

		noButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				myFrame.dispose();
				button.setEnabled(true);
			}
		});

		yesButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myFrame.dispose();
				mainFrame.dispose();
			}
		});

		add(yesButton);
		add(noButton);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth() / 2, super.returnScreenHeight() / 2);

	}

}
