package hazards;

import engine.Sprite;
import java.util.Random;

public class Gnome extends Hazard{
	Random r = new Random();
	boolean reachedPeak = false;
	int jumpHeight = 0;
	
	public Gnome()
	{
		int mustachance = r.nextInt(10);
		if (mustachance == 9)
		{
			this.setSprite(new Sprite ("resources/sprites/Gnomestache.txt"));
		}
		else
		{
			this.setSprite(new Sprite ("resources/sprites/Gnome.txt"));
		}
		this.getAnimationHandler().setRepeat(false);
		this.setY(190 + r.nextInt(10));
		this.setX(r.nextInt(245));
		jumpHeight = 190 - (30 + r.nextInt(50));
	}
	public void frameEvent()
	{
		
		
		if (this.getY() > jumpHeight && !reachedPeak)
		{
			this.setY(this.getY() -4);
		} else {
			reachedPeak = true;
		}
		if (reachedPeak) {
			this.setY(this.getY() + 3);
			if (this.getY() > 200)
			{
				forget();
			}
		}
	}
}
