package appRunner;

import javax.swing.JPanel;

import tankProject.Frame.MyFrame;
import tankProject.panels.StartPanel;


public class AppRunner {

	public AppRunner() {
		MyFrame myFrame = new MyFrame();
		StartPanel startPanel = new StartPanel(myFrame);
		myFrame.add(startPanel);
		myFrame.settupFrame();
	}
}
