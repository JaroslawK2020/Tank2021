package components.CreateNewPlayerComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.ChoosePlayerPanel;
import tankProject.panels.CreateNewPlayerPanel;

public class CreateButton extends MyButton {

	public CreateButton(MyFrame createNewPlayerFrame, MyFrame mainFrame, NickNameTextField nickNameTextField,
			NickNameLabel nickNameLabel, CreateNewPlayerPanel createNewPlayerPanel) {
		super(EStrings.CREATE_BUTTON.text);
		setEnabled(false);
		setBounds((int) createNewPlayerPanel.calculateWidth(83), (int) createNewPlayerPanel.calculateHeight(90), getWidth(), getHeight());

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
					if (createNewPlayerPanel.databaseManager.verifyIfNicknameExist(nickNameTextField.getText()) == 1) {
						setWarning(nickNameTextField,nickNameLabel);
						setEnabled(false);

					} else {
						createNewPlayerPanel.databaseManager.addNewUser(nickNameTextField.getText(), createNewPlayerPanel.selectedTankIndex);
						setEnabled(true);
						navigateToChoosePlayerFrame(createNewPlayerFrame, mainFrame);
						createNewPlayerFrame.dispose();
					}
				}
			}
		});
	}

	private void setWarning(NickNameTextField nickNameTextField, NickNameLabel nickNameLabel) {
		nickNameLabel.setText(EStrings.NICKNAME_INUSE_WARNING.text);
		nickNameLabel.setForeground(Color.RED);
		nickNameLabel.setFont(new Font("Arial", Font.BOLD, 30));
	}
	
	private void labelRevert(NickNameLabel nickNameLabel) {
		nickNameLabel.setText(EStrings.PROVIDE_NICKNAME.text);
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
