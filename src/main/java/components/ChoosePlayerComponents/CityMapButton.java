package components.ChoosePlayerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import images.CityMap;
import images.DesertMap;
import images.ForestMap;
import tankProject.panels.ChoosePlayerPanel;

public class CityMapButton extends JButton {

	public CityMapButton(ChoosePlayerPanel choosePlayerPanel, ForestMap forestMap, CityMap cityMap,
			DesertMap desertMap) {
		setBounds((int) choosePlayerPanel.calculateWidth(56), (int) choosePlayerPanel.calculateHeight(60),
				(int) choosePlayerPanel.calculateWidth(20), (int) choosePlayerPanel.calculateHeight(20));
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!cityMap.getIsSelected()) {
					cityMap.setIsSelected(true);
					cityMap.setHoverValue(20);
					forestMap.setHoverValue(-40);
					desertMap.setHoverValue(-40);
					choosePlayerPanel.setSelectedMap(cityMap.getIndex());
					choosePlayerPanel.repaint();
				} else {
					cityMap.setIsSelected(false);
					cityMap.setHoverValue(0);
					forestMap.setHoverValue(0);
					desertMap.setHoverValue(0);
					choosePlayerPanel.repaint();
				}

			}
		});
	}
}
