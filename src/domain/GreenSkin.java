package domain;

import java.awt.Color;
import java.io.Serializable;

public class GreenSkin implements PlayerType, Serializable{
	@Override
	public void apply(Player player) {
		player.setWidth(2);
		player.setWidth(2);
	}
	
	@Override
	public Color getColor() {
		return Color.GREEN;
	}
}
