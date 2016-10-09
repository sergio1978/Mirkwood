package script;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TextColor.RGB;

import gui.SymbolsMirk;

public class Foe {
	String _name;
	char _face = SymbolsMirk.FOE;
	TerminalPosition _position;
	RGB _foregroundColor;
	RGB _bkgColor;
	
	public Foe(String _name, TerminalPosition _position) {
		super();
		this._name = _name;
		this._position = _position;

		this._bkgColor = new TextColor.RGB(0, 0, 0);
		this._foregroundColor = new TextColor.RGB(242, 238, 10);
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public TerminalPosition get_position() {
		return _position;
	}

	public void set_position(TerminalPosition _position) {
		this._position = _position;
	}

	public char get_face() {
		return _face;
	}

	public void set_face(char _face) {
		this._face = _face;
	}

	public RGB get_foregroundColor() {
		return _foregroundColor;
	}

	public void set_foregroundColor(RGB _foregroundColor) {
		this._foregroundColor = _foregroundColor;
	}

	public RGB get_bkgColor() {
		return _bkgColor;
	}

	public void set_bkgColor(RGB _bkgColor) {
		this._bkgColor = _bkgColor;
	}
}
