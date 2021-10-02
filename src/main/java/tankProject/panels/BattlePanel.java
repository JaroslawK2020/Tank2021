package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import components.BattlePanel.BattlePanelTextEditor;
import components.BattlePanel.EscKeyService;
import components.BattlePanel.ExitLabel;
import components.BattlePanel.MyTank;
import components.BattlePanel.ScoreCounter;
import components.BattlePanel.ScoreLabel;
import components.ChoosePlayerComponents.PlayersList;
import images.ForestBackground;
import images.StartPlatform;
import providers.MapsProvider;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class BattlePanel extends BasicPanel {

	private ForestBackground forestBackground;
	private StartPlatform startPlatform;
	private EscKeyService escKeyService;
	private MyFrame choosePlayerFrame;
	private MyTank myTank;
	private String nickname;

	private int pointCounter = 0;
	private MyFrame battleFrame;
	private MyFrame mainFrame;
	private ChoosePlayerPanel choosePlayerPanel;
	private int selectedMap;
	MapsProvider mapsProvider = new MapsProvider();


	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, TanksListProvider tanksListProvider, String nickname, int selectedMap) {
		this.selectedMap = selectedMap;
		this.battleFrame = battleFrame;
		this.mainFrame = mainFrame;
		this.choosePlayerPanel = choosePlayerPanel;
		forestBackground = new ForestBackground();
		startPlatform = new StartPlatform();
		ScoreCounter scoreCounter = new ScoreCounter(Integer.toString(pointCounter), this);
		ScoreLabel scoreLabel = new ScoreLabel(this);
		ExitLabel exitLabel = new ExitLabel(this);

		BufferedImage tankRight = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 0);
		BufferedImage tankLeft = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 1);
		BufferedImage tankDown = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 2);
		BufferedImage tankUp = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 3);

		myTank = new MyTank(choosePlayerPanel.mainImage, ((int) this.calculateWidth(3)),
				((int) this.calculateHeight(98)));

		add(scoreCounter);
		add(scoreLabel);
		add(exitLabel);

		battleFrame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel,
							myTank, tanksListProvider, nickname, selectedMap);

				if (e.getKeyChar() == KeyEvent.VK_1) {
					destroyTank(tanksListProvider, nickname);// temporary set tank destroy on 1 click
				}

			}

			int tankYCurrentPosition;
			int tankXCurrentPosition;

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					myTank.setTankImg(tankUp);
					tankYCurrentPosition = myTank.getTankStartYposition();
					myTank.setTankStartYposition(tankYCurrentPosition -= 20);
					if (tankYCurrentPosition <= 0)
						myTank.setTankStartYposition(0);

				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					myTank.setTankImg(tankDown);
					tankYCurrentPosition = myTank.getTankStartYposition();
					myTank.setTankStartYposition(tankYCurrentPosition += 20);
					if (tankYCurrentPosition > (returnScreenHeight() - myTank.getHeight()))
						myTank.setTankStartYposition(returnScreenHeight() - myTank.getHeight());

				} else if (e.getKeyCode() == KeyEvent.VK_A) {
					myTank.setTankImg(tankLeft);
					tankXCurrentPosition = myTank.getTankStartXposition();
					myTank.setTankStartXposition(tankXCurrentPosition -= 20);
					if (tankXCurrentPosition <= 0)
						myTank.setTankStartXposition(0);

				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					myTank.setTankImg(tankRight);
					tankXCurrentPosition = myTank.getTankStartXposition();
					myTank.setTankStartXposition(tankXCurrentPosition += 20);
					if (tankXCurrentPosition > (returnScreenWidth() - myTank.getWidth()))
						myTank.setTankStartXposition(returnScreenWidth() - myTank.getWidth());

				} else if (e.getKeyCode() == KeyEvent.VK_SPACE)
					System.out.println("SHOT");

				repaint();
			}
		});
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(), returnScreenHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(mapsProvider.getMapsList().get(selectedMap).getImage(), 0, 0, returnScreenWidth(), returnScreenHeight(), null);
		g.drawImage(startPlatform.getImage(), (int) calculateWidth(0.01f), (int) calculateHeight(93.5f),
				(int) calculateWidth(10), (int) calculateHeight(14.5f), null);
		g.drawImage(myTank.getTankImg(), myTank.getTankStartXposition(), myTank.getTankStartYposition(),
				myTank.getWidth(), myTank.getHeight(), null);

	}

	private void destroyTank(TanksListProvider tanksListProvider, String nickname) {
		myTank.setAlive(false);
		escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank,
				tanksListProvider, nickname, selectedMap);
	}

}