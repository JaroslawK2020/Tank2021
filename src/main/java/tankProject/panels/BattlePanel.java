package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import components.BattlePanel.EscKeyService;
import components.BattlePanel.ExitLabel;
import components.BattlePanel.IShoot;
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
	int tankYCurrentPosition;
	int tankXCurrentPosition;
	private MyFrame battleFrame;
	private MyFrame mainFrame;
	private ChoosePlayerPanel choosePlayerPanel;
	private int selectedMap;
	private MapsProvider mapsProvider = new MapsProvider();
	private LeftShootsProvider leftShootsProvider = new LeftShootsProvider();
	private DownShootProvider downShootsProvider = new DownShootProvider();
	private UpShootProvider upShootsProvider = new UpShootProvider();
	private RightShootProvider rightShootProvider = new RightShootProvider();
	private DestroyableObjectProvider destroyableObjectProvider;
	private boolean gameOver = false;
	private int shootDirection = 0;
	private int lvl;
	private int initScore = 0;
	ScoreCounter scoreCounter = new ScoreCounter("0", this);
	private int delay = 100;
	ActionListener taskPerformer;
	Timer timer;

	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, ChoosePlayerPanel choosePlayerPanel,
			TanksListProvider tanksListProvider, String nickname, int selectedMap, int lvl) {
		this.selectedMap = selectedMap;
		this.battleFrame = battleFrame;
		this.mainFrame = mainFrame;
		this.choosePlayerPanel = choosePlayerPanel;
		this.destroyableObjectProvider = new DestroyableObjectProvider(lvl);
		startPlatform = new StartPlatform();
		ScoreLabel scoreLabel = new ScoreLabel(this);
		ExitLabel exitLabel = new ExitLabel(this);
		myTank = new MyTank(choosePlayerPanel.mainImage, ((int) this.calculateWidth(3)),
				((int) this.calculateHeight(98)));
		BufferedImage tankRight = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 0);
		BufferedImage tankLeft = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 1);
		BufferedImage tankDown = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 2);
		BufferedImage tankUp = tanksListProvider.getTankByUserForMove(choosePlayerPanel, nickname, 3);

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!gameOver) {
					shootsManager();
					if (leftShootsProvider.getShootsList().size() > 0) {
						leftShootsDestoyedObjectsManager();
					}
					if (rightShootProvider.getShootsList().size() > 0) {
						rigthShootsDestoyedObjectsManager();
					}
					if (downShootsProvider.getShootsList().size() > 0) {
						downShootsDestoyedObjectsManager();
					}
					if (upShootsProvider.getShootsList().size() > 0) {
						upShootsDestoyedObjectsManager();
					}
					if (destroyableObjectProvider.getDestroyableObjects().size() > 0) {
						destroyTankOnTouch();
					}
					repaint();
				} else {
					destroyTank(tanksListProvider, nickname);
				}
				if (destroyableObjectProvider.getDestroyableObjects().get(0).size() == 0
						&& destroyableObjectProvider.getDestroyableObjects().get(1).size() == 0) {
					myTank.setAlive(true);
					gameOver = false;
					ESC_KeyAction(tanksListProvider, nickname, initScore, lvl);
					timer.stop();
				}

			}
		};
		timer = new Timer(delay, taskPerformer);
		timer.start();

		add(scoreCounter);
		add(scoreLabel);
		add(exitLabel);
