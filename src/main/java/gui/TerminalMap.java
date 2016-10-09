package gui;

import java.util.EnumSet;
import java.util.Random;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.RGB;
import com.googlecode.lanterna.gui2.ComponentRenderer;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextGUIGraphics;

public class TerminalMap extends Panel {

	public static final int COLUMNS = 60;
	public static final int LINES = 20;
	
	public static final int TREECOUNT = 400;
	public static final int BRANCHESCOUNT = 100;
	
	Random mRand;
	
	int[] playerpos = new int[]{2, 2};
	
	int[] waterpos = new int[LINES];
	Tree[] treespos = new Tree[TREECOUNT];
	Tree[] branchespos = new Tree[BRANCHESCOUNT];
	RGB bkgColor = new TextColor.RGB(165, 127, 61);
	
	

	EmptySpace land;

	public TerminalMap() {
		super();

		getBasePane();
		
		mRand = new Random();
		
		generateWater();
		generateTrees();

		land = new EmptySpace(new TextColor.RGB(165, 127, 61)) {
			protected ComponentRenderer<EmptySpace> createDefaultRenderer() {
				return new ComponentRenderer<EmptySpace>() {
					public TerminalSize getPreferredSize(EmptySpace component) {
						return new TerminalSize(PanelMap.COLUMNS, PanelMap.LINES);
					}

					public void drawComponent(TextGUIGraphics graphics, EmptySpace component) {
						/*
						 * Fill background
						 */
						graphics.setBackgroundColor(bkgColor);
						graphics.setModifiers(EnumSet.of(SGR.BOLD));
						graphics.fill(' ');
						
						/*
						 * Creates the trees and branches
						 */
						for (Tree t : treespos) {
							graphics.setForegroundColor(t.getColor());
							graphics.putString(t.getmPosition().getColumn(), t.getmPosition().getRow(), String.valueOf(t.getmTree()));
						}
						for (Tree t : branchespos) {
							graphics.setForegroundColor(t.getColor());
							graphics.putString(t.getmPosition().getColumn(), t.getmPosition().getRow(), String.valueOf(t.getmTree()));
						}
						
						/*
						 * Creates the river
						 */
						graphics.setForegroundColor(new TextColor.RGB(30, 150, 200));
						for (int i = 0; i < waterpos.length; i++) {
							graphics.setBackgroundColor(new TextColor.RGB(30, 150, 100));
							graphics.putString(waterpos[i], i, String.valueOf(SymbolsMirk.WATER[2]));
							graphics.setBackgroundColor(bkgColor);
							graphics.putString(waterpos[i]-1, i, String.valueOf(SymbolsMirk.WATER[1]));
							graphics.putString(waterpos[i]+1, i, String.valueOf(SymbolsMirk.WATER[1]));
							graphics.putString(waterpos[i]-2, i, String.valueOf(SymbolsMirk.WATER[0]));
							graphics.putString(waterpos[i]+2, i, String.valueOf(SymbolsMirk.WATER[0]));
						}
						
						graphics.setBackgroundColor(new TextColor.RGB(255, 255, 255));
						graphics.setForegroundColor(new TextColor.RGB(20, 20, 150));
						graphics.setCharacter(new TerminalPosition(playerpos[0], playerpos[1]), SymbolsMirk.HERO);
					}
				};
			}
		};

		addComponent(land);

	}
	
	public void generateWater() {
		int col = mRand.nextInt(COLUMNS);
		for (int i = 0; i < LINES; i++) {
			waterpos[i] = col + (mRand.nextInt(2) - 1);
		}
	}
	
	public void generateTrees() {
		for (int i=0; i < TREECOUNT; i++)
			treespos[i] = Tree.factoryRandomTree(COLUMNS, LINES);

		for (int i=0; i < BRANCHESCOUNT; i++)
			branchespos[i] = Tree.factoryRandomBranch(COLUMNS, LINES);
	}

	public void refreshLand() {
		land.invalidate();
	}

	/*
	 * @Override protected void onAfterDrawing(TextGUIGraphics graphics) { //
	 * TODO Auto-generated method stub super.onAfterDrawing(graphics);
	 * graphics.setForegroundColor(TextColor.ANSI.CYAN);
	 * graphics.setBackgroundColor(TextColor.ANSI.BLUE);
	 * graphics.setModifiers(EnumSet.of(SGR.BOLD)); graphics.fill(' ');
	 * graphics.putString(3, 0, "Text GUI in 100% Java"); }
	 */

}
