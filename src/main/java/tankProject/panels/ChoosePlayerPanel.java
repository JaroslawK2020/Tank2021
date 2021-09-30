package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import components.ChoosePlayerComponents.BackButton;
import components.ChoosePlayerComponents.LevelLabel;
import components.ChoosePlayerComponents.NickNameLabel;
import components.ChoosePlayerComponents.PlayersList;
import components.ChoosePlayerComponents.ScoresLabel;
import components.ChoosePlayerComponents.StartBattle;
import images.CityMap;
import images.DesertMap;
import images.ForestBackground;
import images.ForestMap;
import providers.TanksListProvider;
import tankProject.Frame.MyFrame;

public class ChoosePlayerPanel extends BasicPanel {
	
	public TanksListProvider tanksListProvider = new TanksListProvider();
	public int selectedTankIndex = 0; // this has to base on Database
	public String nickname= "";
	int index = 1;

	public ChoosePlayerPanel(MyFrame mainFrame, MyFrame ChoosePlayerFrame) {
		BackButton backtButton = new BackButton(mainFrame, ChoosePlayerFrame, this);
		StartBattle startBattle = new StartBattle(mainFrame, ChoosePlayerFrame, this);
		DefaultListModel<String> model = new DefaultListModel<String>();
		NickNameLabel nickNameLabel = new NickNameLabel(this, nickname); // this nickname has to be delivered from JList
		ScoresLabel scoresLabel = new ScoresLabel(this, nickname); // this nickname has to be delivered from JList
		LevelLabel levelLabel = new LevelLabel(this, nickname);
		PlayersList playersList = new PlayersList(model, this, nickNameLabel, scoresLabel, levelLabel);
		List<String> playersToDisplay = databaseManager.getPlayers();  
	
		for(String player: playersToDisplay) {
			model.addElement(player);	
		}

		add(backtButton);
		add(startBattle);
		add(nickNameLabel);
		add(scoresLabel);
		add(levelLabel);
		add(playersList);
		//playersList.value
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth(), super.returnScreenHeight());

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(nickname!="")index =  databaseManager.getUserTank(nickname); 
		BufferedImage mainImage = tanksListProvider.getTanksList().get(index).getImage();
		ForestMap forestMap = new ForestMap();	
		
		g.drawImage(mainImage, (int) calculateWidth(60), (int) calculateHeight(10), 
				(int) calculateWidth(30),(int) calculateHeight(37), null);
		
		g.drawImage(forestMap.getImage(), (int) calculateWidth(34), (int) calculateHeight(60), 
				(int) calculateWidth(20),(int) calculateHeight(20), null);
		g.drawImage(new DesertMap().getImage(), (int) calculateWidth(56), (int) calculateHeight(60), 
				(int) calculateWidth(20),(int) calculateHeight(20), null);
		g.drawImage(new CityMap().getImage(), (int) calculateWidth(78), (int) calculateHeight(60), 
				(int) calculateWidth(20),(int) calculateHeight(20), null);
		
	}
}
