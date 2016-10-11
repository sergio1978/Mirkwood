package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.graphics.ThemeDefinition;
import com.googlecode.lanterna.gui2.BorderLayout;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.ScrollBar;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.WindowDecorationRenderer;
import com.googlecode.lanterna.gui2.WindowPostRenderer;

public class PanelStory extends Panel {
	ScrollBar verticalScroll;
	TextBox mLabel;

	public PanelStory() {
		setLayoutManager(new BorderLayout());
		
		

		GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.FILL, false, true);
		mLabel = new TextBox(
				"It was getting dark... \nAnd you still haven't found a place to rest.\nThe last fights have left you in poor shape. \n Now you're at your peak, and everyone in Mirkwood know you by your war name. ");

		mLabel.setReadOnly(true);
		mLabel.setCaretWarp(true);
		
		setPreferredSize(new TerminalSize(Map.COLUMNS+ 2,3));
//		mLabel.
	//	addComponent(verticalScroll, BorderLayout.Location.RIGHT);
		addComponent(mLabel, BorderLayout.Location.CENTER);
	}

}
