package gui;

import java.io.IOException;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;

import util.FileSystem;

public class DiaFight extends BasicWindow {

	public DiaFight(){
		super();
		
		Panel mPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
		
		try {
			StringBuilder sb = FileSystem.readFile("shelob.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TextBox pic = new TextBox();
		
		
	}
}
