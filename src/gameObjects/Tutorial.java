package gameObjects;

import engine.GameObject;
import engine.Sprite;

public class Tutorial extends GameObject{

	String voiceLine1;
	
	
	
	public Tutorial() {
		this.setSprite(new Sprite ("resources/sprites/tutorialscreen.png"));
		
	}
	
	public void  init () {
		
	}
	
	@Override
	public void frameEvent () {
		
	}
	
	@Override
	public void draw () {
		this.draw();
	}
	
}
