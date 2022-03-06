package hazards;

import java.util.Random;

import engine.GameCode;
import engine.Sprite;
import gameObjects.Warning;
import map.Room;

public class Cats extends Hazard{
Random r = new Random();
double vy = 0.0;
double ay = 0.0;
	public Cats()
	{
		int rand = r.nextInt(4);
		switch (rand)
		{
		case 0:
			this.setSprite(new Sprite ("resources/sprites/FallingCat.txt"));
			break;
		case 1:
			this.setSprite(new Sprite ("resources/sprites/FallingCatStriped.txt"));
			break;
		case 2:
			this.setSprite(new Sprite ("resources/sprites/FallingCat.txt"));
			this.getAnimationHandler().setFlipHorizontal(true);
			break;
		case 3:
			this.setSprite(new Sprite ("resources/sprites/FallingCatStriped.txt"));
			this.getAnimationHandler().setFlipHorizontal(true);
		}
		this.setHitboxAttributes(0, 0, 32, 32);
	}
	public void draw()
	{
		try {
			if (warn.isDone())
			{
				super.draw();
			}
		} catch (NullPointerException e) {
			
		}
	}
	public void frameEvent()
	{
		if(warn.isDone())
		{
			if (Room.isColliding(this))
			{
				forget();
				GameCode.getSoundPlayer().playSoundEffect(3f, "resources/sounds/cat_growl1.wav");
			}
			if (ay < 2) {
				ay = ay + 0.1;
			}
			vy = vy + ay;
			this.setY(this.getY() + vy);
		}
	}
	public void spawnHazard()
	{
		Random r = new Random();
		int amountOfCats = r.nextInt(5) + 5;
		for (int i = 0; i < amountOfCats; i++) {
			Cats c = new Cats ();
			c.warn = new Warning(100, 2);
			c.warn.declare();
			c.declare();
			int xPos = r.nextInt(245);
			c.warn.setX(xPos);
			c.warn.setY(0);
			c.setX(xPos);
			c.setY(0);
		}
	}
}
//room.isColliding() - returns boolean