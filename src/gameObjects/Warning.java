package gameObjects;

import engine.GameObject;
import engine.Sprite;

public class Warning extends GameObject {
	int timeLeft = 0;
	public Warning (int time) {
		time = timeLeft;
		this.setSprite(new Sprite ("resources/sprites/Warning.png"));
	}

}
