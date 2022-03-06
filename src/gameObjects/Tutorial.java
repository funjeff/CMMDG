package gameObjects;

import java.util.ArrayList;

import engine.GameCode;
import engine.GameObject;
import engine.Sprite;

public class Tutorial extends GameObject{

	ArrayList <String> voiceLines = new ArrayList<String>();
	ArrayList <String> chipImages = new ArrayList <String>();
	
	TutorialChip t = new TutorialChip();
	
	
	int curLine = 0;
	int timer = 0;
	
	public Tutorial() {
		this.setSprite(new Sprite ("resources/sprites/tutorialscreen.png"));
	}
	
	public void  init () {
		//TODO add voiceLines into voiceLine arrayList 
		
		voiceLines.add("resources/sounds/Intro/Intro 1.wav");
		voiceLines.add("resources/sounds/Intro/Intro 2.wav");
		voiceLines.add("resources/sounds/Intro/Intro 3.wav");
		voiceLines.add("resources/sounds/Intro/Intro 4.wav");
		voiceLines.add("resources/sounds/Intro/Intro 5.wav");
		voiceLines.add("resources/sounds/Intro/Intro 6.wav");
		voiceLines.add("resources/sounds/Intro/Intro 7.wav");
		voiceLines.add("resources/sounds/Intro/Intro 8.wav");
		voiceLines.add("resources/sounds/Intro/Intro 9.wav");
		
		//TODO add chip images into chip images arrayList
		
		chipImages.add("resources/chipSprites/tutorialChip3.png");
		chipImages.add("resources/chipSprites/tutorialChip10.png");
		chipImages.add("resources/chipSprites/tutorialChip2.png");
		chipImages.add("resources/chipSprites/tutorialChip4.png");
		chipImages.add("resources/chipSprites/tutorialChip5.png");
		chipImages.add("resources/chipSprites/tutorialChip8.png");
		chipImages.add("resources/chipSprites/tutorialChip9.png");
		
		
		chipImages.add("resources/chipSprites/tutorialChip1.png");
		
		chipImages.add("resources/chipSprites/tutorialChip7.png");
		
		
		GameCode.getSoundPlayer().playSoundEffect(4F, voiceLines.get(0));
		
		
		t.setX(45);
	}
	
	@Override
	public void frameEvent () {
		timer = timer + 1;
		if (timer > 30 && GameCode.getSoundPlayer().getClip(voiceLines.get(curLine)) == null ) {
			curLine = curLine + 1;
			if (curLine != voiceLines.size()) {
				GameCode.getSoundPlayer().playSoundEffect(4F, voiceLines.get(curLine));
				timer = 0;
				t.setSprite(new Sprite (chipImages.get(curLine)));				
			} else {
				GameCode.enterTitleScreen();
			}
		}
	}
	
	@Override
	public void draw () {
		super.draw();
		t.draw();
	}
	
}
