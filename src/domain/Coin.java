package domain;

import java.awt.Color;
import java.io.Serializable;

public class Coin extends Thing implements Serializable {
	private Color color;
	public Coin(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public void touch(Player p) {
		p.setScore(p.getScore()+1);
	}
}
