package gameObjects;

import engine.GameCode;
import engine.GameObject;
import engine.Sprite;

public class Warning extends GameObject {
	int direction;
	int despawnTimer = 0;
	int ogTime = 0;
	static int soundsPlaying = 1;
	public Warning (int time, int direction) {
		ogTime = time;
//		this.direction = direction; //0 = west, 1 = east, 2 = north, 3 = south
		switch (direction)
		{
			case 0:
			{
				this.setSprite(new Sprite ("resources/sprites/Warning.png"));
				break;
			}
			case 1:
			{
				this.setSprite(new Sprite ("resources/sprites/Warning.png"));
				this.getAnimationHandler().setFlipHorizontal(true);
				break;
			}
			case 2:
			{
				this.setSprite(new Sprite ("resources/sprites/WarningN.png"));
				break;
			}
			case 3:
			{
				this.setSprite(new Sprite ("resources/sprites/WarningS.png"));
				break;
			}
				
		}
		
		if (soundsPlaying < 3) {
			GameCode.getSoundPlayer().playSoundEffect(3f, "resources/sounds/Warning Sound.wav");
			soundsPlaying++;
		}
		else {
			soundsPlaying--;
		}
	}
	
	@Override
	public void frameEvent () {
		if (despawnTimer != ogTime) {
			despawnTimer = despawnTimer + 1;
		} else {
			this.forget();
		}
		if (despawnTimer % (ogTime/despawnTimer) == 0) {
			this.visible = !this.visible;
		}
	}
	
	public boolean isDone () {
		return despawnTimer == ogTime;
	}
	
}