package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import components.BattlePanel.EscKeyService;
import components.BattlePanel.ExitLabel;
import components.BattlePanel.MyTank;
import components.BattlePanel.ScoreCounter;
import components.BattlePanel.ScoreLabel;
import images.ForestBackground;
import images.StartPlatform;
import providers.DownShootProvider;
import providers.LeftShootsProvider;
import providers.MapsProvider;
import providers.RightShootProvider;
import providers.TanksListProvider;
import providers.UpShootProvider;
import tankProject.Frame.MyFrame;

public class BattlePanel extends BasicPanel {

	private ForestBackground forestBackground;
	private StartPlatform startPlatform;
	private EscKeyService escKeyService;
	private MyFrame choosePlayerFrame;
	private MyTank myTank;
	private String nickname;
	int tankYCurrentPosition;
	int tankXCurrentPosition;
	private int pointCounter = 0;
	private MyFrame battleFrame;
	private MyFrame mainFrame;
	private ChoosePlayerPanel choosePlayerPanel;
	private int selectedMap;
	MapsProvider mapsProvider = new MapsProvider();
	LeftShootsProvider leftShootsProvider = new LeftShootsProvider();
	RightShootProvider rightShootProvider = new RightShootProvider();
	DownShootProvider downShootsProvider = new DownShootProvider();
	UpShootProvider upShootsProvider = new UpShootProvider();

	int shootDirection = 0;

	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, TanksListProvider tanksListProvider, String nickname,
			int selectedMap) {
		this.selectedMap = selectedMap;
		this.battleFrame = battleFrame;
		this.mainFrame = mainFrame;
		this.choosePlayerPanel = choosePlayerPanel;
		forestBackground = new ForestBackground();
		startPlatform = new StartPlatform();
		ScoreCounter scoreCounter = new ScoreCounter(Integer.toString(pointCounter), this);
		ScoreLabel scoreLabel = new ScoreLabel(this);
		ExitLabel exitLabel = new ExitLabel(this);
		myTank = new MyTank(choosePlayerPanel.mainImage, ((int) this.calculateWidth(3)),
				((int) this.calculateHeight(98)));

		BufferedImage tankRight = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 0);
		BufferedImage tankLeft = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 1);
		BufferedImage tankDown = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 2);
		BufferedImage tankUp = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 3);

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
					ESC_KeyAction(tanksListProvider, nickname);

				if (e.getKeyChar() == KeyEvent.VK_1) {
					destroyTank(tanksListProvider, nickname);// temporary set tank destroy on 1 click
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W) {
					W_KeyAction(tankUp);

				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					S_KeyAction(tankDown);

				} else if (e.getKeyCode() == KeyEvent.VK_A) {
					A_KeyAction(tankLeft);

				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					D_KeyAction(tankRight);

				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					shoot();
				}
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
		g.drawImage(mapsProvider.getMapsList().get(selectedMap).getImage(), 0, 0, returnScreenWidth(),
				returnScreenHeight(), null);
		g.drawImage(startPlatform.getImage(), (int) calculateWidth(0.01f), (int) calculateHeight(93.5f),
				(int) calculateWidth(10), (int) calculateHeight(14.5f), null);
		g.drawImage(myTank.getTankImg(), myTank.getTankStartXposition(), myTank.getTankStartYposition(),
				myTank.getWidth(), myTank.getHeight(), null);

		for (int i = 0; i < leftShootsProvider.shootsList.size(); i++) {

			g.drawImage(leftShootsProvider.shootsList.get(i).getImage(),
					leftShootsProvider.shootsList.get(i).getYposition(),
					leftShootsProvider.shootsList.get(i).getXposition(),
					leftShootsProvider.shootsList.get(i).getWidth(), leftShootsProvider.shootsList.get(i).getHeight(),
					null);
		}
		for (int i = 0; i < rightShootProvider.shootsList.size(); i++) {

			g.drawImage(rightShootProvider.shootsList.get(i).getImage(),
					rightShootProvider.shootsList.get(i).getYposition(),
					rightShootProvider.shootsList.get(i).getXposition(),
					rightShootProvider.shootsList.get(i).getWidth(), rightShootProvider.shootsList.get(i).getHeight(),
					null);
		}
		for (int i = 0; i < downShootsProvider.shootsList.size(); i++) {

			g.drawImage(downShootsProvider.shootsList.get(i).getImage(),
					downShootsProvider.shootsList.get(i).getYposition(),
					downShootsProvider.shootsList.get(i).getXposition(),
					downShootsProvider.shootsList.get(i).getWidth(), downShootsProvider.shootsList.get(i).getHeight(),
					null);
		}
		for (int i = 0; i < upShootsProvider.shootsList.size(); i++) {

			g.drawImage(upShootsProvider.shootsList.get(i).getImage(),
					upShootsProvider.shootsList.get(i).getYposition(),
					upShootsProvider.shootsList.get(i).getXposition(), upShootsProvider.shootsList.get(i).getWidth(),
					upShootsProvider.shootsList.get(i).getHeight(), null);
		}
	}

	private void destroyTank(TanksListProvider tanksListProvider, String nickname) {
		myTank.setAlive(false);
		escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank,
				tanksListProvider, nickname, selectedMap);
	}

	public void changeShootDirection(int index) {
		this.shootDirection = index;
	}

	public void shoot() {
		if (shootDirection == 0) {
			rightShootProvider.newShoot(myTank);
		}
		if (shootDirection == 1) {
			leftShootsProvider.newShoot(myTank);
		}
		if (shootDirection == 2) {
			downShootsProvider.newShoot(myTank);
		}
		if (shootDirection == 3) {
			upShootsProvider.newShoot(myTank);
		}

	}

	public void W_KeyAction(BufferedImage tankImage) {
		changeShootDirection(3);
		myTank.setTankImg(tankImage);
		tankYCurrentPosition = myTank.getTankStartYposition();
		myTank.setTankStartYposition(tankYCurrentPosition -= 20);
		if (tankYCurrentPosition <= 0)
			myTank.setTankStartYposition(0);
	}

	public void A_KeyAction(BufferedImage tankImage) {
		changeShootDirection(1);
		myTank.setTankImg(tankImage);
		tankXCurrentPosition = myTank.getTankStartXposition();
		myTank.setTankStartXposition(tankXCurrentPosition -= 20);
		if (tankXCurrentPosition <= 0)
			myTank.setTankStartXposition(0);
	}

	public void S_KeyAction(BufferedImage tankImage) {
		changeShootDirection(2);
		myTank.setTankImg(tankImage);
		tankYCurrentPosition = myTank.getTankStartYposition();
		myTank.setTankStartYposition(tankYCurrentPosition += 20);
		if (tankYCurrentPosition > (returnScreenHeight() - myTank.getHeight()))
			myTank.setTankStartYposition(returnScreenHeight() - myTank.getHeight());

	}

	public void D_KeyAction(BufferedImage tankImage) {
		changeShootDirection(0);
		myTank.setTankImg(tankImage);
		tankXCurrentPosition = myTank.getTankStartXposition();
		myTank.setTankStartXposition(tankXCurrentPosition += 20);
		if (tankXCurrentPosition > (returnScreenWidth() - myTank.getWidth()))
			myTank.setTankStartXposition(returnScreenWidth() - myTank.getWidth());
	}

	public void ESC_KeyAction(TanksListProvider tanksListProvider, String nickname) {
		escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank,
				tanksListProvider, nickname, selectedMap);
	}
}