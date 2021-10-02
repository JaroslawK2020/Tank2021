package tankProject;

import java.awt.EventQueue;

import javax.swing.JPanel;

import appRunner.AppRunner;

public class Main {

	public static void main(String[] args) {
		

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new AppRunner();
				
			}
		});
		
	}
}
