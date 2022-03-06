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
		
	}
	
	public void  init () {
		//TODO add voiceLines into voiceLine arrayList 
		
		voiceLines.add("resources/sounds/Countdown/Countdown 1.wav");
		voiceLines.add("resources/sounds/Countdown/Countdown 2.wav");
		voiceLines.add("resources/sounds/Countdown/Countdown 3.wav");
		voiceLines.add("resources/sounds/Countdown/Countdown 4.wav");
		voiceLines.add("resources/sounds/Countdown/Countdown 5.wav");
		voiceLines.add("resources/sounds/Countdown/Countdown 6.wav");
		
		//TODO add chip images into chip images arrayList
		
		chipImages.add("resources/chipSprites/5.png");
		chipImages.add("resources/chipSprites/4.png");
		chipImages.add("resources/chipSprites/3.png");
		chipImages.add("resources/chipSprites/2.png");
		chipImages.add("resources/chipSprites/1.png");
		chipImages.add("resources/chipSprites/tutorialChip3.png");
		
		
		t.setSprite(new Sprite (chipImages.get(0)));
		
		GameCode.getSoundPlayer().playSoundEffect(4F,voiceLines.get(0));
		
		//TODO play first voiceLine
		t.setX(45);
	}
	
	@Override
	public void frameEvent () {
		timer = timer + 1;
		if (timer > 5 && GameCode.getSoundPlayer().getClip(voiceLines.get(curLine)) == null ) {
			curLine = curLine + 1;
			if (curLine != voiceLines.size()) {
				GameCode.getSoundPlayer().playSoundEffect(4F, voiceLines.get(curLine));
				timer = 0;
				t.setSprite(new Sprite (chipImages.get(curLine)));				
			} else {
				isDone = true;
			}
		}
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
