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
		//TODO add chip images into chip images arrayList
		
		chipImages.add("resources/chipSprites/tutorialChip3.png");
		chipImages.add("resources/chipSprites/tutorialChip6.png");
		chipImages.add("resources/chipSprites/tutorialChip2.png");
		chipImages.add("resources/chipSprites/tutorialChip4.png");
		chipImages.add("resources/chipSprites/tutorialChip5.png");
		chipImages.add("resources/chipSprites/tutorialChip4.png");
		chipImages.add("resources/chipSprites/tutorialChip1.png");
		
		chipImages.add("resources/chipSprites/tutorialChip7.png");
		
		
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
//				GameCode.enterTitleScreen();
//			}
//		}
	}
	
	@Override
	public void draw () {
		super.draw();
		t.draw();
	}
	
}
