package tankProject.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.BattlePanel.ScoreLabel;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class EndBattlePanel extends BasicPanel {

	public EndBattlePanel(MyFrame mainFrame,MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame) {
		width /= 2;
		height /= 2;

		setLayout(null);
		QuitButton quitButton = new QuitButton(mainFrame,exitBattleFrame,battleFrame);
		PlayAgainButton playAgainButton = new PlayAgainButton(choosePlayerFrame, exitBattleFrame,battleFrame);
		
		add(quitButton);
		add(playAgainButton);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	class QuitButton extends MyButton {

		public QuitButton(MyFrame mainFrame,MyFrame exitBattleFrame, MyFrame battleFrame) {
			super(EStrings.QUIT.text);
			setBounds((int) calculateWidth(5), (int) calculateHeight(38), getWidth(), getHeight());
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setVisible(true);
					exitBattleFrame.dispose();
					battleFrame.dispose();
				}
			});
		}
	}
	
	class PlayAgainButton extends MyButton{

		public PlayAgainButton(MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame) {
			super(EStrings.PLAY_AGAIN.text);
			setBounds((int) calculateWidth(35), (int) calculateHeight(38), getWidth(), getHeight());
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					choosePlayerFrame.setVisible(true);
					exitBattleFrame.dispose();
					battleFrame.dispose();
				}
			});
		}
	}

}