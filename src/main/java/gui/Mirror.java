package gui;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowListener;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import script.Characters;
import script.Hero;

public class Mirror {
	Terminal terminal;
	Screen screen;
	Panel 	pStatus,
			pMap;
	Map		map;
	
	MultiWindowTextGUI board;
	
	Hero hero;
	Characters _chars;

	public Mirror() {
		try {
			init();
			
			_chars = new Characters();

			
			buildPanels();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void init() throws IOException {
		terminal = new DefaultTerminalFactory().createTerminal();
		screen = new TerminalScreen(terminal);
		
		_chars = new Characters();
		map = new Map(_chars);

		screen.startScreen();
	    board = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));
		
	}
	
	private void buildPanels(){
	    BasicWindow window = new BasicWindow();
	    window.setTitle("Mirror");
	    window.setHints(Arrays.asList(Window.Hint.FULL_SCREEN));

	    Panel mainPanel = new Panel();
	    mainPanel.setLayoutManager(new GridLayout(2));

	    pStatus = new Status().getpStatus();

	    PanelStory pstory = new PanelStory();

	    mainPanel.addComponent(pStatus.withBorder(Borders.singleLine("Status")));
	    mainPanel.addComponent(map.withBorder(Borders.singleLine("Map")));
	    mainPanel.addComponent(new EmptySpace());
	    mainPanel.addComponent(pstory);

	    window.setComponent(mainPanel);
	    
	    
	    window.addWindowListener(new WindowListener() {
			
			public void onUnhandledInput(Window arg0, KeyStroke keyStroke, AtomicBoolean arg2) {
				// TODO Auto-generated method stub
				map.updatePlayer(keyStroke);
				
				if(keyStroke.getCharacter() == 'f') {
					board.addWindow(new DiaFight());
				}
			}
			
			public void onInput(Window arg0, KeyStroke arg1, AtomicBoolean arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onResized(Window arg0, TerminalSize arg1, TerminalSize arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onMoved(Window arg0, TerminalPosition arg1, TerminalPosition arg2) {
				// TODO Auto-generated method stub
				
			}
		});

	    
//	    window.setSize(new TerminalSize(Map.COLUMNS+50, Map.LINES+10));
	    board.addWindowAndWait(window);
	    
	}

}
