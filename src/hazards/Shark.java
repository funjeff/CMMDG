package hazards;

import engine.Sprite;
import gameObjects.Warning;
import engine.GameCode;

public class Shark extends Hazard{
	boolean sound = true;
	boolean bite = true;
//	int angle = 270;
//	
//	int time = 20;
//	
//	int originalX = 0;
//	int originalY = 0;
	int yDisplace = 50;
	int xDisplace = 245;
	
	int totalMoveX = 0;
	int totalMoveY = 0;
	
	public Shark () {
		this.setSprite(new Sprite ("resources/sprites/shark.txt"));
		this.setHitbox(0,0,32,32);
	}
	
	public Shark (boolean flip) {
		this.setSprite(new Sprite ("resources/sprites/shark.txt"));
		this.setHitbox(0,0,32,32);
		this.getAnimationHandler().setFrameTime(100);
//		originalX = 200; // change this later
//		originalY = 200;
		
		this.setY(200);
		this.setX(245);
		
		this.getAnimationHandler().setFlipHorizontal(true);
		if (flip) {
			this.getAnimationHandler().setFlipHorizontal(false);
			this.setX(0);
			this.warn = new Warning(100, 0);
			this.warn.declare();
			this.warn.setX(0);
			this.warn.setY(200);
//			angle = 90;
//			originalX = 0;
		}
		else
		{
			this.warn = new Warning(100, 1);
			this.warn.declare();
			this.warn.setX(245);
			this.warn.setY(200);
		}
		
	}
	
	public void draw()
	{
		if (warn.isDone())
		{
			if (sound)
			{
				GameCode.getSoundPlayer().playSoundEffect(3f, "resources/sounds/Shark_exiting_water.wav");
				sound = false;
			}
			super.draw();
		}
	}
	
	@Override
	public void frameEvent () {
		super.frameEvent();
		if (warn.isDone())
		{
			if (!this.getAnimationHandler().flipHorizontal()) {
				this.setX(this.getX() + 10);
				this.setY(this.getY() - ((double)yDisplace/xDisplace) * 10);
				

				if (totalMoveY > yDisplace) {
					this.setY(this.getY() + ((double)yDisplace/xDisplace) * 20);
				} else {
					if (bite)
					{
						GameCode.getSoundPlayer().playSoundEffect(3f, "resources/sounds/chomp.wav");
						bite = false;
					}
					this.setY(this.getY() - ((double)yDisplace/xDisplace) * 20);
				}
				totalMoveY = (int) (totalMoveY + ((double)yDisplace/xDisplace) * 20);
				totalMoveX = totalMoveX + 10;
				if (totalMoveX > xDisplace) {
					GameCode.getSoundPlayer().playSoundEffect(3f, "resources/sounds/Shark_entering_water.wav");
					forget();
				}
//				angle = angle + (180/time);
//				if (angle > 270) {
//					forget();
//				}
			} else {
				this.setX(this.getX() - 10);
				
				if (totalMoveY > yDisplace) {
					this.setY(this.getY() + ((double)yDisplace/xDisplace) * 20);
				} else {
					if (bite)
					{
						GameCode.getSoundPlayer().playSoundEffect(3f, "resources/sounds/chomp.wav");
						bite = false;
					}
					this.setY(this.getY() - ((double)yDisplace/xDisplace) * 20);
				}
				totalMoveY = (int) (totalMoveY + ((double)yDisplace/xDisplace) * 20);
				totalMoveX = totalMoveX + 10;
				
				if (totalMoveX > xDisplace) {
					System.out.println("yo mama");
					GameCode.getSoundPlayer().playSoundEffect(3f, "resources/sounds/Shark_entering_water.wav");
					forget();
				}
//				angle = angle - (180/time);
//				System.out.println(angle);
//				if (angle<90) {
//					forget();
//				}
			}
//			this.setX(originalX * Math.cos(angle * (Math.PI/180)));
//			this.setY(originalY * Math.sin(angle* (Math.PI/180)));
			
		}
		
	}
	
	

}
