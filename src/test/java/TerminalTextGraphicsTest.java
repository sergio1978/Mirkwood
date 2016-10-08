import java.io.IOException;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.DoublePrintingTextGraphics;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class TerminalTextGraphicsTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		Terminal terminal = new DefaultTerminalFactory().createTerminal();
		Screen screen = new TerminalScreen(terminal);

		TextGraphics textGraphics = terminal.newTextGraphics();
		if ((args.length > 0 && args[0].equals("--square")) || (args.length > 1 && args[1].equals("--square"))) {
			textGraphics = new DoublePrintingTextGraphics(textGraphics);
		}
		textGraphics.setForegroundColor(TextColor.ANSI.BLUE);
		textGraphics.putString(3, 3, "Hello World!");
		textGraphics.setForegroundColor(TextColor.ANSI.CYAN);
		TerminalPosition lineStart = new TerminalPosition(3 + "Hello World!".length(), 3);
		textGraphics.drawLine(lineStart, lineStart.withRelativeColumn(2).withRelativeRow(6), Symbols.BLOCK_SOLID);
		textGraphics.setForegroundColor(TextColor.ANSI.RED);
		textGraphics.drawRectangle(lineStart.withRelativeColumn(2).withRelativeRow(6), new TerminalSize(5, 3),
				Symbols.BULLET);
		textGraphics.setForegroundColor(TextColor.ANSI.MAGENTA);
		TerminalPosition triangleStart = lineStart.withRelativeColumn(7).withRelativeRow(9);
		textGraphics.drawTriangle(triangleStart, triangleStart.withColumn(0).withRelativeRow(-1),
				triangleStart.withColumn(5).withRelativeRow(3), Symbols.SPADES);
		textGraphics.setForegroundColor(TextColor.ANSI.YELLOW);
		textGraphics.fillRectangle(new TerminalPosition(30, 1), new TerminalSize(8, 5), Symbols.DIAMOND);
		textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
		triangleStart = new TerminalPosition(30, 6);
		textGraphics.fillTriangle(triangleStart, triangleStart.withRelativeRow(5).withRelativeColumn(-2),
				triangleStart.withRelativeRow(5).withRelativeColumn(4), Symbols.CLUB);

		terminal.resetColorAndSGR();
		terminal.flush();

		Thread.sleep(4000);

		/**
		if (terminal instanceof Window) {
			((Object) terminal).dispose();
		}
		*/
	}
}