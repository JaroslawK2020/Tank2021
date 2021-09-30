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
import providers.TanksListProvider;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class BattlePanel extends BasicPanel {
	private ForestBackground forestBackground;
	private WKeyService wKeyService;
	private SKeyService sKeyService;
	private AKeyService aKeyService;
	private DKeyService dKeyService;
	private SpaceKeyService spaceKeyService;
	private EscKeyService escKeyService;
	private MyFrame choosePlayerFrame;
	private int selectedTankIndex = 0; //// this has to base on Database
	private TanksListProvider tanksListProvider = new TanksListProvider();
	private MyTank myTank;
	
	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame, ChoosePlayerPanel choosePlayerPanel) {
		setLayout(null);
		forestBackground = new ForestBackground();
		ScoreCounter scoreCounter = new ScoreCounter("20", this);
		ScoreLabel scoreLabel = new ScoreLabel(this);
		ExitLabel exitLabel = new ExitLabel(this);
		myTank = new MyTank(tanksListProvider.getTanksList().get(selectedTankIndex).getImage(), 
				((int) this.calculateWidth(1)), ((int) this.calculateHeight(95)));
		
		
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
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
					escKeyService = new EscKeyService(battleFrame,mainFrame,choosePlayerFrame, choosePlayerPanel);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W)
					wKeyService = new WKeyService(myTank);
				else if (e.getKeyCode() == KeyEvent.VK_S)
					sKeyService = new SKeyService(myTank,returnScreenHeight());
				else if (e.getKeyCode() == KeyEvent.VK_A)
					aKeyService = new AKeyService(myTank);
				else if (e.getKeyCode() == KeyEvent.VK_D)
					dKeyService = new DKeyService(myTank,returnScreenWidth());
				else if (e.getKeyCode() == KeyEvent.VK_SPACE)
					spaceKeyService = new SpaceKeyService(e);
				repaint();
			}
		});
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(),returnScreenHeight());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(forestBackground.getImage(), 0, 0, returnScreenWidth(),returnScreenHeight(),null);

		g.drawImage(myTank.getTankImg(), myTank.getTankStartXposition(), myTank.getTankStartYposition(), myTank.getWidth(),myTank.getHeight(), null);
		
	}

}
