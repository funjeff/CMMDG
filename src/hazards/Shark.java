package hazards;

import engine.Sprite;
import engine.GameCode;

public class Shark extends Hazard{
	
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
		GameCode.getSoundPlayer().playSoundEffect(6f, "resources/sounds/Shark_exiting_water.wav");
		
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
//			angle = 90;
//			originalX = 0;
		}
	}
	
	
	@Override
	public void frameEvent () {
		super.frameEvent();
		
		if (!this.getAnimationHandler().flipHorizontal()) {
			this.setX(this.getX() + 10);
			this.setY(this.getY() - ((double)yDisplace/xDisplace) * 10);
			

			if (totalMoveY > yDisplace) {
				this.setY(this.getY() + ((double)yDisplace/xDisplace) * 20);
			} else {
				this.setY(this.getY() - ((double)yDisplace/xDisplace) * 20);
			}
			totalMoveY = (int) (totalMoveY + ((double)yDisplace/xDisplace) * 20);
			totalMoveX = totalMoveX + 10;
			if (totalMoveX > xDisplace) {
				forget();
			}
//			angle = angle + (180/time);
//			if (angle > 270) {
//				forget();
//			}
		} else {
			this.setX(this.getX() - 10);
			
			if (totalMoveY > yDisplace) {
				this.setY(this.getY() + ((double)yDisplace/xDisplace) * 20);
			} else {
				this.setY(this.getY() - ((double)yDisplace/xDisplace) * 20);
			}
			totalMoveY = (int) (totalMoveY + ((double)yDisplace/xDisplace) * 20);
			totalMoveX = totalMoveX + 10;
			
			if (totalMoveX > xDisplace) {
				forget();
			}
//			angle = angle - (180/time);
//			System.out.println(angle);
//			if (angle<90) {
//				forget();
//			}
		}
//		this.setX(originalX * Math.cos(angle * (Math.PI/180)));
//		this.setY(originalY * Math.sin(angle* (Math.PI/180)));
		
	}
	
	

}
