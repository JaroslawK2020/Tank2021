package providers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import images.IDestroyable;
import images.MineImg;

public class MinesProvider {
	private List<IDestroyable> minesList = new ArrayList<IDestroyable>();
	private int fromRange;
	private int toRange;
	
	public MinesProvider(int lvl) {
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
			minesList.add(new MineImg());	
	}

	public List<IDestroyable> getMinesList() {
		return minesList;
	}
	
	private void easyLVL() {
		this.fromRange = 1;
		this.toRange = 5;
	}
	
	
	private void mediumLVL() {
		this.fromRange = 5;
		this.toRange = 10;
	}
	
	private void hardLVL() {
		this.fromRange = 10;
		this.toRange = 20;
	}
	
	private void expertLVL() {
		this.fromRange = 20;
		this.toRange = 30;
	}
	
	private void madnessLVL() {
		this.fromRange = 30;
		this.toRange = 40;
	}	
}
