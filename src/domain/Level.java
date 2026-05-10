package domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
	private ArrayList<ScenarioItem> scenarioItems;
	private ArrayList<Zone> zones;
	private ArrayList<Thing> things;
	private ArrayList<Wall> walls;
	
	public boolean isWall(Rectangle ghost) {
		for(Wall w: walls) {
			if(ghost.intersects(w.hitbox)) {
				return false;
			}
		}
		return true;
	}
	public void start() {
		
	}
	public void checkZone(Player p) {
		for(Zone z: zones) {
			if(p.getHitbox().intersects(z.hitbox)) {
				z.effect(p);
			}
		}
	}
	public void finish() {
	}
	public ArrayList<Wall> getWalls(){
		return walls;
	}
	public ArrayList<Thing>getThings(){
		return things;
	}
}
