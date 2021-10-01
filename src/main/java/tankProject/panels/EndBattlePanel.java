package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import components.BattlePanel.MyTank;
import components.ChoosePlayerComponents.ScoresLabel;
import components.ChoosePlayerComponents.StartBattle;
import images.Explosion;
import images.Game;
import images.Over;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class EndBattlePanel extends BasicPanel {

	public BufferedImage mainImage = null;
	private MyFrame choosePlayerFrame;
	private ChoosePlayerPanel choosePlayerPanel;
	private MyFrame mainFrame;
	private MyTank myTank;
	private TanksListProvider tanksListProvider;
	private String nickname;

	public EndBattlePanel(MyFrame mainFrame, MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, String nickname) {
		this.choosePlayerFrame = choosePlayerFrame;
		this.choosePlayerPanel = choosePlayerPanel;
		this.mainFrame = mainFrame;
		this.myTank = myTank;
		this.nickname = nickname;
		width /= 2;
		height /= 2;
		mainImage = choosePlayerPanel.mainImage;

		tanksListProvider = new TanksListProvider(choosePlayerPanel, choosePlayerPanel.nickname);
		QuitButton quitButton = new QuitButton(mainFrame, choosePlayerFrame, exitBattleFrame, battleFrame);
		PlayAgainButton playAgainButton = new PlayAgainButton(mainFrame, exitBattleFrame, battleFrame, tanksListProvider);

		add(quitButton);
		add(playAgainButton);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(mainImage, (int) calculateWidth(25), (int) calculateHeight(8), (int) calculateWidth(15),
				(int) calculateHeight(20), null);
		if (!myTank.isAlive()) {
			g.drawImage(new Explosion().getImage(), (int) calculateWidth(33), (int) calculateHeight(7),
					(int) calculateWidth(10), (int) calculateHeight(13), null);
			g.drawImage(new Game().getImage(), (int) calculateWidth(3), (int) calculateHeight(5),
					(int) calculateWidth(17), (int) calculateHeight(13), null);
			g.drawImage(new Over().getImage(), (int) calculateWidth(3), (int) calculateHeight(20),
					(int) calculateWidth(17), (int) calculateHeight(13), null);

		}

	}

	class QuitButton extends MyButton {

		public QuitButton(MyFrame mainFrame, MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame) {
			super(EStrings.QUIT.text);
			setBounds((int) calculateWidth(5), (int) calculateHeight(38), getWidth(), getHeight());
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setVisible(false);
					choosePlayerFrame.setVisible(true);
					exitBattleFrame.dispose();
					battleFrame.dispose();

				}
			});
		}
	}

	class PlayAgainButton extends MyButton {

		public PlayAgainButton(MyFrame mainFrame, MyFrame exitBattleFrame, MyFrame battleFrame, TanksListProvider tanksListProvider) {
			super(EStrings.PLAY_AGAIN.text);
			setBounds((int) calculateWidth(35), (int) calculateHeight(38), getWidth(), getHeight());

			StartBattle startBattle = new StartBattle(mainFrame, choosePlayerFrame, choosePlayerPanel, tanksListProvider);

			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.setVisible(false);
					exitBattleFrame.dispose();
					battleFrame.dispose();
					startBattle.navigateToBattlePanel(mainFrame,choosePlayerFrame,choosePlayerPanel,tanksListProvider,nickname);


				}
			});
		}
	}

}