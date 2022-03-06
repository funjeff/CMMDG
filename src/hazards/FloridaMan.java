package hazards;

import java.util.Random;

import engine.GameCode;
import engine.Sprite;
import gameObjects.Warning;

public class FloridaMan extends Hazard {
	int counter;
	Random r = new Random();
	public FloridaMan()
	{
		this.setSprite(new Sprite("resources/sprites/floridaman.txt"));
		this.getAnimationHandler().setFlipHorizontal(true);
		this.setY(38);
		this.setX(0);
		this.warn = new Warning(100, 0);
		this.warn.setX(0);
		this.warn.setY(70);
		this.warn.declare();
		
		int randChance = r.nextInt(1);
		
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
	public void draw()
	{
		if (warn.isDone())
		{
			super.draw();
		}
	}
	public void frameEvent()
	{ 
		super.frameEvent();
		if (warn.isDone())
		{
			this.getAnimationHandler().setFrameTime(300);
			if (this.getAnimationHandler().getFrame() >= 3)
			{
				forget();
				Flag f = new Flag(this.getX(), this.getY());
				f.declare();
			}
		}
		else this.getAnimationHandler().setAnimationFrame(0);
	}
	
}
