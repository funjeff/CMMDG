package hazards;

import engine.GameCode;
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
		this.setHitboxAttributes(11, 5, 8, 23);
		
		int randChance = r.nextInt(10);
		
		if (randChance == 0) {
			int gnomeSound = r.nextInt(4);
			switch (gnomeSound) {
			case 0: 
				GameCode.getSoundPlayer().playSoundEffect(6f, "resources/sounds/Gnome 1.wav");
				break;
			case 1: 
				GameCode.getSoundPlayer().playSoundEffect(6f, "resources/sounds/Gnome 2.wav");
				break;
			case 2: 
				GameCode.getSoundPlayer().playSoundEffect(6f, "resources/sounds/Gnome 3.wav");
				break;
			case 3: 
				GameCode.getSoundPlayer().playSoundEffect(6f, "resources/sounds/Gnome 4.wav");
				break;
			}
		}
		
	}
	public void frameEvent()
	{
		super.frameEvent();
		
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
