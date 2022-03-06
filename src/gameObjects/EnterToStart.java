package gameObjects;

import engine.GameObject;
import engine.Sprite;

public class EnterToStart extends GameObject {
	
	public EnterToStart () {
		this.setSprite(new Sprite ("resources/sprites/pressenter.png"));
	}
}
