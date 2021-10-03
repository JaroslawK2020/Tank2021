package providers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import images.IDestroyable;
import images.MineImg;

public class MinesProvider {
	private List<IDestroyable> minesList = new ArrayList<IDestroyable>();
	private int fromRange = 3;
	private int toRange = 5;

	public MinesProvider(int lvl) {

		for (int i = 0; i < (int) ((Math.random() * ((toRange + lvl) - (fromRange + lvl)) + (fromRange + lvl))); i++)
			minesList.add(new MineImg());
	}

	public List<IDestroyable> getMinesList() {
		return minesList;
	}

	private void madnessLVL() {
		this.fromRange = 30;
		this.toRange = 40;
	}
}




