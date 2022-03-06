package hazards;

import engine.GameCode;
import engine.Sprite;
import gameObjects.Warning;

public class Tornado extends Hazard {
	boolean sound = true;
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
		
		double [] xOffsets = {0,16,32,48};
		double [] yOffsets = {101,139,177,215};
		double [] widths = {128,96,64,32};
		double [] heights = {38,38,38,38};
		
		this.setHitboxAttributes(xOffsets, yOffsets, widths,heights);
		this.setY(-100);
		//this.adjustHitboxBorders();
		
		if (flip) {
			this.setX(0);
			this.warn = new Warning(100, 0);
			this.warn.declare();
			this.warn.setX(0);
			this.warn.setY(100);
			this.flip = true;
		} else {
			this.setX(245);
			this.warn = new Warning(100, 1);
			this.warn.declare();
			this.warn.setX(245);
			this.warn.setY(100);
		}
	}
	public void draw()
	{
		if (warn.isDone())
		{
			
			if (sound)
			{
				GameCode.getSoundPlayer().playSoundEffect(6f, "resources/sounds/Tornado Sound Effect.wav");
				sound = false;
			}
			super.draw();
		}
	}

	@Override
	public void frameEvent () {
		
		if (warn.isDone())
		{
			super.frameEvent();
			if (flip)
			{
				this.setX(this.getX() + 1);
				if (this.getX() > 190)
				{	
					this.forget();
				}
			}
			else
			{
				this.setX(this.getX() - 1);
				if (this.getX() < 0)
				{
					this.forget();
				}
			}
		}
	}
	
}
