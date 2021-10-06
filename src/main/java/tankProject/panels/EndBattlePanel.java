package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.BattlePanel.MyTank;
import components.ChoosePlayerComponents.MyLabel;
import components.ChoosePlayerComponents.StartBattle;
import components.CreateNewPlayerComponent.CreateButton;
import components.EndBattleComponents.LabelsOnEndBattle;
import components.EndBattleComponents.PlayAgainButton;
import components.EndBattleComponents.QuitButtonEndBattle;
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

		QuitButtonEndBattle quitButtonEndBattle = new QuitButtonEndBattle(mainFrame, choosePlayerFrame, exitBattleFrame, battleFrame, nickname,
				initScore, choosePlayerPanel, LVL);
		PlayAgainButton playAgainButton = new PlayAgainButton(mainFrame, exitBattleFrame, choosePlayerFrame,
				battleFrame, choosePlayerPanel, tanksListProvider, nickname, selectedMap);
		LabelsOnEndBattle labelsOnEndBattle =  new LabelsOnEndBattle(choosePlayerPanel, nickname);

//		MyLabel lvl = new MyLabel();
//		lvl.setText("Lvl " + Integer.toString(LVL));
//		lvl.setBounds((int) calculateWidth(5), (int) calculateHeight(7), (int) calculateWidth(50), (int) calculateHeight(30));
		
		add(quitButtonEndBattle);
		add(playAgainButton);
		add(labelsOnEndBattle);
//		add(lvl);
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
			destroyedTankComponents(g);
		}
	}
	
	private void destroyedTankComponents(Graphics g) {
		g.drawImage(new Explosion().getImage(), (int) calculateWidth(33), (int) calculateHeight(7),
				(int) calculateWidth(10), (int) calculateHeight(13), null);
		g.drawImage(new Game().getImage(), (int) calculateWidth(3), (int) calculateHeight(5),
				(int) calculateWidth(17), (int) calculateHeight(13), null);
		g.drawImage(new Over().getImage(), (int) calculateWidth(3), (int) calculateHeight(20),
				(int) calculateWidth(17), (int) calculateHeight(13), null);
	}

}