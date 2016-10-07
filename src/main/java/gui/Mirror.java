package gui;

import java.io.IOException;
import java.util.Arrays;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Mirror {
	Terminal terminal;
	Screen screen;
	Panel 	pStatus,
			pMap;
	Map		map;

	public Mirror() {
		try {
			init();
			
			buildPanels();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void init() throws IOException {
		terminal = new DefaultTerminalFactory().createTerminal();
		screen = new TerminalScreen(terminal);
		
		map = new Map();

		screen.startScreen();
	}

	public void draw() throws IOException {
		String s = "Hello World!";
		TextGraphics tGraphics = screen.newTextGraphics();

		screen.clear();

		tGraphics.putString(10, 10, s);
		screen.refresh();

		screen.readInput();
		screen.stopScreen();
	}
	
	private void buildPanels(){
	    BasicWindow window = new BasicWindow();
	    window.setHints(Arrays.asList(Window.Hint.FULL_SCREEN, Window.Hint.NO_DECORATIONS));

	    Panel mainPanel = new Panel();
	    mainPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));

	    pStatus = new Status().getpStatus();
	    mainPanel.addComponent(pStatus.withBorder(Borders.singleLine("Status")));

	    pMap = map.getMap();
	    mainPanel.addComponent(pMap.withBorder(Borders.singleLine("Map")));

	    window.setComponent(mainPanel);
	    
	    MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
	    
	    gui.addWindowAndWait(window);
	}

}
