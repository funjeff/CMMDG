package hazards;

import java.util.Random;

import engine.Sprite;
import map.Room;

public class Meteor extends Hazard{
	
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
		
		if (delay == 0) {
			if (ay < 2) {
				ay = ay + 0.1;
			}
			vy = vy + ay;
			this.setY(this.getY() + vy);
			if (Room.isColliding(this)) {
				this.forget();
			}
		} else {
			delay = delay -1;
		}
		
	}
	
	@Override
	public void draw () {
		if (delay == 0) {
			super.draw();
		}
	}
	
	@Override
	public void spawnHazard()
	{
		Random r = new Random ();
		int amountOfMetors = r.nextInt(4) + 1;
		for (int i = 0; i < amountOfMetors;i++) {
			Meteor m = new Meteor ();
			m.declare();
			m.setX(r.nextInt(400));
			m.setY(150);
			m.delay = r.nextInt(100);
		
		}
	}
}
