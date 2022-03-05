package hazards;

import java.util.Random;

import engine.GameCode;
import engine.Sprite;

public class Pointer extends Hazard {

	int timer = 0;
	
	public Pointer () {
		this.setSprite(new Sprite ("resources/sprites/cursor.png"));
		this.setHitbox(0,0,64,64);
		Random r = new Random ();
		timer = r.nextInt(100) + 150;
		this.enablePixelCollisions();
	}
	
	@Override
	public void frameEvent () {
		if (GameCode.getReporter().getX() > this.getX()) {
			this.setX(this.getX() + 1);
		} else {
			this.setX(this.getX()- 1);
		}
		
		if (GameCode.getReporter().getY() > this.getY()) {
			this.setY(this.getY() + 1);
		} else {
			this.setY(this.getY()- 1);
		}
	
		timer = timer - 1;
		if (timer < 0) {
			forget();
		}
		
	}
	
	
}
