package chip;

import engine.GameObject;
import engine.Sprite;
import engine.SpriteParser;

public class Chip extends GameObject {
	
	Sprite chipSprite = new Sprite ("resources/chipSprites/chip.png");
	
	public Chip () {
		this.setSprite(new Sprite ("resources/sprites/chipWindow.txt"));
		this.getAnimationHandler().setFrameTime(100);
		this.setRenderPriority(1000);
	}
	
	@Override
	public void draw() {
		super.draw();
		chipSprite.draw((int)this.getX() + 32,(int)this.getY() + 33);
	}
	
	public 
	

}
