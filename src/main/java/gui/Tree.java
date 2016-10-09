package gui;

import java.util.Random;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.RGB;

public class Tree {
	private char mTree;
	TerminalPosition mPosition;
	RGB color; 
	private static RGB treeColor1 = new TextColor.RGB(17, 124, 60);
	private static RGB treeColor2 = new TextColor.RGB(21, 163, 78);
	private static RGB treeColor3 = new TextColor.RGB(7, 109, 48);
	
	private static RGB[] treeColors = {treeColor1, treeColor2, treeColor3};
	RGB rubColor1 = new TextColor.RGB(165, 170, 60);
	
	Random mRand;
	
	
	public Tree(char mTree, TerminalPosition mPosition, RGB color) {
		super();
		this.mTree = mTree;
		this.mPosition = mPosition;
		this.color = color;
	}



	public static Tree factoryRandomTree(int maxCol, int maxLine){
		Random mRand = new Random();
		
		return new Tree(SymbolsMirk.TREES[mRand.nextInt(SymbolsMirk.TREES.length)], 
				new TerminalPosition(mRand.nextInt(maxCol), mRand.nextInt(maxLine)),	
			treeColors[mRand.nextInt(treeColors.length)]);
		
	}
	
	public static Tree factoryRandomBranch(int maxCol, int maxLine){
		Random mRand = new Random();
		
		return new Tree(SymbolsMirk.SMALLTREES[mRand.nextInt(SymbolsMirk.TREES.length)], 
				new TerminalPosition(mRand.nextInt(maxCol), mRand.nextInt(maxLine)),	
				new TextColor.RGB(170 + mRand.nextInt(25) - 25, 130, 70));
		
	}



	public char getmTree() {
		return mTree;
	}



	public void setmTree(char mTree) {
		this.mTree = mTree;
	}



	public TerminalPosition getmPosition() {
		return mPosition;
	}



	public void setmPosition(TerminalPosition mPosition) {
		this.mPosition = mPosition;
	}



	public RGB getColor() {
		return color;
	}



	public void setColor(RGB color) {
		this.color = color;
	}
	
	
}
