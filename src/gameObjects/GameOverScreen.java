package gameObjects;

import java.util.Random;

import engine.GameCode;
import engine.GameObject;
import engine.Sprite;

import java.awt.event.KeyEvent;

public class GameOverScreen extends GameObject {
	
	String deathLine = "";
	
	EnterToStart e = new EnterToStart();
	
	int timer = 0;
	
	public GameOverScreen () {
		this.setSprite(new Sprite ("resources/sprites/gameoverscreen.png"));
	}
	public void init () {
		String voiceLine = "";
		Random r = new Random ();
		switch (r.nextInt(5)) {
		case 0:
			voiceLine = "Game Over 1 Forever.wav";
			break;
		case 1:
			voiceLine = "Game Over 2 Persona.wav";
			break;
		case 2:
			voiceLine = "Game Over 3 News is Life.wav";
			break;
		case 3:
			voiceLine = "Game Over 4 Funeral.wav";
			break;
		case 4:
			voiceLine = "Game Over 5 Sponsors.wav";
			break;
		}
		e.visible = false;
		e.setX(30);
		e.setY(220);
		
		deathLine = "resources/sounds/Game Over/" + voiceLine;
		GameCode.getSoundPlayer().playSoundEffect(4F,deathLine);
	}
	
	@Override
	public void frameEvent () {
		if (timer > 60 && GameCode.getSoundPlayer().getClip(deathLine) == null) {
			if (keyDown(KeyEvent.VK_ENTER)) {
				GameCode.startGame();
			}
			
			if (timer % 20 == 0) {
				e.visible = !e.visible;
			}
		}
		timer = timer + 1;
	}
	@Override
	public void draw () {
		super.draw();
		e.draw();
	}

}
