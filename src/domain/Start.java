package domain;

import java.io.Serializable;

public class Start extends Zone implements Serializable{
	public Start(int x, int y, int width, int height) {
		super(x,y, width, height);
	}
	public void effect(Player p) {
		p.setInmune(true);
	}
}
