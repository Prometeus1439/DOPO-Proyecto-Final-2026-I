package domain;

import java.awt.Color;
import java.io.Serializable;

public class RedSkin implements PlayerType, Serializable{
	@Override
	public void apply(Player player) {
		player.setWidth(20);
		player.setWidth(20);
	}
	
	@Override
	public Color getColor() {
		return Color.RED;
	}
}
