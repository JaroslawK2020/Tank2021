package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import components.BattlePanel.AKeyService;
import components.BattlePanel.BattlePanelTextEditor;
import components.BattlePanel.DKeyService;
import components.BattlePanel.EscKeyService;
import components.BattlePanel.ExitLabel;
import components.BattlePanel.SKeyService;
import components.BattlePanel.ScoreCounter;
import components.BattlePanel.ScoreLabel;
import components.BattlePanel.SpaceKeyService;
import components.BattlePanel.WKeyService;
import images.ForestBackground;
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
	
	public BattlePanel(MyFrame battleFrame, MyFrame mainFrame, MyFrame choosePlayerFrame) {
		setLayout(null);
		forestBackground = new ForestBackground();
		ScoreCounter scoreCounter = new ScoreCounter("20", this);
		ScoreLabel scoreLabel = new ScoreLabel(this);
		ExitLabel exitLabel = new ExitLabel(this);
		
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
					escKeyService = new EscKeyService(battleFrame,mainFrame,choosePlayerFrame);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W)
					wKeyService = new WKeyService(e);
				else if (e.getKeyCode() == KeyEvent.VK_S)
					sKeyService = new SKeyService(e);
				else if (e.getKeyCode() == KeyEvent.VK_A)
					aKeyService = new AKeyService(e);
				else if (e.getKeyCode() == KeyEvent.VK_D)
					dKeyService = new DKeyService(e);
				else if (e.getKeyCode() == KeyEvent.VK_SPACE)
					spaceKeyService = new SpaceKeyService(e);
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
		
	}

}
