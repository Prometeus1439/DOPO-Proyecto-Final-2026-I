package domain;

import java.io.Serializable;

public class LifeSource extends ScenarioItem implements Serializable{
	public LifeSource(int x, int y, int width, int height) {
		super(x,y, width, height);
	}
	public void effect (Player p) {
		p.setLife(p.getLife()+1);
	}
}
