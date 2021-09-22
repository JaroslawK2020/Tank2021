package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JSlider;

public class StartPanel extends PanelSchema {
	private GameTitle gameTitle;
	private SpeakerImg speakerImg;
	private JSlider speakerSlider;
	
	public StartPanel() {
		setLayout(null);
		gameTitle = new GameTitle();
		speakerImg =  new SpeakerImg();
//		---------------speakerSlider
		speakerSlider = new JSlider(JSlider.VERTICAL);
		speakerSlider.setBounds((int)(returnScreenWidth()/1.04), (int)(returnScreenHeight()/1.19), 
				(int)(returnScreenWidth()/51.2), (int)(returnScreenHeight()/8.64));
		add(speakerSlider);

		
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(gameTitle.getImage(), 
				(int)(returnScreenWidth()/6.5), (int)(returnScreenHeight()/11.5), (int)(returnScreenWidth()/1.5),(int)(returnScreenHeight()/6), null);
		g.drawImage(speakerImg.getImage(), 
				(int)(returnScreenWidth()/1.08), (int)(returnScreenHeight()/1.14), (int)(returnScreenWidth()/30.7), (int)(returnScreenHeight()/21.6), null);
		
		
	}

	@Override
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}
