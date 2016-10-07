package gui;

import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;

public class Status {
	Panel pStatus;
	
	public Status() {
		pStatus = new Panel(new LinearLayout(Direction.VERTICAL));
	}

}
