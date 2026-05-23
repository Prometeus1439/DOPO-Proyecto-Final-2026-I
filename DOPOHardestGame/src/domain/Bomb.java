package domain;

import java.awt.Color;
import java.io.Serializable;

public class Bomb extends ScenarioItem implements Serializable{
	public Bomb(int x, int y, int width, int height) {
		super(x,y,width, height);
		this.color = Color.BLACK;
	}
	
	public void effect(Player p) {
		p.setLife(0);
		collected = true;
	}
	
	public void effect(Obstacle o) {
		o.eliminated();
		collected = true;
	}
}
