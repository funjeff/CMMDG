package gameObjects;

import engine.GameObject;
import engine.Sprite;

public class Warning extends GameObject {
	int despawnTimer = 0;
	int ogTime = 0;
	public Warning (int time) {
		ogTime = time;
		this.setSprite(new Sprite ("resources/sprites/Warning.png"));
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