package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import components.ChoosePlayerComponents.ScoresLabel;
import images.Explosion;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class EndBattlePanel extends BasicPanel {
	
	private Explosion explosion = new Explosion();
	private TanksListProvider tanksListProvider = new TanksListProvider();
	private int selectedTankIndex = 0; // this has to base on Database
	private String nickname ="";

	public EndBattlePanel(MyFrame mainFrame,MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame, ChoosePlayerPanel choosePlayerPanel) {
		width /= 2;
		height /= 2;

		setLayout(null);
		QuitButton quitButton = new QuitButton(mainFrame,exitBattleFrame,battleFrame);
		PlayAgainButton playAgainButton = new PlayAgainButton(choosePlayerFrame, exitBattleFrame,battleFrame);
//		ScoresLabel scoresLabel = new ScoresLabel(choosePlayerPanel,nickname ); // todo: add player stats on endBattlePanel
		
		add(quitButton);
		add(playAgainButton);
//		add(scoresLabel);//todo: add player stats on endBattlePanel
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		BufferedImage mainImage = tanksListProvider.getTanksList().get(selectedTankIndex).getImage();

		g.drawImage(mainImage, (int) calculateWidth(25), (int) calculateHeight(8), 
				(int) calculateWidth(15),(int) calculateHeight(20), null);
		g.drawImage(explosion.getImage(),(int) calculateWidth(21), (int) calculateHeight(6), 
				(int) calculateWidth(20),(int) calculateHeight(20), null);
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