package tankProject;

import java.awt.EventQueue;

import tankProject.Frame.MyFrame;
import tankProject.panels.StartPanel;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MyFrame myFrame = new MyFrame();
				StartPanel startPanel = new StartPanel(myFrame);
				
				myFrame.add(startPanel);
				myFrame.setUndecorated(true);
				myFrame.setVisible(true);
				myFrame.pack();
				myFrame.setLocationRelativeTo(null);
			}
		});
	}
}
