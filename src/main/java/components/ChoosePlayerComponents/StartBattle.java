package components.ChoosePlayerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;
import tankProject.panels.BattlePanel;
import tankProject.panels.ChoosePlayerPanel;

public class StartBattle extends MyButton{
	private MyFrame choosePlayerFrame;

	public StartBattle(MyFrame mainFrame, MyFrame choosePlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
		super(EStrings.START_BATTLE.text);
		this.choosePlayerFrame = choosePlayerFrame;
		setBounds((int) choosePlayerPanel.calculateWidth(80), (int) choosePlayerPanel.calculateHeight(90), getWidth(), getHeight());
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				choosePlayerFrame.setVisible(false);
				mainFrame.setVisible(false);
				navigateToBattlePanel(mainFrame);
				
			}
		});
	}
	
	public void navigateToBattlePanel(MyFrame mainFrame) {
		MyFrame battleFrame = new MyFrame();
		
		BattlePanel battlePanel = new BattlePanel(battleFrame,mainFrame,choosePlayerFrame);
		battleFrame.add(battlePanel);
		battleFrame.settupFrame();
	}

}