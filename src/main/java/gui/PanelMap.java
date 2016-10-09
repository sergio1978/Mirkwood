package gui;

import java.util.Random;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.graphics.Theme;
import com.googlecode.lanterna.gui2.AbsoluteLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.input.KeyStroke;

public class PanelMap extends Panel {
	public static final int COLUMNS = 62;
	public static final int LINES = 21;

	Label player;

	public PanelMap() {
		super(new AbsoluteLayout());
		setPreferredSize(new TerminalSize(COLUMNS, LINES));

		Theme th = SimpleTheme.makeTheme(false, new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70),
				new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70),
				new TextColor.RGB(170, 130, 70), new TextColor.RGB(170, 130, 70));
		setTheme(th);

		renderMap();

		player = new Label("φ");
		player.setForegroundColor(TextColor.ANSI.YELLOW);
		player.setBackgroundColor(TextColor.ANSI.RED);

		player.setPosition(new TerminalPosition(2, 2));
		player.setSize(new TerminalSize(1, 1));

		addComponent(player);

	}

	public void updatePlayer(KeyStroke keyStroke) {
		TerminalPosition ppos = player.getPosition();
		switch (keyStroke.getKeyType()) {
		case ArrowUp:
			player.setPosition(new TerminalPosition(ppos.getColumn(), ppos.getRow() - 1));
			break;
		case ArrowDown:
			player.setPosition(new TerminalPosition(ppos.getColumn(), ppos.getRow()+1));
			break;
		case ArrowLeft:
			player.setPosition(new TerminalPosition(ppos.getColumn()-1, ppos.getRow()));
			break;
		case ArrowRight:
			player.setPosition(new TerminalPosition(ppos.getColumn()+1, ppos.getRow()));
			break;
		default:
			System.out.println(keyStroke.getCharacter().toString());
			break;
		}
		
		invalidate();
	}

	public void renderMap() {
		Random r = new Random();
		char[] stuff = new char[] { '¥', '±', 'š', 'Î', 'Ý', '¬', '¤' };
		char[] trees = new char[] { '¥', 'Î', 'Ý' };
		for (int i = 0; i < 1000; i++) {
			Label lbls = new Label(String.valueOf(stuff[r.nextInt(stuff.length)]));
			Label lbl = new Label(String.valueOf(trees[r.nextInt(trees.length)]));
			lbl.setForegroundColor(new TextColor.RGB(50, r.nextInt(100) + 100, 50));
			lbls.setForegroundColor(new TextColor.RGB(170 + r.nextInt(25) - 25, 130, 70));
			lbl.setBackgroundColor(new TextColor.RGB(170 + r.nextInt(25) - 25, 130, 70));
			lbl.setPosition(new TerminalPosition(new Random().nextInt(COLUMNS), new Random().nextInt(LINES)));
			lbls.setPosition(new TerminalPosition(new Random().nextInt(COLUMNS), new Random().nextInt(LINES)));
			lbl.setSize(new TerminalSize(1, 1));
			lbls.setSize(new TerminalSize(1, 1));

			addComponent(lbl);
			addComponent(lbls);
		}

		/*
		 * River
		 */
		int col = r.nextInt(COLUMNS);
		char[] water = { '░', '▒', '▓' };

		for (int i = 0; i < LINES; i++) {
			Label lbl = new Label(String.valueOf(water[2]));
			Label lblw = new Label(String.valueOf(water[0]));
			Label lble = new Label(String.valueOf(water[0]));
			lbl.setForegroundColor(new TextColor.RGB(30, 150, 200));
			lble.setForegroundColor(new TextColor.RGB(30, 150, 200));
			lblw.setForegroundColor(new TextColor.RGB(30, 150, 200));
			// lbl.setBackgroundColor(new TextColor.RGB(30, 150, 50));
			int mt = getPosition().getColumn();
			int ms = getSize().getColumns();

			int rand = (r.nextInt(2) - 1);
			lbl.setPosition(new TerminalPosition(col + rand, i));
			lblw.setPosition(new TerminalPosition(col + rand + 1, i));
			lble.setPosition(new TerminalPosition(col + rand - 1, i));

			lbl.setSize(new TerminalSize(1, 1));
			lble.setSize(new TerminalSize(1, 1));
			lblw.setSize(new TerminalSize(1, 1));
			addComponent(lbl);
			addComponent(lble);
			addComponent(lblw);
		}
	}

	public void relevo() {

	}

}
