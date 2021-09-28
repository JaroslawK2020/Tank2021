package tankProject.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.MyButton;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class ChoosePlayerPanel extends BasicPanel {

	public ChoosePlayerPanel(MyFrame mainFrame, MyFrame ChoosePlayerFrame) {
		setLayout(null);

		add(new BacktButton(mainFrame, ChoosePlayerFrame, this));
		add(new StartBattle(mainFrame, ChoosePlayerFrame));
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth(), super.returnScreenHeight());

	}
	class BacktButton extends MyButton {

		public BacktButton(MyFrame mainFrame, MyFrame ChoosePlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
			super(EStrings.BACK.text);
			setBounds((int) calculateWidth(10), (int) calculateHeight(90), getWidth(), getHeight());

			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ChoosePlayerFrame.dispose();
					mainFrame.setVisible(true);
				}
			});
		}
	}
	
	class StartBattle extends MyButton{

		public StartBattle(MyFrame mainFrame, MyFrame ChoosePlayerFrame) {
			super("Start battle");
			setBounds((int) calculateWidth(80), (int) calculateHeight(90), getWidth(), getHeight());
			
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
}
