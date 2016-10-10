package gui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowListener;
import com.googlecode.lanterna.input.KeyStroke;

import util.FileSystem;

public class WFight extends BasicWindow {
	
	Label _lMoves;
	

	public WFight(){
		super();
	    setTitle("Fight to survive!");
	    setHints(Arrays.asList(Window.Hint.CENTERED));
	    
	    		
		Panel mPanel = new Panel(new LinearLayout(Direction.VERTICAL));
		StringBuilder sb = null;
		
		try {
			sb = FileSystem.readFile(getClass(), "shelob.txt");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TextBox pic = new TextBox(sb.toString());
		pic.setReadOnly(true);
		pic.setTheme(GuiFactory.getTextTheme());
		
		Panel photoStatus = new Panel(new LinearLayout(Direction.HORIZONTAL));
		photoStatus.addComponent(pic);
		
		Panel pstatevent = new Panel(new LinearLayout(Direction.VERTICAL));
		pstatevent.addComponent(new PanelStatus().withBorder(Borders.singleLine("Hero")));
		pstatevent.addComponent(new PanelStatus().withBorder(Borders.singleLineBevel("Shelob")));
		pstatevent.addComponent(new Label("> So we finally meet... \nPrepare to feel my sting"));
		
		_lMoves = new Label("");
		final boolean hit = false,
				redhit = false;
		final Timer timer = new Timer("ProgressBar-timer", true);
        timer.schedule(new TimerTask() {
            public void run() {
            	// _lMoves.setText("Take this " + (bla));
            	
            	
            	
            	/*
                if(progressBar.getValue() == progressBar.getMax()) {
                    progressBar.setValue(0);
                }
                else {
                    progressBar.setValue(progressBar.getValue() + 1);
                }
                */
            }
        }, 250, 250);
		
		pstatevent.addComponent(_lMoves);
		
		
		photoStatus.addComponent(pstatevent);
		Button okButton = new Button("Run Away", new Runnable() {
            public void run() {
                close();                
            }
        }).setLayoutData(LinearLayout.createLayoutData(LinearLayout.Alignment.Center));
		
		mPanel.addComponent(photoStatus);
		mPanel.addComponent(okButton);
		
		addWindowListener(new WindowListener() {
			
			public void onUnhandledInput(Window arg0, KeyStroke arg1, AtomicBoolean arg2) {
				// TODO Auto-generated method stub
				_lMoves.setText(String.valueOf(arg1.getCharacter()));
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
		
		setComponent(mPanel);
	}
}
