package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.MyButton;
import components.SoundPlayer;
import components.StartPanelComponents.ChoosePlayerButton;
import components.StartPanelComponents.NewPlayerButton;
import components.StartPanelComponents.QuitButton;
import images.Background;
import images.GameTitle;
import images.SpeakerImg;
import strings.EStrings;
import tankProject.Frame.MyFrame;

public class StartPanel extends PanelSchema {
//	-----------my window size: Width:1536 Height: 864
	private GameTitle gameTitle;
	private SpeakerImg speakerImg;
	private Background backgroundImg;
	private MySoundPlayer soundPlayer;

	public StartPanel(MyFrame mainFrame) {
		soundPlayer = new MySoundPlayer();
		gameTitle = new GameTitle();
		backgroundImg = new Background();
		speakerImg = new SpeakerImg();

		NewPlayerButton newPlayerButton = new NewPlayerButton(EStrings.CREATE_PLAYER.text, mainFrame, this);
		ChoosePlayerButton choosePlayerButton = new ChoosePlayerButton(EStrings.CHOOSE_PLAYER.text, mainFrame, this);
		QuitButton quitButton = new QuitButton(EStrings.QUIT.text, mainFrame, this);
		
		add(newPlayerButton);
		add(choosePlayerButton);
		add(quitButton);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(backgroundImg.getImage(), 0, 0, returnScreenWidth(), returnScreenHeight(), null);
		g.drawImage(gameTitle.getImage(), (int) calculateWidth(15), (int) calculateHeight(15),
				(int) calculateWidth(70), (int) calculateHeight(20), null);
		g.drawImage(speakerImg.getImage(), (int) calculateWidth(95), (int) calculateHeight(90),
				(int) calculateWidth(5), (int) calculateHeight(6), null);
	}

	@Override
	public Dimension getPreferredSize() {
		return super.getPreferredSize();
	}
	
	// we should decide whether this is a good place for keeping this
	class MySoundPlayer extends SoundPlayer {

		public MySoundPlayer() {
		 //startLaucherMusic();
		}
	}
}
