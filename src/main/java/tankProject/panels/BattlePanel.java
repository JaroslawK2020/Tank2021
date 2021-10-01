package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import components.BattlePanel.AKeyService;
import components.BattlePanel.BattlePanelTextEditor;
import components.BattlePanel.DKeyService;
import components.BattlePanel.EscKeyService;
import components.BattlePanel.ExitLabel;
import components.BattlePanel.MyTank;
import components.BattlePanel.SKeyService;
import components.BattlePanel.ScoreCounter;
import components.BattlePanel.ScoreLabel;
import components.BattlePanel.SpaceKeyService;
import components.BattlePanel.WKeyService;
import components.ChoosePlayerComponents.PlayersList;
import images.ForestBackground;
import images.StartPlatform;
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class BattlePanel extends BasicPanel {

	private ForestBackground forestBackground;
	private StartPlatform startPlatform;
	private WKeyService wKeyService;
	private SKeyService sKeyService;
	private AKeyService aKeyService;
	private DKeyService dKeyService;
	private SpaceKeyService spaceKeyService;
	private EscKeyService escKeyService;
	private MyFrame choosePlayerFrame;
	private MyTank myTank;
	String innerNickname;

	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel, TanksListProvider tanksListProvider, String nickname) {
		innerNickname = nickname;
		forestBackground = new ForestBackground();
		startPlatform = new StartPlatform();
		ScoreCounter scoreCounter = new ScoreCounter("20", this);
		ScoreLabel scoreLabel = new ScoreLabel(this);
		ExitLabel exitLabel = new ExitLabel(this);
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
					escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			//if (e.getKeyCode() == KeyEvent.VK_W) {
	System.out.println(innerNickname);
	System.out.println(nickname);


	

//					.setTankImg(tanksListProvider.getTankByUserForMove(choosePlayerPanel,
//							choosePlayerPanel.nickname, 1));
//					wKeyService = new WKeyService(myTank);
//				} else if (e.getKeyCode() == KeyEvent.VK_S) {
//					sKeyService = new SKeyService(myTank, returnScreenHeight());
//					myTank.setTankImg(tanksListProvider.getTankByUserForMove(choosePlayerPanel,
//							choosePlayerPanel.nickname, 2));
//				} else if (e.getKeyCode() == KeyEvent.VK_A) {
//					aKeyService = new AKeyService(myTank);
//					myTank.setTankImg(tanksListProvider.getTankByUserForMove(choosePlayerPanel,
//							choosePlayerPanel.nickname, 3));
//				} else if (e.getKeyCode() == KeyEvent.VK_D) {
//					dKeyService = new DKeyService(myTank, returnScreenWidth());
//					myTank.setTankImg(tanksListProvider.getTankByUserForMove(choosePlayerPanel,
//							choosePlayerPanel.nickname, 4));
//				}
//
//				else if (e.getKeyCode() == KeyEvent.VK_SPACE)
//					spaceKeyService = new SpaceKeyService(e);
//
//				repaint();
			}
		});

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(), returnScreenHeight());
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(forestBackground.getImage(), 0, 0, returnScreenWidth(), returnScreenHeight(), null);
		g.drawImage(startPlatform.getImage(), (int) calculateWidth(0.01f), (int) calculateHeight(93.5f),
				(int) calculateWidth(10), (int) calculateHeight(14.5f), null);
		g.drawImage(myTank.getTankImg(), myTank.getTankStartXposition(), myTank.getTankStartYposition(),
				myTank.getWidth(), myTank.getHeight(), null);

	}

}
