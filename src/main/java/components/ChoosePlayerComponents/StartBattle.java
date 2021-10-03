package components.ChoosePlayerComponents;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import components.MyButton;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.BattlePanel;
import tankProject.panels.ChoosePlayerPanel;

public class StartBattle extends MyButton {

	String nickname = "";
    private Timer timer;


	public StartBattle(MyFrame mainFrame, MyFrame choosePlayerFrame, ChoosePlayerPanel choosePlayerPanel,
			TanksListProvider tanksListProvider, int lvl) {
		super(EStrings.START_BATTLE.text);

		setEnabled(false);
		setBounds((int) choosePlayerPanel.calculateWidth(80), (int) choosePlayerPanel.calculateHeight(90), getWidth(),
				getHeight());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				navigateToBattlePanel(mainFrame, choosePlayerPanel, tanksListProvider, nickname,
						choosePlayerPanel.getSelectedMap(), lvl);
				choosePlayerFrame.dispose();
			}
		});
	}

	public void navigateToBattlePanel(MyFrame mainFrame, ChoosePlayerPanel choosePlayerPanel,
			TanksListProvider tanksListProvider, String nickname, int selectedMap, int lvl) {
		MyFrame battleFrame = new MyFrame();
		BattlePanel battlePanel = new BattlePanel(battleFrame, mainFrame, choosePlayerPanel, tanksListProvider,
				nickname, selectedMap, lvl);

		battleFrame.add(battlePanel);
		battleFrame.settupFrame();
		mainFrame.dispose();
		
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}