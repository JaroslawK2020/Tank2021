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
				myFrame.setTitle("Tank 2021");
				myFrame.setVisible(true);
				myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
				myFrame.setResizable(false);
				myFrame.pack();
				myFrame.setLocationRelativeTo(null);
			}
		});

	}

}
