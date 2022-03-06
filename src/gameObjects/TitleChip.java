package gameObjects;

import engine.GameObject;
import engine.Sprite;

public class TitleChip extends GameObject {

	public TitleChip () {
		this.setSprite(new Sprite ("resources/sprites/titleChip.txt"));
		this.getAnimationHandler().setRepeat(false);
		this.getAnimationHandler().setFrameTime(200);
	}
	
	
}
