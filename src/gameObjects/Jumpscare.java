package gameObjects;

import java.util.Random;

import engine.GameCode;
import engine.GameObject;
import engine.Sprite;

public class Jumpscare extends GameObject {
	int timer = 0;
	public Jumpscare () {
		this.setSprite(new Sprite ("resources/sprites/smilingjesus.png"));
		this.setRenderPriority(15);
		
	}
	public void init () {
		GameCode.getSoundPlayer().playSoundEffect(4F,"resources/sounds/alrightsonny.wav");
		this.setX(100);
		this.setY(50);
	}
	@Override
	public void draw () {
		timer = timer +1;
		Random r = new Random ();
		if (timer %(r.nextInt(5)+1) == 0) {
			super.draw();
		}
	}
	
	public boolean isDone () {
		if (timer > 45 && GameCode.getSoundPlayer().getClip("resources/sounds/alrightsonny.wav") == null) {
			return true;
		}
		return false;
	}
	
}
