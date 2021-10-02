package components.ChoosePlayerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import images.CityMap;
import images.DesertMap;
import images.ForestMap;
import tankProject.panels.ChoosePlayerPanel;

public class ForestMapButton extends JButton {

	public ForestMapButton(ChoosePlayerPanel choosePlayerPanel, ForestMap forestMap, CityMap cityMap, DesertMap desertMap) {
		setBounds((int) choosePlayerPanel.calculateWidth(34), (int) choosePlayerPanel.calculateHeight(60),
				(int) choosePlayerPanel.calculateWidth(20), (int) choosePlayerPanel.calculateHeight(20));
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!forestMap.getIsSelected()) {
				forestMap.setIsSelected(true);
				forestMap.setHoverValue(20);
				cityMap.setHoverValue(-40);
				desertMap.setHoverValue(-40);
				choosePlayerPanel.setSelectedMap(forestMap.getIndex());
				choosePlayerPanel.repaint();
				}
				else {
					forestMap.setIsSelected(false);
					forestMap.setHoverValue(0);
					cityMap.setHoverValue(0);
					desertMap.setHoverValue(0);
					choosePlayerPanel.repaint();
				}	
			}
		});
	}

}
