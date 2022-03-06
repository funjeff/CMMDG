package gameObjects;

import java.util.Random;

import engine.GameCode;
import engine.GameObject;
import engine.Sprite;

import java.awt.event.KeyEvent;

public class TitleScreen extends GameObject {
	
	String startLine = "";
	
	EnterToStart e = new EnterToStart();
	
	TitleChip t = new TitleChip ();
	
	int timer = 0;
	
	boolean saidLine = false;
	
	public TitleScreen () {
		this.setSprite(new Sprite ("resources/sprites/titlescreenreal1.png"));
	}
	public void init () {
		String voiceLine = "";
		Random r = new Random ();
		switch (r.nextInt(3)) {
		case 0:
			voiceLine = "Title Screen 1.wav";
			break;
		case 1:
			voiceLine = "Title Screen 2 News of the Day (singing).wav";
			break;
		case 2:
			voiceLine = "Title Screen 3 News of the Day.wav";
			break;
		}
		e.visible = false;
		e.setX(0);
		e.setY(260);
		
		t.setX(420);
		t.setY(220);
		
		startLine = "resources/sounds/Title Screen/" + voiceLine;
		
	}
	
	@Override
	public void frameEvent () {
		if (t.getAnimationHandler().getFrame() >=6 || saidLine) {
			if (!saidLine) {
				GameCode.getSoundPlayer().playSoundEffect(4F,startLine);
				saidLine = true;
			}
			
			if (timer > 60 && GameCode.getSoundPlayer().getClip(startLine) == null) {
				
				if (keyDown(KeyEvent.VK_ENTER)) {
					GameCode.startGame();
				}
				
				if (timer % 20 == 0) {
					e.visible = !e.visible;
				}
			}
			timer = timer + 1;
		}
	}
	@Override
	public void draw () {
		super.draw();
		t.draw();
		e.draw();
	}

}
