package providers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import images.IDestroyable;
import images.MineImg;

public class MinesProvider {
	private List<IDestroyable> minesList = new ArrayList<IDestroyable>();
	private int fromRange = 1;
	private int toRange = 2;

	public MinesProvider(int lvl) {

		for (int i = 0; i < (int) ((Math.random() * ((toRange + lvl) - (fromRange + lvl)) + (fromRange + lvl))); i++)
			minesList.add(new MineImg());
	}

	public List<IDestroyable> getMinesList() {
		return minesList;
	}

}




