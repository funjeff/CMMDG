package chip;

import java.util.HashMap;
import java.util.Random;

import engine.GameObject;
import engine.Sprite;
import engine.SpriteParser;

public class Chip extends GameObject {
	
	Sprite chipSprite = new Sprite ("resources/chipSprites/chip.png");
	
	HashMap <String,Integer> emotionToMaxImage = new HashMap<String,Integer>(); 
	
	public Chip () {
		this.setSprite(new Sprite ("resources/sprites/chipWindow.txt"));
		this.getAnimationHandler().setFrameTime(100);
		this.setRenderPriority(1000);
		
		emotionToMaxImage.put("Angry", 5);
		emotionToMaxImage.put("Composed", 6);
		emotionToMaxImage.put("Confused", 6);
		emotionToMaxImage.put("Excited", 5);
		emotionToMaxImage.put("Happy", 4);
		emotionToMaxImage.put("Relaxed", 4);
		emotionToMaxImage.put("Serious", 4);
		
	}
	
	@Override
	public void draw() {
		super.draw();
		chipSprite.draw((int)this.getX() + 32,(int)this.getY() + 33);
	}
	
	public void setChipSprite (String emotion) {
		
		String toUse = emotion;
		
		Random r = new Random ();
		
		if (toUse.equals("any")) {
			switch (r.nextInt(7)) {
			case 0:
				toUse = "Angry";
				break;
			case 1:
				toUse = "Composed";
				break;
			case 2:
				toUse = "Confused";
				break;
			case 3:
				toUse = "Excited";
				break;
			case 4:
				toUse = "Happy";
				break;
			case 5:
				toUse = "Relaxed";
				break;
			case 6:
				toUse = "Serious";
				break;
			}	
		}
		
		this.setSprite(new Sprite("resources/chipSprites/" + toUse + (r.nextInt(emotionToMaxImage.get(toUse) + 1) + ".png" )));
	}
	

}
