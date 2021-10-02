package providers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import images.IDestroyable;
import images.MineImg;

public class MinesProvider {
	private List<IDestroyable> minesList = new ArrayList<IDestroyable>();

	public MinesProvider() {
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
		minesList.add(new MineImg());
	}

	public List<IDestroyable> getMinesList() {
		return minesList;
	}
}
