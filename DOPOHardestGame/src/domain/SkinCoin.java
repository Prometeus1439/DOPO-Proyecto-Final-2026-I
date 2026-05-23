package domain;

import java.io.Serializable;

public class SkinCoin extends Coin implements Serializable {

	private PlayerType playerType;
	
	public SkinCoin(int x, int y, int width, int height, PlayerType playerType) {
		super(x, y, width, height);
		this.playerType = playerType;
		this.color = playerType.getColor();
	}
	
	public SkinCoin(int x, int y, int width, int height, PlayerType playerType, int ownerPlayer) {
		super(x, y, width, height, ownerPlayer);
		this.playerType = playerType;
		this.color = playerType.getColor();
	}
	
	
	public void touch(Player p) {
	    if(ownerPlayer == -1 || p.getPlayerNumber() == ownerPlayer) {
	        p.setScore(p.getScore() + 1);
	        p.changeType(playerType);
	        collected = true;
	        }
	}
	
}
