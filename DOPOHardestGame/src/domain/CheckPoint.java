package domain;

import java.io.Serializable;

public class CheckPoint extends Zone implements Serializable {
	public CheckPoint(int x, int y, int width, int height) {
		super(x,y, width, height);
	}
	public void effect(Player p) {
		p.setRespawnX(hitbox.x);
		p.setRespawnY(hitbox.y);
	}
}
