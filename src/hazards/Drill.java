package hazards;

import java.util.Random;

import engine.GameCode;
import engine.Sprite;
import gameObjects.Warning;
public class Drill extends Hazard {
	Random r = new Random();
	public Drill () {
		this.setSprite(new Sprite ("resources/sprites/Drill.txt"));	
		this.getAnimationHandler().setRepeat(false);
		this.setY(190 + r.nextInt(10));
		this.setX(r.nextInt(225));
		this.setHitbox(0, 0, 32, 32);
		this.enablePixelCollisions();

		this.setRenderPriority(-1);
	}
	
	@Override
	public void frameEvent () {
		super.frameEvent();
		boolean spawnedGnome = true;
		if (warn.isDone())
		{
			this.getAnimationHandler().setFrameTime(50);
			if (this.getAnimationHandler().getFrame() >= 32)
			{
				forget();
			}
			if (this.getAnimationHandler().getFrame() >= 29 && spawnedGnome)
			{
				Gnome g = new Gnome();
				g.declare();
				spawnedGnome = false;
			}
		}
		
	}
	
	public void spawnHazard() {
		int amountOfDrils = r.nextInt(5) + 5;
		int xpos[] = new int[amountOfDrils];
		for (int i = 0; i < amountOfDrils; i++)
		{
			xpos[i] = 0;
		}
		for (int i = 0; i < amountOfDrils; i++) {
			Drill d = new Drill();
			d.declare();
			d.warn = new Warning(100, 3);
			d.warn.declare();
			int temp;
			boolean Pos = false;
			while(!Pos)
			{
				temp = r.nextInt(225);
				Pos = true;
				for (int j = 0; j < xpos.length; j++)
				{
					if (xpos[j] + 20 >= temp && xpos[j] - 20 <= temp)
					{
						Pos = false;
					}
				}
				if (Pos)
				{
					xpos[i] = temp;
					d.setX(temp);
					int yPos = 190 + r.nextInt(10);
					d.setY(yPos);
					d.warn.setX(temp);
					d.warn.setY(yPos);
				}
			}
			
		
		}
	
	}
	@Override
	public void draw () {
		if (warn.isDone()) {
			super.draw();
		} 
	}
}