import java.io.IOException;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class SGRTest {
    public static void main(String[] args) throws IOException {
		Terminal rawTerminal = new DefaultTerminalFactory().createTerminal();
		Screen screen = new TerminalScreen(rawTerminal);
        rawTerminal.enterPrivateMode();
        rawTerminal.clearScreen();
        
        String string = "Hello!";
        
        TextGraphics textGraphics = rawTerminal.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.enableModifiers(SGR.BLINK);
        textGraphics.putString(10, 2, string);
        textGraphics.disableModifiers(SGR.BLINK);
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(10, 4, string);
        textGraphics.disableModifiers(SGR.BOLD);
        textGraphics.enableModifiers(SGR.BORDERED);
        textGraphics.putString(10, 6, string);
        textGraphics.disableModifiers(SGR.BORDERED);
        textGraphics.enableModifiers(SGR.CIRCLED);
        textGraphics.putString(10, 8, string);
        textGraphics.disableModifiers(SGR.CIRCLED);
        textGraphics.enableModifiers(SGR.CROSSED_OUT);
        textGraphics.putString(10, 10, string);
        textGraphics.disableModifiers(SGR.CROSSED_OUT);
        textGraphics.enableModifiers(SGR.UNDERLINE);
        textGraphics.putString(10, 12, string);
        textGraphics.disableModifiers(SGR.UNDERLINE);
        textGraphics.enableModifiers(SGR.FRAKTUR);
        textGraphics.putString(10, 14, string);
        textGraphics.disableModifiers(SGR.FRAKTUR);
        textGraphics.enableModifiers(SGR.REVERSE);
        textGraphics.putString(10, 16, string);
        textGraphics.disableModifiers(SGR.REVERSE);
        rawTerminal.setCursorPosition(0, 0);
        rawTerminal.flush();
        try {
            while(rawTerminal.pollInput() == null) {
                Thread.sleep(1);
            }
        }
        catch(InterruptedException e) {}
        rawTerminal.exitPrivateMode();
    }
}