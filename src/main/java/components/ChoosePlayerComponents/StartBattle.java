package components.ChoosePlayerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.BattlePanel;
import tankProject.panels.ChoosePlayerPanel;

public class StartBattle extends MyButton{

	public StartBattle(MyFrame mainFrame, MyFrame ChoosePlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
		super(EStrings.START_BATTLE.text);
		setBounds((int) choosePlayerPanel.calculateWidth(80), (int) choosePlayerPanel.calculateHeight(90), getWidth(), getHeight());
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChoosePlayerFrame.dispose();
				mainFrame.setVisible(false);
				navigateToBattlePanel();
				
			}
		});
	}
	
	public void navigateToBattlePanel() {
		MyFrame battleFrame = new MyFrame();
		
		BattlePanel battlePanel = new BattlePanel(battleFrame);
		battleFrame.add(battlePanel);
		battleFrame.settupFrame();
	}

}