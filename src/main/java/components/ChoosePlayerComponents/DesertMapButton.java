package components.ChoosePlayerComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import images.CityMap;
import images.DesertMap;
import images.ForestMap;
import tankProject.panels.ChoosePlayerPanel;

public class DesertMapButton extends JButton {

	public DesertMapButton(ChoosePlayerPanel choosePlayerPanel, ForestMap forestMap, CityMap cityMap, DesertMap desertMap) {
		setBounds((int) choosePlayerPanel.calculateWidth(78), (int) choosePlayerPanel.calculateHeight(60),
				(int) choosePlayerPanel.calculateWidth(20), (int) choosePlayerPanel.calculateHeight(20));
		setBorder(null);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!desertMap.getIsSelected()) {
					desertMap.setIsSelected(true);
					desertMap.setHoverValue(20);
					forestMap.setHoverValue(-40);
					cityMap.setHoverValue(-40);
					choosePlayerPanel.setSelectedMap(desertMap.getIndex());
					System.out.println("DesertMapButton"+desertMap.getIndex());
					System.out.println("DesertMapButton"+choosePlayerPanel.selectedMap);
					choosePlayerPanel.repaint();
				}
				else {
					desertMap.setIsSelected(false);
					desertMap.setHoverValue(0);
					cityMap.setHoverValue(0);
					forestMap.setHoverValue(0);
					choosePlayerPanel.repaint();
				}
					
			}
		});
	}
}