package providers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import images.IDestroyable;
import images.MineImg;
import images.ReactorImg;

public class ReactorsProvider {
	private int fromRange;
	private int toRange;

	private List<IDestroyable> reactorsList = new ArrayList<IDestroyable>();


	public ReactorsProvider(int lvl) {
		if(lvl == 1)
			easyLVL();
		else if(lvl == 2)
			mediumLVL();
		else if(lvl == 3)
			hardLVL();
		else if(lvl == 4)
			expertLVL();
		else if(lvl == 5)
			madnessLVL();
		for(int i = 0; i < (int)((Math.random() * (toRange - fromRange) + fromRange)); i++) 
			reactorsList.add(new ReactorImg());	

	}

	public List<IDestroyable> getReactorsList() {
		return reactorsList;
	}
	
	private void easyLVL() {
		this.fromRange = 1;
		this.toRange = 3;
	}
	
	
	private void mediumLVL() {
		this.fromRange = 3;
		this.toRange = 6;
	}
	
	private void hardLVL() {
		this.fromRange = 6;
		this.toRange = 9;
	}
	
	private void expertLVL() {
		this.fromRange = 9;
		this.toRange = 12;
	}
	
	private void madnessLVL() {
		this.fromRange = 12;
		this.toRange = 15;
	}
	
}
