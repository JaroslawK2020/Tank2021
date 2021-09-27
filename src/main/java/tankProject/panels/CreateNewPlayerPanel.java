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
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import components.MyButton;
import images.ArrowL;
import images.ITanks;
import images.TankImage_1;
import images.TankImage_2;
import images.TankImage_3;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;

class CreateNewPlayerPanel extends BasicPanel {

	TanksListProvider tanksListProvider = new TanksListProvider();
	int selectedTankIndex = 0;

	public CreateNewPlayerPanel(MyFrame mainFrame, MyFrame createNewPlayerFrame) {

		NickNameTextField nickNameTextField = new NickNameTextField(this);
		NickNameLabel nickNameLabel = new NickNameLabel(this);
		setLayout(null);
		add(new Tittle(this));
		add(nickNameLabel);
		add(nickNameTextField);
		add(new CreateButton(createNewPlayerFrame, mainFrame, nickNameTextField, nickNameLabel));
		add(new BackButton(mainFrame, createNewPlayerFrame, this));
		add(new ChooseTankLeftButton(this, tanksListProvider));
		add(new ChooseTankRightButton(this));

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(), returnScreenHeight());

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage mainImage = tanksListProvider.getTanksList().get(selectedTankIndex).getImage();

		g.drawImage(mainImage, (int) ((returnScreenWidth() / 2) - (returnScreenWidth() / 3) / 2),
				(int) ((returnScreenHeight() / 2) - (returnScreenHeight() / 3) / 2), (int) (returnScreenWidth() / 3),
				(int) (returnScreenHeight() / 3), null);

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

	class NickNameLabel extends Tittle {

		public NickNameLabel(CreateNewPlayerPanel createNewPlayerPanel) {
			super(createNewPlayerPanel);
			setText("Provide player nickname:");
			setBounds((int) (createNewPlayerPanel.returnScreenWidth() / 10),
					(int) (createNewPlayerPanel.returnScreenHeight() / 7),
					(int) (createNewPlayerPanel.returnScreenWidth() / 2),
					(int) (createNewPlayerPanel.returnScreenHeight() / 15));
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
			setBackground(Color.DARK_GRAY);
			setCaretColor(Color.ORANGE);
		}
	}

	class ChooseTankLeftButton extends JButton {

		public ChooseTankLeftButton(CreateNewPlayerPanel createNewPlayerPanel, TanksListProvider tanksListProvider) {
			setBounds((int) ((returnScreenWidth() / 10) * 1), (int) (returnScreenHeight() / 2),
					ChooseTankButtonSize.width, ChooseTankButtonSize.height);
			setIcon(new ArrowL());
			setPressedIcon(new ArrowL_Pressed());
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (createNewPlayerPanel.selectedTankIndex > 0) {
						createNewPlayerPanel.selectedTankIndex--;
						createNewPlayerPanel.repaint();
					} else {
						createNewPlayerPanel.selectedTankIndex = createNewPlayerPanel.tanksListProvider.getTanksList()
								.size() - 1;
						createNewPlayerPanel.repaint();
					}
				}
			});
		}
	}

	static class ChooseTankButtonSize {
		static int width = 225;
		static int height = 225;
	}

	class ChooseTankRightButton extends JButton {

		public ChooseTankRightButton(CreateNewPlayerPanel createNewPlayerPanel) {
			setBounds((int) ((returnScreenWidth() / 10) * 8), (int) (returnScreenHeight() / 2),
					ChooseTankButtonSize.width, ChooseTankButtonSize.height);
			setIcon(new ArrowR());
			setPressedIcon(new ArrowR_Pressed());
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (createNewPlayerPanel.selectedTankIndex < createNewPlayerPanel.tanksListProvider.getTanksList()
							.size() - 1) {
						createNewPlayerPanel.selectedTankIndex++;
						createNewPlayerPanel.repaint();

					} else {
						createNewPlayerPanel.selectedTankIndex = 0;
						createNewPlayerPanel.repaint();
					}
				}
			});
		}
	}

	class ArrowL extends ImageIcon {

		public ArrowL() {
			super("src//images//arrowL.png");
		}
	}

	class ArrowL_Pressed extends ImageIcon {

		public ArrowL_Pressed() {
			super("src//images//arrowL-pressed.png");
		}
	}

	class ArrowR extends ImageIcon {

		public ArrowR() {
			super("src//images//arrowR.png");
		}
	}

	class ArrowR_Pressed extends ImageIcon {

		public ArrowR_Pressed() {
			super("src//images//arrowR-pressed.png");
		}
	}

	class BackButton extends MyButton {

		public BackButton(MyFrame mainFrame, MyFrame createNewPlayerFrame, CreateNewPlayerPanel createNewPlayerPanel) {
			super(EStrings.BACK.text);
			setBounds((int) (returnScreenWidth() / 30.7), (int) (returnScreenHeight() / 1.2), getWidth(), getHeight());

			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createNewPlayerFrame.dispose();
					mainFrame.setVisible(true);
				}
			});
		}
	}

	class CreateButton extends MyButton {

		public CreateButton(MyFrame createNewPlayerFrame, MyFrame mainFrame, NickNameTextField nickNameTextField,
				NickNameLabel nickNameLabel) {
			super("Create");
			setEnabled(false);
			setBounds((int) (returnScreenWidth() / 1.15), (int) (returnScreenHeight() / 1.2), getWidth(), getHeight());

			nickNameTextField.getDocument().addDocumentListener(new DocumentListener() {
				public void changedUpdate(DocumentEvent e) {
					change(nickNameTextField);
				}

				public void removeUpdate(DocumentEvent e) {
					change(nickNameTextField);
				}

				public void insertUpdate(DocumentEvent e) {
					change(nickNameTextField);
				}
			});

			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (isEnabled()) {
						// TO DO:
						// implement nickname validation - is nickname in use?
						// save new player

						// databaseManager.addNewUser(nickNameTextField.getText(), selectedTankIndex);

						if (databaseManager.verifyIfNicknameExist(nickNameTextField.getText()) == 1) {

							setWarning(nickNameLabel);
							setEnabled(false);

						} else {
							databaseManager.addNewUser(nickNameTextField.getText(), selectedTankIndex);
							setEnabled(true);
							navigateToChoosePlayerFrame(createNewPlayerFrame, mainFrame);
							createNewPlayerFrame.dispose();
						}
					}
				}
			});
		}

		private void setWarning(NickNameLabel nickNameLabel) {
			nickNameLabel.setText(
					"UPS! The \"" + nickNameLabel.getText() + "\" is used by other user. Choose something else");
			nickNameLabel.setForeground(Color.RED);
		}

		private void labelRevert(NickNameLabel nickNameLabel) {
			nickNameLabel.setText("Provide player nickname:");
			nickNameLabel.setForeground(Color.WHITE);
		}

		private void change(NickNameTextField nickNameTextField) {
			if (nickNameTextField.getText().equals("")) {
				setEnabled(false);
				nickNameTextField.setBorder(new LineBorder(Color.RED));
			} else {
				setEnabled(true);
				nickNameTextField.setBorder(new LineBorder(Color.black));
			}
		}

		private void navigateToChoosePlayerFrame(MyFrame createNewPlayerFrame, MyFrame mainFrame) {
			MyFrame choosePlayerFrame = new MyFrame();
			ChoosePlayerPanel choosePlayerPanel = new ChoosePlayerPanel(mainFrame, choosePlayerFrame);

			choosePlayerFrame.add(choosePlayerPanel);
			choosePlayerFrame.settupFrame();
		}

	}
}
