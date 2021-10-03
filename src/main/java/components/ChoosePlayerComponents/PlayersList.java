package components.ChoosePlayerComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultListModel;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import providers.TanksListProvider;
import tankProject.panels.ChoosePlayerPanel;

public class PlayersList extends JList {

	private Font fontFamily = new Font("Arial", Font.BOLD, 30);

	public PlayersList(ListModel dataModel, ChoosePlayerPanel choosePlayerPanel, NickNameLabel nickNameLabel,
			ScoresLabel scoresLabel, LevelLabel levelLabel, TanksListProvider tanksListProvider,
			StartBattle startBattle) {
		super(dataModel);
		setBounds((int) choosePlayerPanel.calculateWidth(3), (int) choosePlayerPanel.calculateHeight(5),
				(int) choosePlayerPanel.calculateWidth(30), (int) choosePlayerPanel.calculateHeight(80));
		setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		setFont(fontFamily);
		setForeground(Color.WHITE);
		addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				startBattle.setEnabled(true);
				nickNameLabel.chooseNickname((String) getSelectedValue());
				scoresLabel.chooseScores(choosePlayerPanel, (String) getSelectedValue());
				levelLabel.chooseLvl(choosePlayerPanel, (String) getSelectedValue());
				choosePlayerPanel.mainImage = tanksListProvider.getTankByUser(choosePlayerPanel,
						(String) getSelectedValue());
				choosePlayerPanel.setLV(choosePlayerPanel.databaseManager.getLvl((String) getSelectedValue()));
				startBattle.setNickname((String) getSelectedValue());
				choosePlayerPanel.repaint();
			}
		});
	}

}
