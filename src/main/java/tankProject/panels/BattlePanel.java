package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

import components.BattlePanel.EscKeyService;
import components.BattlePanel.ExitLabel;
import components.BattlePanel.MyTank;
import components.BattlePanel.ScoreCounter;
import components.BattlePanel.ScoreLabel;
import images.MineImg;
import images.ReactorImg;
import images.StartPlatform;
import providers.DestroyableObjectProvider;
import providers.DownShootProvider;
import providers.LeftShootsProvider;
import providers.MapsProvider;
import providers.RightShootProvider;
import providers.TanksListProvider;
import providers.UpShootProvider;
import tankProject.Frame.MyFrame;

public class BattlePanel extends BasicPanel {

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
	DestroyableObjectProvider destroyableObjectProvider = new DestroyableObjectProvider();
	boolean runAnimation = true;
	int shootDirection = 0;

	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, ChoosePlayerPanel choosePlayerPanel,
			TanksListProvider tanksListProvider, String nickname, int selectedMap) {
		this.selectedMap = selectedMap;
		this.battleFrame = battleFrame;
		this.mainFrame = mainFrame;
		this.choosePlayerPanel = choosePlayerPanel;
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

		int delay = 500;
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				shootsManager();
				repaint();
			}
		};
		new Timer(delay, taskPerformer).start();

		add(scoreCounter);
		add(scoreLabel);
		add(exitLabel);

		battleFrame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					ESC_KeyAction(tanksListProvider, nickname);

				if (e.getKeyChar() == KeyEvent.VK_1) {
					destroyTank(tanksListProvider, nickname);
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
					leftShootsProvider.shootsList.get(i).getXposition(),
					leftShootsProvider.shootsList.get(i).getYposition(),
					leftShootsProvider.shootsList.get(i).getWidth(), leftShootsProvider.shootsList.get(i).getHeight(),
					null);
		}
		for (int i = 0; i < rightShootProvider.shootsList.size(); i++) {

			g.drawImage(rightShootProvider.shootsList.get(i).getImage(),
					rightShootProvider.shootsList.get(i).getXposition(),
					rightShootProvider.shootsList.get(i).getYposition(),
					rightShootProvider.shootsList.get(i).getWidth(), rightShootProvider.shootsList.get(i).getHeight(),
					null);
		}
		for (int i = 0; i < downShootsProvider.shootsList.size(); i++) {

			g.drawImage(downShootsProvider.shootsList.get(i).getImage(),
					downShootsProvider.shootsList.get(i).getXposition(),
					downShootsProvider.shootsList.get(i).getYposition(),
					downShootsProvider.shootsList.get(i).getWidth(), downShootsProvider.shootsList.get(i).getHeight(),
					null);
		}
		for (int i = 0; i < upShootsProvider.shootsList.size(); i++) {

			g.drawImage(upShootsProvider.shootsList.get(i).getImage(),
					upShootsProvider.shootsList.get(i).getXposition(),
					upShootsProvider.shootsList.get(i).getYposition(), upShootsProvider.shootsList.get(i).getWidth(),
					upShootsProvider.shootsList.get(i).getHeight(), null);
		}

		drawMineAndReactors(g);

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
		printMinePosition(); // temporary print mine position on space click

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
		runAnimation = false;
		escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank,
				tanksListProvider, nickname, selectedMap);
	}

	public void shootsManager() {
		if (leftShootsProvider.getShootsList().size() > 0) {
			for (int i = 0; i < leftShootsProvider.getShootsList().size(); i++) {
				if (leftShootsProvider.getShootsList().get(i).getXposition() < 0) {
					leftShootsProvider.getShootsList().remove(leftShootsProvider.getShootsList().get(i));
				} else
					leftShootsProvider.getShootsList().get(i).move();
			}
		}
		if (rightShootProvider.getShootsList().size() > 0) {
			for (int i = 0; i < rightShootProvider.getShootsList().size(); i++) {
				if (rightShootProvider.getShootsList().get(i).getXposition() > returnScreenWidth()) {
					rightShootProvider.getShootsList().remove(rightShootProvider.getShootsList().get(i));
				} else
					rightShootProvider.getShootsList().get(i).move();
			}
		}
		if (downShootsProvider.getShootsList().size() > 0) {
			for (int i = 0; i < downShootsProvider.getShootsList().size(); i++) {
				if (downShootsProvider.getShootsList().get(i).getYposition() > returnScreenHeight()) {
					downShootsProvider.getShootsList().remove(downShootsProvider.getShootsList().get(i));
				} else
					downShootsProvider.getShootsList().get(i).move();
			}
		}
		if (upShootsProvider.getShootsList().size() > 0) {
			for (int i = 0; i < upShootsProvider.getShootsList().size(); i++) {
				if (upShootsProvider.getShootsList().get(i).getYposition() < 0) {
					upShootsProvider.getShootsList().remove(upShootsProvider.getShootsList().get(i));
				} else
					upShootsProvider.getShootsList().get(i).move();
			}
		}
	}

	private void drawMineAndReactors(Graphics g) {
		for (int i = 0; i < destroyableObjectProvider.getDestroyableObjects().size(); i++) {
			for (int j = 0; j < destroyableObjectProvider.getDestroyableObjects().get(i).size(); j++) {
				if (destroyableObjectProvider.getDestroyableObjects().get(i).get(j) instanceof MineImg) {
					int mineSize = 30;
					if (destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
							.getObjectXPosition() < (int) calculateWidth(10)
							&& destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
									.getObjectYPosition() >= (int) calculateHeight(93.5f)
											+ (int) calculateHeight(14.5f)) {
						g.drawImage(destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getImage(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectXPosition()
										+ 50,
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectYPosition()
										- 50,
								mineSize, mineSize, null);
					} else {
						g.drawImage(destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getImage(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectXPosition(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectYPosition(),
								mineSize, mineSize, null);
					}
				} else if (destroyableObjectProvider.getDestroyableObjects().get(i).get(j) instanceof ReactorImg) {
					int reactorSize = 100;
					if (destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
							.getObjectXPosition() < (int) calculateWidth(10)
							&& destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
									.getObjectYPosition() >= (int) calculateHeight(93.5f)
											+ (int) calculateHeight(14.5f)) {
						g.drawImage(destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getImage(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectXPosition()
										+ 100,
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectYPosition()
										- 100,
								reactorSize, reactorSize, null);
					} else {
						g.drawImage(destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getImage(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectXPosition(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectYPosition(),
								reactorSize, reactorSize, null);
						g.drawImage(destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getImage(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectXPosition(),
								destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectYPosition(),
								reactorSize, reactorSize, null);
					}
				}
			}
		}

	}

	private void printMinePosition() {
		for (int i = 0; i < destroyableObjectProvider.getDestroyableObjects().size(); i++) {
			for (int j = 0; j < destroyableObjectProvider.getDestroyableObjects().get(i).size(); j++) {
				if (destroyableObjectProvider.getDestroyableObjects().get(i).get(j) instanceof MineImg) {
					System.out.println("mine X pos: "
							+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectXPosition());
					System.out.println("mine Y pos: "
							+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getObjectYPosition());
				}
			}
		}

	}

}
