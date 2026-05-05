package domain;

import java.awt.Color;

public class BlueSkin implements PlayerType, Serializable{
	@Override
	public void apply(Player player) {
		player.setWidth(2);
		player.setWidth(2);
	}
	
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
}
