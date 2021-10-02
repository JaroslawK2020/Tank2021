package providers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import images.IDestroyable;
import images.ReactorImg;

public class ReactorsProvider {

	private List<IDestroyable> reactorsList = new ArrayList<IDestroyable>();

	public ReactorsProvider() {
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());
		reactorsList.add(new ReactorImg());

	}

	public List<IDestroyable> getReactorsList() {
		return reactorsList;
	}
	
	private int returnScreenWidth() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getWidth();
	}

	private int returnScreenHeight() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) size.getHeight();
	}
	
	public int drawDestroyableObjectPositionX() {
		final int LOWER_RANGE = 20;
		final int UPPER_RANGE = returnScreenWidth() - 200;
		int drawNum = (int)(Math.random() * (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE);
		if(drawNum % 100 == 0)
			return drawNum;
		else 
			drawDestroyableObjectPositionX();
		return drawNum;
	}

}
