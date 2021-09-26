package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		add(new NewPlayerButton(EStrings.CREATE_PLAYER.text, mainFrame));
		add(new ChoosePlayerButton(EStrings.CHOOSE_PLAYER.text, mainFrame));
		add(new QuitButton(EStrings.QUITE.text, mainFrame, this));
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

		public NewPlayerButton(String text, MyFrame mainFrame) {
			super(text);
			setBounds(returnScreenWidth() / 10, returnScreenHeight() / 3, super.getWidth(), super.getHeight());

			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					MyFrame createNewPlayerFrame = new MyFrame();
					CreateNewPlayerPanel createNewPlayerPanel = new CreateNewPlayerPanel(mainFrame, createNewPlayerFrame);
					mainFrame.setVisible(false);

					createNewPlayerFrame.setUndecorated(true);
					createNewPlayerFrame.add(createNewPlayerPanel);
					createNewPlayerFrame.setVisible(true);
					createNewPlayerFrame.pack();
					createNewPlayerFrame.setLocationRelativeTo(null);

				}
			});
		}
	}

	class ChoosePlayerButton extends MyButton {

		public ChoosePlayerButton(String text, MyFrame mainFrame) {
			super(text);
			setBounds((int) (returnScreenWidth() / 1.3), returnScreenHeight() / 3, super.getWidth(), super.getHeight());
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					MyFrame choosePlayerFrame = new MyFrame();
					ChoosePlayerPanel choosePlayerPanel = new ChoosePlayerPanel(mainFrame, choosePlayerFrame);
					mainFrame.setVisible(false);

					choosePlayerFrame.setUndecorated(true);
					choosePlayerFrame.add(choosePlayerPanel);
					choosePlayerFrame.setVisible(true);
					choosePlayerFrame.pack();
					choosePlayerFrame.setLocationRelativeTo(null);

				}
			});
		}
	}

	class QuitButton extends MyButton {

		public QuitButton(String text, MyFrame mainFrame, StartPanel startPanel) {
			super(text);
			setBounds((int) (returnScreenWidth() / 30.7), (int) (returnScreenHeight() / 1.2), super.getWidth(),
					super.getHeight());
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					launchExitPanel(mainFrame, startPanel);
				};
			});
		}

		private void launchExitPanel(MyFrame mainFrame, StartPanel startPanel) {
			MyFrame exitFrame = new MyFrame();
			ExitPanel exitPanel = new ExitPanel(exitFrame, mainFrame);

			exitFrame.setUndecorated(true);
			exitFrame.add(exitPanel);
			mainFrame.setEnabled(false);
			exitFrame.setVisible(true);
			exitFrame.pack();
			exitFrame.setLocationRelativeTo(null);
		}
	}

	class MySoundPlayer extends SoundPlayer {

		public MySoundPlayer() {
			try {
				startLaucherMusic();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
