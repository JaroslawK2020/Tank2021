package tankProject.panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class StartPanel extends PanelSchema {
//	-----------my window size: Width:1536 Height: 864
	private GameTitle gameTitle;
	private SpeakerImg speakerImg;
	private JSlider speakerSlider;
	private MyButton quitButton;
	private JDialog exitDialog;
	private Background backgroundImg;
	private SoundPlayer soundPlayer;
	
	public StartPanel(JFrame mainFrame) {
		setLayout(null);
		gameTitle = new GameTitle();
		speakerImg =  new SpeakerImg();
		backgroundImg = new Background();
//		---------------speakerSlider
		speakerSlider = new JSlider(JSlider.VERTICAL);
		speakerSlider.setBounds((int)(returnScreenWidth()/1.04), (int)(returnScreenHeight()/1.19), 
				(int)(returnScreenWidth()/51.2), (int)(returnScreenHeight()/8.64));
		speakerSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(speakerSlider.getValue());
			}
		});
		
		add(speakerSlider);
//		---------------quitButton
		quitButton = new MyButton(500, 500);
		quitButton.setBounds((int)(returnScreenWidth()/30.7), (int)(returnScreenHeight()/1.15), 
				(int)(returnScreenWidth()/15.64), (int)(returnScreenHeight()/17.3));
		quitButton.setText("QUIT");
		quitButton.setFont(new Font("Arial", Font.BOLD, 25));
		
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				-----------dialog frame
				JFrame exitFrame =  new JFrame();	
//				------------dialog yesButton
				JButton yesButton = new JButton("YES");
				yesButton.setBounds(60,100,80,30);
				yesButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mainFrame.dispose();
						exitFrame.dispose();
					}
				});
//				-----------dialog noButton
				JButton noButton = new JButton("NO");
				noButton.setBounds(250,100,80,30);
				noButton.addActionListener(new ActionListener() {	
					@Override
					public void actionPerformed(ActionEvent e) {
						exitFrame.dispose();
					}
				});
//				------------exitLabel
				JLabel exitLabel = new JLabel("Do you really want to quit?");
				exitLabel.setFont(new Font("Arial",Font.BOLD,20));
				exitLabel.setBounds(60,20,400,50);
//				--------quit dialog
				exitDialog = new JDialog(exitFrame,"Quit");
				exitDialog.setLayout(null);
				exitDialog.setBounds((int)(returnScreenWidth()/2.8), (int)(returnScreenHeight()/2.16), 
						(int)(returnScreenWidth()/3.8), (int)(returnScreenHeight()/4.32));
				exitDialog.setVisible(true);
				exitDialog.add(exitLabel);
				exitDialog.add(yesButton);
				exitDialog.add(noButton);
			}
		});
		add(quitButton);
//		--------------music play
		soundPlayer = new SoundPlayer();
		try {
			soundPlayer.audioPlayera();
			soundPlayer.play();
		}catch(Exception e) {
			e.getMessage();
		}
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(backgroundImg.getImage(), 0, 0, returnScreenWidth(), returnScreenHeight(),null);
		g.drawImage(gameTitle.getImage(), (int)(returnScreenWidth()/6.5), (int)(returnScreenHeight()/11.5), 
				(int)(returnScreenWidth()/1.5),(int)(returnScreenHeight()/6), null);
		g.drawImage(speakerImg.getImage(), (int)(returnScreenWidth()/1.08), (int)(returnScreenHeight()/1.14), 
				(int)(returnScreenWidth()/30.7), (int)(returnScreenHeight()/21.6), null);
	}

	@Override
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
}
