package gui;

import com.googlecode.lanterna.gui2.BorderLayout;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.ScrollBar;

public class PanelStory extends Panel {
	ScrollBar verticalScroll;
	Label mLabel;

	public PanelStory() {
		setLayoutManager(new BorderLayout());
		verticalScroll = new ScrollBar(Direction.VERTICAL);

		verticalScroll.setLayoutData(
				GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.FILL, false, true));
		mLabel = new Label(
				"It was getting dark... And you still haven't found a place to rest. The last fights have left you in poor shape. Now you're at your peak, and everyone in Mirkwood know you by your war name. ");

		addComponent(verticalScroll, BorderLayout.Location.RIGHT);
		addComponent(mLabel, BorderLayout.Location.CENTER);

	}

}
