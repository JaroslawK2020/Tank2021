package components;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.sound.sampled.*;

public class SoundPlayer {
	private void playAudio(String filePath, Clip clip) {
		try {
			AudioInputStream audioInputStreamLaucher = AudioSystem
					.getAudioInputStream(new File(filePath).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStreamLaucher);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();

	}

	private void stopSound(Clip clip) {
		clip.close();
		clip.stop();
	}

//	--------------------laucher music
	private Clip laucherClip;

	public void startLaucherMusic() {
		final String filePath = "src//sounds//launcherMusic.wav";

		playAudio(filePath, laucherClip);
	}

	public void stopLaucherMusic() {
		stopSound(laucherClip);
	}

	//	-----------------------battle music
	private Clip battleClip;

	public void startBattleMusic() {
		final String filePath = "src//sounds//battleSound.wav";
		playAudio(filePath, battleClip);
	}

	public void stopBattleMusic() {
		stopSound(battleClip);
	}

//	===============================
//	======================TANK
//	-------------tank move
	private Clip tankMoveClip;

	public void startTankMoveSound() {
		final String filePath = "src//sounds//tankSound.wav";
		playAudio(filePath, tankMoveClip);
	}

	public void stopTankMoveSound() {
		stopSound(tankMoveClip);
	}

//	----------------------
	private Clip tankShotClip;

	public void startTankShotSound() {
		final String filePath = "src//sounds//tankShot.wav";
		playAudio(filePath, tankShotClip);
	}

	public void stopTankShotSound() {
		stopSound(tankShotClip);
	}

//	================canon
	private Clip canonShotClip;

	public void startCanonShotSound() {
		final String filePath = "src//sounds//canonShot.wav";
		playAudio(filePath, canonShotClip);
	}

	public void stopCanonShotSound() {
		stopSound(canonShotClip);
	}

}
