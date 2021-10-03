package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.BattlePanel.MyTank;
import components.ChoosePlayerComponents.StartBattle;
import components.CreateNewPlayerComponent.CreateButton;
import images.Explosion;
import images.Game;
import images.Over;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class EndBattlePanel extends BasicPanel {

private ChoosePlayerPanel choosePlayerPanel;
private MyTank myTank;

	public EndBattlePanel(MyFrame mainFrame, MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame,
			ChoosePlayerPanel choosePlayerPanel, MyTank myTank, TanksListProvider tanksListProvider, String nickname,
			int selectedMap, int initScore, int LVL) {
		this.choosePlayerPanel = choosePlayerPanel;
		this.myTank = myTank;
		width /= 2;
		height /= 2;

		QuitButton quitButton = new QuitButton(mainFrame, choosePlayerFrame, exitBattleFrame, battleFrame, nickname,
				initScore, choosePlayerPanel, LVL);
		PlayAgainButton playAgainButton = new PlayAgainButton(mainFrame, exitBattleFrame, choosePlayerFrame,
				battleFrame, choosePlayerPanel, tanksListProvider, nickname, selectedMap);

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

		g.drawImage(choosePlayerPanel.mainImage, (int) calculateWidth(25), (int) calculateHeight(8),
				(int) calculateWidth(15), (int) calculateHeight(20), null);
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

		public QuitButton(MyFrame mainFrame, MyFrame choosePlayerFrame, MyFrame exitBattleFrame, MyFrame battleFrame,
				String nickname, int initScore, ChoosePlayerPanel prevChoosePlayerPanel, int LVL) {
			super(EStrings.QUIT.text);
			setBounds((int) calculateWidth(5), (int) calculateHeight(38), getWidth(), getHeight());
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int updateValue = initScore + choosePlayerPanel.databaseManager.getUserScores(nickname);
					int newLvl = LVL + 1;

					choosePlayerPanel.databaseManager.setNewScores(nickname, updateValue);
					choosePlayerPanel.databaseManager.setNewLvl(nickname, newLvl);

					MyFrame choosePlayerFrame = new MyFrame();
					ChoosePlayerPanel choosePlayerPanel = new ChoosePlayerPanel(mainFrame, choosePlayerFrame);

					choosePlayerFrame.add(choosePlayerPanel);
					choosePlayerFrame.settupFrame();

					exitBattleFrame.dispose();
					battleFrame.dispose();
				}
			});
		}
	}

	class PlayAgainButton extends MyButton {

		public PlayAgainButton(MyFrame mainFrame, MyFrame exitBattleFrame, MyFrame choosePlayerFrame,
				MyFrame battleFrame, ChoosePlayerPanel choosePlayerPanel, TanksListProvider tanksListProvider,
				String nickname, int selectedMap) {
			super(EStrings.PLAY_AGAIN.text);
			setBounds((int) calculateWidth(35), (int) calculateHeight(38), getWidth(), getHeight());

			StartBattle startBattle = new StartBattle(mainFrame, choosePlayerFrame, choosePlayerPanel,
					tanksListProvider);

			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					startBattle.navigateToBattlePanel(mainFrame, choosePlayerPanel, tanksListProvider, nickname,
							selectedMap, choosePlayerPanel.lvl);
					
					battleFrame.dispose();
					exitBattleFrame.dispose();

				
				}
			});
		}
	}

}