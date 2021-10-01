package tankProject.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import components.CreateNewPlayerComponent.BackButton;
import components.CreateNewPlayerComponent.ChooseTankLeftButton;
import components.CreateNewPlayerComponent.ChooseTankRightButton;
import components.CreateNewPlayerComponent.CreateButton;
import components.CreateNewPlayerComponent.NickNameLabel;
import components.CreateNewPlayerComponent.NickNameTextField;
import components.CreateNewPlayerComponent.Tittle;
import providers.TanksListProvider;
import tankProject.Frame.MyFrame;

public class CreateNewPlayerPanel extends BasicPanel {

	public TanksListProvider tanksListProvider = new TanksListProvider(this, null);
	public int selectedTankIndex = 0;

	public CreateNewPlayerPanel(MyFrame mainFrame, MyFrame createNewPlayerFrame) {

		NickNameTextField nickNameTextField = new NickNameTextField(this);
		NickNameLabel nickNameLabel = new NickNameLabel(this);
		Tittle tittle = new Tittle(this);
		CreateButton createButton = new CreateButton(createNewPlayerFrame, mainFrame, nickNameTextField, nickNameLabel, this);
		BackButton backButton = new BackButton(mainFrame, createNewPlayerFrame, this);
		ChooseTankLeftButton chooseTankLeftButton = new ChooseTankLeftButton(this, tanksListProvider);
		ChooseTankRightButton chooseTankRightButton = new ChooseTankRightButton(this);
		
		
		add(tittle);
		add(nickNameLabel);
		add(nickNameTextField);
		add(createButton);
		add(backButton);
		add(chooseTankLeftButton);
		add(chooseTankRightButton);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(returnScreenWidth(), returnScreenHeight());

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage mainImage = tanksListProvider.getTanksList().get(selectedTankIndex).getImage();

		g.drawImage(mainImage, (int) calculateWidth(38), (int) calculateHeight(50), 
				(int) calculateWidth(30),(int) calculateHeight(37), null);

	}
}

	