//
//		System.out.println("BP nickname "+nickname);
//		System.out.println("BP lvl"+ lvl);
		
		
		
		battleFrame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					ESC_KeyAction(tanksListProvider, nickname, initScore, lvl);
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
		gameOver = false;
		timer.stop();
		escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank,
				tanksListProvider, nickname, selectedMap, initScore, lvl);
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

	public void ESC_KeyAction(TanksListProvider tanksListProvider, String nickname, int initScore, int LVL) {
		escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank,
				tanksListProvider, nickname, selectedMap, initScore, LVL);
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
					int mineSize = 60;
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

			}
		}
	}

	private void leftShootsDestoyedObjectsManager() {

		List<IShoot> temp = new ArrayList<IShoot>();

		for (int x = 0; x < leftShootsProvider.shootsList.size(); x++) {

			if (destroyableObjectProvider.getDestroyableObjects().size() > 0) {

				for (int i = 0; i < destroyableObjectProvider.getDestroyableObjects().size(); i++) {
					for (int j = 0; j < destroyableObjectProvider.getDestroyableObjects().get(i).size(); j++) {

						if (leftShootsProvider.getShootsList().get(x)
								.getXposition() >= destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
										.getObjectXPosition()
										- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth())
								& leftShootsProvider.getShootsList().get(x).getXposition() <= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()
										+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth()
								& leftShootsProvider.getShootsList().get(x).getXposition() >= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()) {

							if (leftShootsProvider.getShootsList().get(x).getYposition() >= destroyableObjectProvider
									.getDestroyableObjects().get(i).get(j).getObjectYPosition()
									- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getHeigth())
									& leftShootsProvider.getShootsList().get(x)
											.getYposition() <= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()
													+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
															.getHeigth()
									& leftShootsProvider.getShootsList().get(x)
											.getYposition() >= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()) {
								destroyableObjectProvider.getDestroyableObjects().get(i).remove(j);
								temp.add(leftShootsProvider.getShootsList().get(x));
								initScore++;
								scoreCounter.setText(Integer.toString(initScore));
							}
						}
					}

				}
			}
			for (IShoot t : temp) {
				leftShootsProvider.getShootsList().remove(t);
			}
		}

	}

	private void rigthShootsDestoyedObjectsManager() {

		List<IShoot> temp = new ArrayList<IShoot>();

		for (int x = 0; x < rightShootProvider.shootsList.size(); x++) {

			if (destroyableObjectProvider.getDestroyableObjects().size() > 0) {

				for (int i = 0; i < destroyableObjectProvider.getDestroyableObjects().size(); i++) {
					for (int j = 0; j < destroyableObjectProvider.getDestroyableObjects().get(i).size(); j++) {

						if (rightShootProvider.getShootsList().get(x)
								.getXposition() >= destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
										.getObjectXPosition()
										- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth())
								& rightShootProvider.getShootsList().get(x).getXposition() <= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()
										+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth()
								& rightShootProvider.getShootsList().get(x).getXposition() >= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()) {

							if (rightShootProvider.getShootsList().get(x).getYposition() >= destroyableObjectProvider
									.getDestroyableObjects().get(i).get(j).getObjectYPosition()
									- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getHeigth())
									& rightShootProvider.getShootsList().get(x)
											.getYposition() <= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()
													+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
															.getHeigth()
									& rightShootProvider.getShootsList().get(x)
											.getYposition() >= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()) {
								destroyableObjectProvider.getDestroyableObjects().get(i).remove(j);
								temp.add(rightShootProvider.getShootsList().get(x));
								initScore++;
								scoreCounter.setText(Integer.toString(initScore));
							}
						}
					}

				}
			}
			for (IShoot t : temp) {
				rightShootProvider.getShootsList().remove(t);
			}
		}
	}

	private void upShootsDestoyedObjectsManager() {

		List<IShoot> temp = new ArrayList<IShoot>();

		for (int x = 0; x < upShootsProvider.shootsList.size(); x++) {

			if (destroyableObjectProvider.getDestroyableObjects().size() > 0) {

				for (int i = 0; i < destroyableObjectProvider.getDestroyableObjects().size(); i++) {
					for (int j = 0; j < destroyableObjectProvider.getDestroyableObjects().get(i).size(); j++) {

						if (upShootsProvider.getShootsList().get(x)
								.getXposition() >= destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
										.getObjectXPosition()
										- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth())
								& upShootsProvider.getShootsList().get(x).getXposition() <= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()
										+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth()
								& upShootsProvider.getShootsList().get(x).getXposition() >= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()) {

							if (upShootsProvider.getShootsList().get(x).getYposition() >= destroyableObjectProvider
									.getDestroyableObjects().get(i).get(j).getObjectYPosition()
									- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getHeigth())
									& upShootsProvider.getShootsList().get(x)
											.getYposition() <= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()
													+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
															.getHeigth()
									& upShootsProvider.getShootsList().get(x)
											.getYposition() >= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()) {
								destroyableObjectProvider.getDestroyableObjects().get(i).remove(j);
								temp.add(upShootsProvider.getShootsList().get(x));
								initScore++;
								scoreCounter.setText(Integer.toString(initScore));
							}
						}
					}

				}
			}
			for (IShoot t : temp) {
				upShootsProvider.getShootsList().remove(t);
			}
		}
	}

	private void downShootsDestoyedObjectsManager() {

		List<IShoot> temp = new ArrayList<IShoot>();

		for (int x = 0; x < downShootsProvider.shootsList.size(); x++) {

			if (destroyableObjectProvider.getDestroyableObjects().size() > 0) {

				for (int i = 0; i < destroyableObjectProvider.getDestroyableObjects().size(); i++) {
					for (int j = 0; j < destroyableObjectProvider.getDestroyableObjects().get(i).size(); j++) {

						if (downShootsProvider.getShootsList().get(x)
								.getXposition() >= destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
										.getObjectXPosition()
										- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth())
								& downShootsProvider.getShootsList().get(x).getXposition() <= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()
										+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth()
								& downShootsProvider.getShootsList().get(x).getXposition() >= destroyableObjectProvider
										.getDestroyableObjects().get(i).get(j).getObjectXPosition()) {

							if (downShootsProvider.getShootsList().get(x).getYposition() >= destroyableObjectProvider
									.getDestroyableObjects().get(i).get(j).getObjectYPosition()
									- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getHeigth())
									& downShootsProvider.getShootsList().get(x)
											.getYposition() <= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()
													+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j)
															.getHeigth()
									& downShootsProvider.getShootsList().get(x)
											.getYposition() >= destroyableObjectProvider.getDestroyableObjects().get(i)
													.get(j).getObjectYPosition()) {
								destroyableObjectProvider.getDestroyableObjects().get(i).remove(j);
								temp.add(downShootsProvider.getShootsList().get(x));
								initScore++;
								scoreCounter.setText(Integer.toString(initScore));
							}
						}
					}

				}
			}
			for (IShoot t : temp) {
				downShootsProvider.getShootsList().remove(t);
			}
		}
	}

	private void destroyTankOnTouch() {

		if (destroyableObjectProvider.getDestroyableObjects().size() > 0) {

			for (int i = 0; i < destroyableObjectProvider.getDestroyableObjects().size(); i++) {
				for (int j = 0; j < destroyableObjectProvider.getDestroyableObjects().get(i).size(); j++) {

					if (myTank.getTankStartXposition() >= destroyableObjectProvider.getDestroyableObjects().get(i)
							.get(j).getObjectXPosition()
							- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth())
							& myTank.getTankStartXposition() <= destroyableObjectProvider.getDestroyableObjects().get(i)
									.get(j).getObjectXPosition()
									+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getWidth()
							& myTank.getTankStartXposition() >= destroyableObjectProvider.getDestroyableObjects().get(i)
									.get(j).getObjectXPosition()) {

						if (myTank.getTankStartYposition() >= destroyableObjectProvider.getDestroyableObjects().get(i)
								.get(j).getObjectYPosition()
								- (destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getHeigth())
								& myTank.getTankStartYposition() <= destroyableObjectProvider.getDestroyableObjects()
										.get(i).get(j).getObjectYPosition()
										+ destroyableObjectProvider.getDestroyableObjects().get(i).get(j).getHeigth()
								& myTank.getTankStartYposition() >= destroyableObjectProvider.getDestroyableObjects()
										.get(i).get(j).getObjectYPosition()) {
							gameOver = true;

						}
					}
				}

			}

		}
	}

}
