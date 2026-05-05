package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class HGame implements Serializable {
 private int score;
 private int difficult;
 private int lives;
 private ArrayList<Player> players;
 private ArrayList<Level> levels;
 public void move(char dir, int player) {
	 players.get(player).move(dir);
	 
 }
}
