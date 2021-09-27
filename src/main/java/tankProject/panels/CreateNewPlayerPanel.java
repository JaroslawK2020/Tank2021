package tankProject.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import components.MyButton;
import images.ArrowL;
import images.TankImage_1;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class CreateNewPlayerPanel extends BasicPanel {

	public CreateNewPlayerPanel(MyFrame mainFrame, MyFrame createNewPlayerFrame) {

		JButton button_R = new JButton();
		button_R.setBounds(300, 400, 225, 225);
		button_R.setIcon(new ImageIcon("src//images//arrowL.png"));
		button_R.setPressedIcon(new ImageIcon("src//images//arrowL-pressed.png"));
		button_R.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(button_R);

		JButton button_L = new JButton();
		button_L.setBounds(1400, 400, 225, 225);
		button_L.setIcon(new ImageIcon("src//images//arrowR.png"));
		button_L.setPressedIcon(new ImageIcon("src//images//arrowR-pressed.png"));
		button_L.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(button_L);

		setLayout(null);

		add(new ExitButton(mainFrame, createNewPlayerFrame, this));
		add(new NickNameTextField(this));
		add(new Tittle(this));
		add(new CreateButton());

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(), returnScreenHeight());

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new TankImage_1().getImage(), (int) ((returnScreenWidth() / 2) - (returnScreenWidth() / 5) / 2),
				(int) ((returnScreenHeight() / 2) - (returnScreenHeight() / 5) / 2), (int) (returnScreenWidth() / 5),
				(int) (returnScreenHeight() / 5), null);

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

	class NickNameTextField extends JTextField {
		private Font fontFamily = new Font("Arial", Font.BOLD, 40);

		public NickNameTextField(CreateNewPlayerPanel createNewPlayerPanel) {
			setBounds((int) (createNewPlayerPanel.returnScreenWidth() / 10),
					(int) (createNewPlayerPanel.returnScreenHeight() / 5),
					(int) (createNewPlayerPanel.returnScreenWidth() / 3),
					(int) (createNewPlayerPanel.returnScreenHeight() / 15));
			setFont(fontFamily);
			setForeground(Color.WHITE);
			setForeground(Color.WHITE);
			setBackground(Color.BLACK);
			setCaretColor(Color.ORANGE);
		}
	}

	class Tittle extends JLabel {

		private Font fontFamily = new Font("Arial", Font.BOLD, 40);

		public Tittle(CreateNewPlayerPanel createNewPlayerPanel) {
			setText(EStrings.CREATE_NEW_PLAYER.text);
			setBounds((int) (createNewPlayerPanel.returnScreenWidth() / 2.5),
					(int) (createNewPlayerPanel.returnScreenHeight() / 22),
					(int) (createNewPlayerPanel.returnScreenWidth() / 2),
					(int) (createNewPlayerPanel.returnScreenHeight() / 8));
			setFont(fontFamily);
			setForeground(Color.WHITE);
		}
	}

	class CreateButton extends MyButton {

		public CreateButton() {
			super("Create");
			setBounds(1700, 900, 200, 80);

			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
	}
}
