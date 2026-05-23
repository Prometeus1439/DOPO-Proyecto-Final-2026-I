package domain;

import java.awt.Color;
import java.io.Serializable;

public class GreenSkin implements PlayerType, Serializable{
	@Override
	public void apply(Player player) {
		player.setWidth(20);
	    player.setHeight(20);
	    player.setSpeed(2.0);
	    player.setLife(2);
	}
	
	@Override
	public Color getColor() {
		return Color.GREEN;
	}
}
