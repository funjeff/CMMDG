package gameObjects;

import java.util.ArrayList;

import engine.GameCode;
import engine.GameObject;
import engine.Sprite;

public class ChipCountdown extends GameObject{

	ArrayList <String> voiceLines = new ArrayList<String>();
	ArrayList <String> chipImages = new ArrayList <String>();
	
	
	boolean isDone = false;
	
	TutorialChip t = new TutorialChip();
	
	
	int curLine = 0;
	int timer = 0;
	
	public ChipCountdown() {
		this.setSprite(new Sprite ("resources/sprites/tutorialscreen.png"));
	}
	
	public void  init () {
		//TODO add voiceLines into voiceLine arrayList 
		//TODO add chip images into chip images arrayList
		
		chipImages.add("resources/chipSprites/5.png");
		chipImages.add("resources/chipSprites/4.png");
		chipImages.add("resources/chipSprites/3.png");
		chipImages.add("resources/chipSprites/2.png");
		chipImages.add("resources/chipSprites/1.png");
		
		t.setSprite(new Sprite (chipImages.get(0)));
		
		//TODO play first voiceLine
		t.setX(45);
	}
	
	@Override
	public void frameEvent () {
//		timer = timer + 1;
//		if (timer > 30 && GameCode.getSoundPlayer().getClip(voiceLines.get(curLine)) == null ) {
//			if (curLine != voiceLines.size()) {
//				curLine = curLine + 1;
//				timer = 0;
//				this.setSprite(new Sprite (chipImages.get(curLine)));				
//			} else {
//				isDone = true;
//			}
//		}
	}
	
	@Override
	public void draw () {
		super.draw();
		t.draw();
	}
	
	public boolean isDone () {
		return isDone;
	}
	
}
