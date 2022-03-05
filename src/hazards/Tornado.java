package hazards;

import engine.Sprite;

public class Tornado extends Hazard {

	boolean flip = false;
	
	public Tornado () {
		this.setSprite(new Sprite ("resources/sprites/Tornado.txt"));
		this.getAnimationHandler().setFrameTime(100);
		this.setHitbox(0,101, 128,155);
		this.enablePixelCollisions();
	}
	
	public Tornado (boolean flip) {
		this.setSprite(new Sprite ("resources/sprites/Tornado.txt"));
		this.getAnimationHandler().setFrameTime(100);
		this.setHitbox(0,101, 128,155);
		this.setY(-100);
		this.enablePixelCollisions();
		
		if (flip) {
			this.setX(0);
			this.flip = true;
		} else {
			this.setX(245);
		}
	}

	@Override
	public void frameEvent () {
		if (flip) {
			this.setX(this.getX() + 1);
			if (this.getX() > 190) {	
				this.forget();
			}
		} else {
			this.setX(this.getX() - 1);
			if (this.getX() < 0) {
				this.forget();
			}
		}
	}
	
}
