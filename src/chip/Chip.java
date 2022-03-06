package chip;

import java.util.HashMap;
import java.util.Random;

import engine.GameObject;
import engine.Sprite;
import engine.SpriteParser;

public class Chip extends GameObject {
	
	Sprite chipSprite = new Sprite ("resources/chipSprites/chipComposed1.png");
	
	HashMap <String,Integer> emotionToMaxImage = new HashMap<String,Integer>(); 
	
	public Chip () {
		this.setSprite(new Sprite ("resources/sprites/chipWindow.txt"));
		this.getAnimationHandler().setFrameTime(100);
		this.setRenderPriority(1000);
		
		emotionToMaxImage.put("Angry", 12);
		emotionToMaxImage.put("Composed", 9);
		emotionToMaxImage.put("Confused", 11);
		emotionToMaxImage.put("Excited", 8);
		emotionToMaxImage.put("Happy", 7);
		emotionToMaxImage.put("Relaxed", 6);
		emotionToMaxImage.put("Serious", 6);
		
	}
	
	@Override
	public void draw() {
		super.draw();
		chipSprite.draw((int)this.getX() + 32,(int)this.getY() + 33);
	}
	
	public void setChipSprite (String emotion) {
		
		if (emotion.equals("Happy") || emotion.equals("Angry") || emotion.equals("Composed") || emotion.equals("Confused") || emotion.equals("Excited") || emotion.equals("Relaxed") || emotion.equals("Serious") || emotion.equals("any")) {
		
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
		
		chipSprite = new Sprite("resources/chipSprites/chip" + toUse + ((r.nextInt(emotionToMaxImage.get(toUse)) + 1) + ".png" ));
		} else {
			chipSprite = new Sprite("resources/chipSprites/" + emotion +".png" );
		}
	}
	

}
