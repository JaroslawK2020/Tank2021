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

import images.Background;
import images.SpeakerImg;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class StartPanel extends PanelSchema {
//	-----------my window size: Width:1536 Height: 864
	private GameTitle gameTitle;
	private SpeakerImg speakerImg;
	private MyButton quitButton;
	private Background backgroundImg;
	private MySoundPlayer soundPlayer;
	
	public StartPanel(MyFrame mainFrame) {
		setLayout(null);
		soundPlayer = new MySoundPlayer();
		gameTitle = new GameTitle();
		backgroundImg = new Background();
		speakerImg = new SpeakerImg();

		add(new NewPlayerButton(EStrings.CREATE_PLAYER.text));
		add(new ChoosePlayerButton(EStrings.CHOOSE_PLAYER.text));
		add(new QuitButton(EStrings.QUITE.text, mainFrame));




	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(backgroundImg.getImage(), 0, 0, returnScreenWidth(), returnScreenHeight(), null);
		g.drawImage(gameTitle.getImage(), (int) (returnScreenWidth() / 6.5), (int) (returnScreenHeight() / 11.5),
				(int) (returnScreenWidth() / 1.5), (int) (returnScreenHeight() / 6), null);
		g.drawImage(speakerImg.getImage(), (int) (returnScreenWidth() / 1.08), (int) (returnScreenHeight() / 1.14),
				(int) (returnScreenWidth() / 30.7), (int) (returnScreenHeight() / 21.6), null);
	}

	@Override
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}

	class NewPlayerButton extends MyButton {

		public NewPlayerButton(String text) {
			super(text);
			setBounds(returnScreenWidth() / 10,
					returnScreenHeight() / 3,
					super.getWidth(), super.getHeight());
		}
	}

	class ChoosePlayerButton extends MyButton {

		public ChoosePlayerButton(String text) {
			super(text);
			setBounds((int)(returnScreenWidth() / 1.3),
					returnScreenHeight() / 3,
					super.getWidth(), super.getHeight());
		}
	}
	
	class QuitButton extends MyButton {

		public QuitButton(String text, MyFrame mainFrame) {
			super(text);
			setBounds((int) (returnScreenWidth() / 30.7), (int) (returnScreenHeight() / 1.2),
					super.getWidth(), super.getHeight());
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					MyFrame exitFrame = new MyFrame();
					ExitPanel exitPanel = new ExitPanel(exitFrame, mainFrame, quitButton);

					setEnabled(false);
					exitFrame.add(exitPanel);
					exitFrame.setUndecorated(true);
					exitFrame.setVisible(true);
					exitFrame.pack();
					exitFrame.setLocationRelativeTo(null);
					exitFrame.isActive();
				};
			});
		}
	}
	
	class MySoundPlayer extends SoundPlayer{
		
		public MySoundPlayer() {
			try {
				audioPlayera();
				play();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
