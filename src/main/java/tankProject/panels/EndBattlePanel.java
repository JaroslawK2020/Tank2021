package tankProject.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import strings.EStrings;
import tankProject.Frame.MyFrame;

public class EndBattlePanel extends BasicPanel {

	public EndBattlePanel(MyFrame battleFrame,MyFrame mainFrame) {
		width /= 2;
		height /= 2;

		setLayout(null);
		
		add(new QuitButton(battleFrame, mainFrame));
		add(new PlayAgainButton(this));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	class QuitButton extends MyButton {

		public QuitButton(MyFrame battleFrame, MyFrame mainFrame) {
			super(EStrings.QUIT.text);
			setBounds((int) calculateWidth(5), (int) calculateHeight(25), getWidth(), getHeight());
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					battleFrame.dispose();
					mainFrame.setVisible(true);
				}
			});
		}
	}
	
	class PlayAgainButton extends MyButton{

		public PlayAgainButton(EndBattlePanel endBattlePanel) {
			super(EStrings.PLAY_AGAIN.text);
			setBounds((int) calculateWidth(30), (int) calculateHeight(25), getWidth(), getHeight());
			addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("play again button pressed");
					
				}
			});
		}
		
	}

}