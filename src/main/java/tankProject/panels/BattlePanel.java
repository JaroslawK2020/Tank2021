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
	private int pointCounter = 0;
	private MyFrame battleFrame;
	private MyFrame mainFrame;
	private ChoosePlayerPanel choosePlayerPanel;

	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame,
			ChoosePlayerPanel choosePlayerPanel) {
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
					escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank);
				if (e.getKeyChar() == KeyEvent.VK_1) {
					destroyTank();// temporary set tank destroy on 1 click
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_W)
					wKeyService = new WKeyService(myTank);
				else if (e.getKeyCode() == KeyEvent.VK_S)
					sKeyService = new SKeyService(myTank, returnScreenHeight());
				else if (e.getKeyCode() == KeyEvent.VK_A)
					aKeyService = new AKeyService(myTank);
				else if (e.getKeyCode() == KeyEvent.VK_D)
					dKeyService = new DKeyService(myTank, returnScreenWidth());
				else if (e.getKeyCode() == KeyEvent.VK_SPACE)
					spaceKeyService = new SpaceKeyService(e);
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
		g.drawImage(forestBackground.getImage(), 0, 0, returnScreenWidth(), returnScreenHeight(), null);
		g.drawImage(startPlatform.getImage(), (int) calculateWidth(0.01f), (int) calculateHeight(93.5f),
				(int) calculateWidth(10), (int) calculateHeight(14.5f), null);
		g.drawImage(myTank.getTankImg(), myTank.getTankStartXposition(), myTank.getTankStartYposition(),
				myTank.getWidth(), myTank.getHeight(), null);

	}

	private void destroyTank() {
		myTank.setAlive(false);
		escKeyService = new EscKeyService(battleFrame, mainFrame, choosePlayerFrame, choosePlayerPanel, myTank);
	}

}
