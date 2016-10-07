package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.AbsoluteLayout;
import com.googlecode.lanterna.gui2.Panel;

public class Map {
	Panel map;
	
	
	public Map() {
		map = new Panel(new AbsoluteLayout());
		map.setSize(new TerminalSize(600, 480));
	}

}
