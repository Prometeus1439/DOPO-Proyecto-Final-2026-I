package domain;

import java.awt.Color;
import java.io.Serializable;

public class BlueSkin implements PlayerType, Serializable{
	@Override
	public void apply(Player player) {
		player.setWidth(30);
		player.setHeight(30);
	}
	
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
}
