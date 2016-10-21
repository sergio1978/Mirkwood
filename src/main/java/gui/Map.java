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
import com.googlecode.lanterna.input.KeyStroke;

import script.Characters;
import script.Foe;
import script.Hero;

public class Map extends Panel {

	public static final int COLUMNS = 50;
	public static final int LINES = 16;
	
	public static final int TREECOUNT = 400;
	public static final int BRANCHESCOUNT = 250;
	
	Random mRand;
	
	int[] playerpos = new int[]{2, 2};
	
	int[] waterpos = new int[LINES];
        int[] waterposh = new int [COLUMNS];
	Tree[] treespos = new Tree[TREECOUNT];
	Tree[] branchespos = new Tree[BRANCHESCOUNT];
	RGB bkgColor = new TextColor.RGB(165, 127, 61);
        int[] bridge_pos = new int[2];
        RGB bridge_color = new TextColor.RGB(165, 127, 61);
	
	Characters _chars;

	EmptySpace land;

	public Map(Characters chars) {
		super();

		_chars = chars;
		getBasePane();
		
		mRand = new Random();
		
		generateWater();
		generateTrees();
                final int locBridge = mRand.nextInt(waterpos.length);

		land = new EmptySpace(new TextColor.RGB(165, 127, 61)) {
			protected ComponentRenderer<EmptySpace> createDefaultRenderer() {
				return new ComponentRenderer<EmptySpace>() {
					public TerminalSize getPreferredSize(EmptySpace component) {
						return new TerminalSize(Map.COLUMNS, Map.LINES);
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
                                                    
                                                
                                                        graphics.setForegroundColor(new TextColor.ANSI.BLUE);
							graphics.setBackgroundColor(new TextColor.RGB(30, 150, 100));
							graphics.putString(waterpos[i], i, String.valueOf(SymbolsMirk.WATER[2]));
							graphics.setBackgroundColor(bkgColor);
							graphics.putString(waterpos[i]-1, i, String.valueOf(SymbolsMirk.WATER[1]));
							graphics.putString(waterpos[i]+1, i, String.valueOf(SymbolsMirk.WATER[1]));
							graphics.putString(waterpos[i]-2, i, String.valueOf(SymbolsMirk.WATER[0]));
							graphics.putString(waterpos[i]+2, i, String.valueOf(SymbolsMirk.WATER[0]));
						 
                                                        if (i == locBridge) {
                                                        graphics.setBackgroundColor(bridge_color);
                                                        if (i == locBridge) {
                                                        graphics.putString(waterpos[i], i, String.valueOf(SymbolsMirk.WATER[2]));
                                                        bridge_pos = new int[]{waterpos[i], i};
                                                        
                                                    }
                                                        
                                                }
                                                
                                                /*
						 * Creates the river horizontal
						 
						graphics.setForegroundColor(new TextColor.RGB(30, 150, 200));
						for (int i = 0; i < waterposh.length; i++) {
							graphics.setBackgroundColor(new TextColor.RGB(30, 150, 100));
							graphics.putString(i, waterposh[i], String.valueOf(SymbolsMirk.WATER[2]));
							graphics.setBackgroundColor(bkgColor);
							graphics.putString(i, waterposh[i]-1, String.valueOf(SymbolsMirk.WATER[1]));
							graphics.putString(i, waterposh[i]+1, String.valueOf(SymbolsMirk.WATER[1]));
							graphics.putString(i, waterposh[i]-2, String.valueOf(SymbolsMirk.WATER[0]));
							graphics.putString(i, waterposh[i]+2, String.valueOf(SymbolsMirk.WATER[0]));
						} 
                                                */
           
                                                /*
                                                * Creates the Lake
                                                */
                                                
                                                        graphics.setCharacter(15, 5, SymbolsMirk.WATER[2]);
                                                
                                                /*
                                                *Bridge over the River
                                                */
                                                        graphics.setForegroundColor(new TextColor.RGB(150, 50, 200));
                                                
						/*
						 * Draw characters
						 */
						Hero h = _chars.getHero();
						graphics.setBackgroundColor(h.get_bkgColor());
						graphics.setForegroundColor(h.get_foregroundColor());
						graphics.setCharacter(h.get_position(), h.get_face());

						graphics.setModifiers(EnumSet.of(SGR.BLINK));
						Foe f = _chars.getFoe();
						graphics.setBackgroundColor(f.get_bkgColor());
						graphics.setForegroundColor(f.get_foregroundColor());
						graphics.setCharacter(f.get_position(), f.get_face());
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
                int lin = mRand.nextInt(LINES);
                for (int i = 0; i < COLUMNS; i++) {
			waterposh[i] = lin + (mRand.nextInt(2) - 1);
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
	
	public void updatePlayer(KeyStroke keyStroke) {
		TerminalPosition ppos = _chars.getHero().get_position();
		Hero player = _chars.getHero();
		switch (keyStroke.getCharacter()) {
		case 'w':
			player.set_position(new TerminalPosition(ppos.getColumn(), ppos.getRow() - 1));
			break;
		case 's':
			player.set_position(new TerminalPosition(ppos.getColumn(), ppos.getRow()+1));
			break;
		case 'a':
			player.set_position(new TerminalPosition(ppos.getColumn()-1, ppos.getRow()));
			break;
		case 'd':
			player.set_position(new TerminalPosition(ppos.getColumn()+1, ppos.getRow()));
			break;
		default:
			System.out.println(keyStroke.getCharacter().toString());
			break;
		}
		
		refreshLand();
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
