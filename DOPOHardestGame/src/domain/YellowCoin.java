package domain;

import java.io.Serializable;

public class YellowCoin extends Coin implements Serializable {

 public YellowCoin(int x, int y, int width, int height) {
  super(x, y, width, height);
  color = java.awt.Color.YELLOW;
 }

 public YellowCoin(int x, int y, int width, int height, int ownerPlayer) {
	    super(x, y, width, height, ownerPlayer);
	    color = java.awt.Color.YELLOW;
}
 
}
 