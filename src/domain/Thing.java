package domain;

import java.awt.Color;
import java.io.Serializable;

public abstract class Thing extends GameObject implements Serializable{
	public Color color;
	public Thing(int x, int y, int width, int height) {
		super(x,y, width, height);
		
	}
	public abstract void touch(Player p);
	public Color getColor() {
		return color;
	}
}
