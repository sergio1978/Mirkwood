package gui;

import java.util.Random;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.AbsoluteLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;

public class Map {
	private static final int COLUMNS = 130;
	private static final int LINES = 100;
	
	private Panel map;
	
	
	public Map() {
		map = new Panel(new AbsoluteLayout());
		map.setPreferredSize(new TerminalSize(COLUMNS, LINES));
		
		
		renderMap();
	}


	public Panel getMap() {
		return map;
	}

	public void renderMap() {
		Random r = new Random();
//		char[] trees = new char[]{'¥', '±','š', 'Î', 'Ý', '¬', '¤'};
		char[] trees = new char[]{'¥','Î', 'Ý'};
		for (int i=0; i < 1000; i++) {
			Label lbl = new Label(String.valueOf(trees[r.nextInt(trees.length)]));
			lbl.setForegroundColor(TextColor.ANSI.GREEN);
			lbl.setPosition(new TerminalPosition(new Random().nextInt(COLUMNS), new Random().nextInt(LINES)));
			lbl.setSize(new TerminalSize(1,1));
			
			map.addComponent(lbl);
		}
	}

	public void setMap(Panel map) {
		this.map = map;
	}

	
}
