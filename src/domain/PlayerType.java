package domain;

import java.awt.Color;

public interface PlayerType implements Serializable {
	public void apply(Player player);
	public Color getColor();
}
