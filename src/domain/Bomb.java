package domain;

import java.io.Serializable;

public class Bomb extends ScenarioItem implements Serializable{
	public Bomb(int x, int y, int width, int height) {
		super(x,y,width, height);
	}
}
