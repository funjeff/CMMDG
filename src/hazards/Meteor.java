package hazards;

import java.util.Random;

import engine.Sprite;
import gameObjects.Warning;
import map.Room;

public class Meteor extends Hazard{
	boolean hasBeenWarned = false;
	int delay= 0;
	
	double vy = 0.0;
	double ay = 0.0;
	
	public Meteor() {
		Random r = new Random();
		this.setSprite(new Sprite ("resources/sprites/meteorite" + (r.nextInt(3) + 1) + ".png"));
		this.setHitbox(0,0,32,32);
	}
	
	@Override
	public void frameEvent () {
		super.frameEvent();
		if (warn.isDone())
		{
			if (delay == 0) {
				
				
				if (ay < 2) {
					ay = ay + 0.1;
				}
				vy = vy + ay;
				this.setY(this.getY() + vy);
				if (this.getY() > 280) {
					
					this.forget();
				}
			} else {
				delay = delay -1;
			}
		}
		
		
	}
	
	@Override
	public void draw () {
		if (!hasBeenWarned && delay == 0)
		{
			warn = new Warning(100, 2);
			warn.declare(this.getX(), this.getY());
			hasBeenWarned = true;
		}
		if (delay == 0 && warn.isDone()) {
			super.draw();
		}
		
		
	}
	
	@Override
	public void spawnHazard()
	{
		Random r = new Random();
		int amountOfMetors = r.nextInt(14) + 5;
		for (int i = 0; i < amountOfMetors;i++) {
			Meteor m = new Meteor ();
			m.declare();
			m.warn = new Warning(0, 2);
			int xPos = r.nextInt(245);
			m.warn.setX(xPos);
			m.warn.setY(0);
			m.setX(xPos);
			m.setY(0);
			m.delay = r.nextInt(100);
		
		}
	}
}
