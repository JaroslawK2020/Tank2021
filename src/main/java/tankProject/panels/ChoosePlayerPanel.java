package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

import components.ChoosePlayerComponents.BackButton;
import components.ChoosePlayerComponents.CityMapButton;
import components.ChoosePlayerComponents.DesertMapButton;
import components.ChoosePlayerComponents.ForestMapButton;
import components.ChoosePlayerComponents.LevelLabel;
import components.ChoosePlayerComponents.NickNameLabel;
import components.ChoosePlayerComponents.PlayersList;
import components.ChoosePlayerComponents.ScoresLabel;
import components.ChoosePlayerComponents.StartBattle;
import images.CityMap;
import images.DesertMap;
import images.ForestMap;
import providers.TanksListProvider;
import tankProject.Frame.MyFrame;

public class ChoosePlayerPanel extends BasicPanel {

	public String nickname = "";
	public BufferedImage mainImage = null;
	ForestMap forestMapImage = new ForestMap();
	CityMap cityMapImage = new CityMap();
	DesertMap desertMapImage = new DesertMap();
	public int selectedMap=0;
	int lvl;
	
	public ChoosePlayerPanel(MyFrame mainFrame, MyFrame choosePlayerFrame) {
		BackButton backtButton = new BackButton(mainFrame, choosePlayerFrame, this);
		DefaultListModel<String> model = new DefaultListModel<String>();
		NickNameLabel nickNameLabel = new NickNameLabel(this, nickname); 
		ScoresLabel scoresLabel = new ScoresLabel(this, nickname);
		LevelLabel levelLabel = new LevelLabel(this, nickname);
		TanksListProvider tanksListProvider = new TanksListProvider(this, nickname);
		lvl = this.databaseManager.getLvl("jarek123");
		StartBattle startBattle = new StartBattle(mainFrame, choosePlayerFrame, this, tanksListProvider,lvl);
		PlayersList playersList = new PlayersList(model, this, nickNameLabel, scoresLabel, levelLabel,
				tanksListProvider, startBattle);
		ForestMapButton forestMapButton = new ForestMapButton(this, forestMapImage, cityMapImage, desertMapImage);
		CityMapButton cityMapButton = new CityMapButton(this, forestMapImage, cityMapImage, desertMapImage);
		DesertMapButton desertMapButton = new DesertMapButton(this, forestMapImage, cityMapImage, desertMapImage);

		List<String> playersToDisplay = databaseManager.getPlayers();

		for (String player : playersToDisplay) {
			model.addElement(player);
		}

		add(backtButton);
		add(startBattle);
		add(nickNameLabel);
		add(scoresLabel);
		add(levelLabel);
		add(playersList);
		add(forestMapButton);
		add(cityMapButton);
		add(desertMapButton);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(super.returnScreenWidth(), super.returnScreenHeight());

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(mainImage, (int) calculateWidth(60), (int) calculateHeight(10), (int) calculateWidth(30),
				(int) calculateHeight(37), null);
		g.drawImage(forestMapImage.getImage(), (int) calculateWidth(34) - forestMapImage.getHoverValue()+5,
				(int) calculateHeight(60) + forestMapImage.getHoverValue(),
				(int) calculateWidth(20) + (forestMapImage.getHoverValue() * 2),
				(int) calculateHeight(20) + (forestMapImage.getHoverValue() * 2), null);
		g.drawImage(cityMapImage.getImage(), (int) calculateWidth(56) - cityMapImage.getHoverValue(),
				(int) calculateHeight(60) + cityMapImage.getHoverValue(),
				(int) calculateWidth(20) + (cityMapImage.getHoverValue() * 2),
				(int) calculateHeight(20) + (cityMapImage.getHoverValue() * 2), null);
		g.drawImage(desertMapImage.getImage(), (int) calculateWidth(78) - desertMapImage.getHoverValue(),
				(int) calculateHeight(60) + desertMapImage.getHoverValue(),
				(int) calculateWidth(20) + (desertMapImage.getHoverValue() * 2),
				(int) calculateHeight(20) + (desertMapImage.getHoverValue() * 2), null);
	}
	public void setSelectedMap(int index) {
		this.selectedMap= index;
	}
	public int getSelectedMap() {
		return selectedMap;
	}
	
//	public void setLV(int key){
//		this.lvl = key;
//	}
//
//	public int getLvl() {
//		return lvl;
//	}
	
	
}
