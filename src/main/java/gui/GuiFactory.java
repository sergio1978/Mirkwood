package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.graphics.Theme;

public class GuiFactory {

	public static Theme getTextTheme() {
		Theme th = SimpleTheme.makeTheme(false, 
				TextColor.ANSI.WHITE, 
				TextColor.ANSI.BLACK, 
				TextColor.ANSI.WHITE, 
				TextColor.ANSI.BLACK, 
				TextColor.ANSI.WHITE, 
				TextColor.ANSI.BLACK, 
				TextColor.ANSI.BLACK);
		
		return th;
	}
}
