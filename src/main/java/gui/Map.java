package gui;

import java.util.Random;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.gui2.AbsoluteLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;

public class Map {
	private static final int COLUMNS = 62;
	private static final int LINES = 21;

	private Panel map;

	public Map() {
		map = new Panel(new AbsoluteLayout());
		map.setPreferredSize(new TerminalSize(COLUMNS, LINES));

		Theme th = SimpleTheme.makeTheme(false, new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70),
				new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70),
				new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70));
		map.setTheme(th);

		renderMap();
	}

	public Panel getMap() {
		return map;
	}

	public void renderMap() {
		Random r = new Random();
		char[] stuff = new char[]{'¥', '±','š', 'Î', 'Ý', '¬', '¤'};
		char[] trees = new char[] { '¥', 'Î', 'Ý' };
		for (int i = 0; i < 1000; i++) {
			Label lbls = new Label(String.valueOf(stuff[r.nextInt(stuff.length)]));
			Label lbl = new Label(String.valueOf(trees[r.nextInt(trees.length)]));
			lbl.setForegroundColor(new TextColor.RGB(50, r.nextInt(100) + 100, 50));
			lbls.setForegroundColor(new TextColor.RGB(170+ r.nextInt(25)-25, 130, 70));
			lbl.setBackgroundColor(new TextColor.RGB(170+ r.nextInt(25)-25, 130, 70));
			lbl.setPosition(new TerminalPosition(new Random().nextInt(COLUMNS), new Random().nextInt(LINES)));
			lbls.setPosition(new TerminalPosition(new Random().nextInt(COLUMNS), new Random().nextInt(LINES)));
			lbl.setSize(new TerminalSize(1, 1));
			lbls.setSize(new TerminalSize(1, 1));

			map.addComponent(lbl);
			map.addComponent(lbls);
		}

		/*
		 * River
		 */
		int col = r.nextInt(COLUMNS);
		char[] water = {'░', '▒','▓'};
		
		for (int i = 0; i < LINES; i++) {
			Label lbl = new Label(String.valueOf(water[2]));
			Label lblw = new Label(String.valueOf(water[0]));
			Label lble = new Label(String.valueOf(water[0]));
			lbl.setForegroundColor(new TextColor.RGB(30, 150, 200));
			lble.setForegroundColor(new TextColor.RGB(30, 150, 200));
			lblw.setForegroundColor(new TextColor.RGB(30, 150, 200));
			//lbl.setBackgroundColor(new TextColor.RGB(30, 150, 50));
			int mt = map.getPosition().getColumn();
			int ms = map.getSize().getColumns();

			int rand = (r.nextInt(2)-1);
			lbl.setPosition(new TerminalPosition(col + rand, i));
			lblw.setPosition(new TerminalPosition(col + rand+1, i));
			lble.setPosition(new TerminalPosition(col + rand-1, i));
			
			lbl.setSize(new TerminalSize(1, 1));
			lble.setSize(new TerminalSize(1, 1));
			lblw.setSize(new TerminalSize(1, 1));
			map.addComponent(lbl);
			map.addComponent(lble);
			map.addComponent(lblw);
		}
	}

	public void setMap(Panel map) {
		this.map = map;
	}

}
