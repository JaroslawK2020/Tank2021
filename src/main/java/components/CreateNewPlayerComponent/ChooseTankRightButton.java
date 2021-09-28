package components.CreateNewPlayerComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import tankProject.panels.CreateNewPlayerPanel;

public class ChooseTankRightButton extends JButton {
	
	private int width = 225;
	private int height = 225;
	
	public ChooseTankRightButton(CreateNewPlayerPanel createNewPlayerPanel) {
		setBounds((int) createNewPlayerPanel.calculateWidth(80), (int) createNewPlayerPanel.calculateHeight(54),
				width, height);
		setIcon(new ArrowR());
		setPressedIcon(new ArrowR_Pressed());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (createNewPlayerPanel.selectedTankIndex < createNewPlayerPanel.tanksListProvider.getTanksList()
						.size() - 1) {
					createNewPlayerPanel.selectedTankIndex++;
					createNewPlayerPanel.repaint();

				} else {
					createNewPlayerPanel.selectedTankIndex = 0;
					createNewPlayerPanel.repaint();
				}
			}
		});
	}
}