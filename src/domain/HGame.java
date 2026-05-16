package domain;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

public class HGame implements Serializable {

 private static final long serialVersionUID = 1L;	

 private ArrayList<Player> players;
 private ArrayList<Level> levels;
 private Level actualLevel;
 
 private String mode;
 
 public HGame() {
	 players = new ArrayList<>();
	 levels = new ArrayList<>();
 }
 
 public void startGame(String mode, PlayerType playerType) {
	 players.clear();
	 levels.clear();
	 
	 createPlayer("human", 1, playerType);
	 
	 if(mode.equals("PVP")) {
		 createPlayer("human", 2, playerType);
	 }
	 
	 else if(mode.equals("PVM")){
		 createPlayer("machine", 2, playerType);
	 }
	 
	 level1();
 } 
 
 public void move(char direction, int player) {
	 int dx = 0;
	 int dy = 0;
	 Player p= players.get(player);
	 
	 double speed = p.getSpeed();
	 
	 switch(direction) {
	 	case 'W':
	 	dy = (int) -speed;
	 	break;

	 	case 'S':
	 	dy = (int) speed;
	 	break;

	 	case 'A':
	 	dx = (int) -speed;
	 	break;
	 	
	 	case 'D':
	 	dx = (int) speed;
	 	break;
	 	}
	    
	 Rectangle future = new Rectangle(p.getX()+ dx, p.getY() + dy, p.getWidth(), p.getHeight());
	 
	 if(actualLevel.isWall(future)) {
		 p.move( direction);
	 }
	 
 }
 
 public void createPlayer(String controlType, int player, PlayerType pType) {
	 Player p = null;
	 
	 if(controlType.equals("human")) {
		 p = new HumanPlayer(pType,1,1,1,1);
	 }
	 
	 else if (controlType.equals("machine")) {
		 p= new MachinePlayer(pType,1,1,1,1);
	 }
	 
	 if(p != null) {
		 players.add(p);
	 }
	 
 }
 
 public void tictac() {
	 for(Player p: players) {
	 actualLevel.checkZone(p);
	 actualLevel.checkThing(p);
	 actualLevel.checkScenarioItems(p);
	 if(p.getLife()==0) {
		 p.getHitbox().x=p.getRespawnX();
		 p.getHitbox().y=p.getRespawnY();
		 }
	 }
 }
 
 public void level1() {

	    ArrayList<Wall> walls = new ArrayList<>();
	    ArrayList<Zone> zones= new ArrayList<>();
	    ArrayList<Thing> things= new ArrayList<>();

	    int size = 100;	
	    int thickness = 5;

	    walls.add(new Wall(0, 0, thickness, size));
	    walls.add(new Wall(0, 0, size, thickness));
	    walls.add(new Wall(0,size - thickness,size,thickness));
	    walls.add(new Wall(size - thickness,0,thickness,size));
	    
	    Start start = new Start(20,100,60,400);
	    Goal goal = new Goal(720,100,60,400);
	    
	    zones.add(goal);
	    zones.add(start);
	    
	    YellowCoin coin= new YellowCoin(400,100,20,20);
	    Guard guard = new Guard(400, 100,20,20,1,100,500);
	    
	    things.add(guard);
	    things.add(coin);
	    
	    for(Player p: players) {
	    	p.setRespawnX(20);
	    	p.setRespawnY(100);
	    }
	    
	    actualLevel = new Level(walls, zones, things);
	    levels.add(actualLevel);
}
 
 public Level getActualLevel(){
	 return actualLevel;
 }
 
 public ArrayList<Player> getPlayers(){
	 return players;
	 }
 
}
