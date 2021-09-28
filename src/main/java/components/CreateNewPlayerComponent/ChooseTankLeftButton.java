package components.CreateNewPlayerComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import providers.TanksListProvider;
import tankProject.panels.CreateNewPlayerPanel;

public class ChooseTankLeftButton extends JButton {
	
	private int width = 225;
	private int height = 225;

	public ChooseTankLeftButton(CreateNewPlayerPanel createNewPlayerPanel, TanksListProvider tanksListProvider) {
		setBounds((int) createNewPlayerPanel.calculateWidth(10), (int) createNewPlayerPanel.calculateHeight(54),
				width, height);
		setIcon(new ArrowL());
		setPressedIcon(new ArrowL_Pressed());
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (createNewPlayerPanel.selectedTankIndex > 0) {
					createNewPlayerPanel.selectedTankIndex--;
					createNewPlayerPanel.repaint();
				} else {
					createNewPlayerPanel.selectedTankIndex = createNewPlayerPanel.tanksListProvider.getTanksList()
							.size() - 1;
					createNewPlayerPanel.repaint();
				}
			}
		});
	}
}