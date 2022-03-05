package tileEntities;


import engine.GameObject;
import gameObjects.Reporter;
import map.TileEntitiy;

public class Semisolid extends TileEntitiy{
	public Semisolid() {
		super();
	}
	@Override 
	public boolean doesColide (GameObject o) {
		
		if (o instanceof Reporter) {
		Reporter j = (Reporter) o;
		if ((j.getVy() < 0 || (j.getYPrevious() + j.hitbox().height > this.getY() * 16)) || o.keyDown ('S') ){
			return false;
		} 
			return true;
		} else {
			
			return true;
		}
	}
}