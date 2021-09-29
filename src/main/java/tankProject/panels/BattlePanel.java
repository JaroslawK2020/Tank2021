package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import components.BattlePanel.BattlePanelTextEditor;
import components.BattlePanel.ExitLabel;
import components.BattlePanel.ScoreCounter;
import components.BattlePanel.ScoreLabel;
import components.BattlePanel.WKeyService;
import images.ForestBackground;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class BattlePanel extends BasicPanel {
	private ForestBackground forestBackground;
	private WKeyService wKeyService;
	
	public BattlePanel(MyFrame battleFrame) {
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
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W)
					wKeyService = new WKeyService(e);
				
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
