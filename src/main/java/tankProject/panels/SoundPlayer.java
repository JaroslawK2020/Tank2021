package tankProject.panels;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;


public class SoundPlayer {
	private final String laucherMusic = "C:\\Users\\Jarcy\\Desktop\\SDA Eclipse\\TankProject\\TankGameProject\\startMusic.wav";
	private Clip clip;
	private AudioInputStream audioInputStream;
	
	public void audioPlayera() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioInputStream = AudioSystem.getAudioInputStream(new File(laucherMusic).getAbsoluteFile());
		
		clip = AudioSystem.getClip();
		
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void play() {
		clip.start();
	}

}
