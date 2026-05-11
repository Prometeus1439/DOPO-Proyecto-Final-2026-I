package domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class Level implements Serializable {
	private ArrayList<ScenarioItem> scenarioItems;
	private ArrayList<Zone> zones;
	private ArrayList<Thing> things;
	private ArrayList<Wall> walls;
	
	public Level(ArrayList<Wall> walls ,ArrayList<Zone> zones,ArrayList<Thing> things) {
		this.walls=walls;
		this.zones=zones;
		this.things=things;
	}
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
	public void checkThing(Player p) {
		for(Thing t: things) {
			if(p.getHitbox().intersects(t.hitbox)) {
				t.touch(p);
			}
		}
	}
	public void checkScenarioItems(Player p) {
		for(ScenarioItem s: scenarioItems) {
			if(p.getHitbox().intersects(s.hitbox)) {
				s.effect(p);
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
	public ArrayList<ScenarioItem> getScenarioItems(){
		return scenarioItems;
	}
}
