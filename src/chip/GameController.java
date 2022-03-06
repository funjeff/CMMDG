package chip;

import java.util.ArrayList;
import java.util.Random;

import engine.GameCode;
import hazards.Car;
import hazards.Drill;
import hazards.Flood;
import hazards.Meteor;
import hazards.Pointer;
import hazards.Shark;
import hazards.Tornado;

public class GameController {
	
	int AILevel = 12;
	int newsCasts = 0;
	
	
	String prevLine;
	
	ArrayList <ArrayList <ChipLine>> hazardLines = new ArrayList <ArrayList <ChipLine>>();
	
	Chip c;
	
	public GameController () {
		c = new Chip();
		c.declare();
		c.setX(270);
		c.setY(40);
		
	}
	
	public void initChipLines() {
		//put car lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		
		
		//put flood lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		
		
		//put meteor lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		
		
		//put pointer lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		
		
		//put shark lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		
		//put tornado lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		
		//put drill lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
	}
	
	public void attemptNewscast() {
		Random r = new Random ();
		newsCasts = newsCasts + 1;
		if (newsCasts >= (20-AILevel)/2) {
			levelUp();
		}
		if (r.nextInt(19) + 1 <= 20 - AILevel) {
			castNews();
		}
	}
	
	public void castNews() {
		//TODO chip mcdale sprite and voiceline
		ChipLine newLine = null;
		
		
		Random r = new Random ();
		int news = r.nextInt(8) + 1;
		switch (news) {
			case 1:
				Car c = new Car ();
				c.spawnHazard();
				newLine = hazardLines.get(0).get(r.nextInt(hazardLines.get(0).size()));
				break;
			case 2:
				Flood f = new Flood();
				f.declare();
				newLine = hazardLines.get(1).get(r.nextInt(hazardLines.get(1).size()));
				break;
			case 3:
				Meteor m = new Meteor ();
				m.spawnHazard();
				newLine = hazardLines.get(2).get(r.nextInt(hazardLines.get(2).size()));
				break;
			case 4:
				Pointer p = new Pointer ();
				p.declare();
				newLine = hazardLines.get(3).get(r.nextInt(hazardLines.get(3).size()));
				break;
			case 5:
				Shark s = new Shark (r.nextBoolean());
				s.declare();
				newLine = hazardLines.get(4).get(r.nextInt(hazardLines.get(4).size()));
				break;
			case 6:
				Tornado t = new Tornado (r.nextBoolean());
				t.declare();
				newLine = hazardLines.get(5).get(r.nextInt(hazardLines.get(5).size()));
				break;
			case 7:
				Drill d = new Drill();
				d.spawnHazard();
				newLine = hazardLines.get(6).get(r.nextInt(hazardLines.get(6).size()));
				break;
			case 8:
				FlordaMan m = new FlordaMan ();
				
		}
		if (GameCode.getSoundPlayer().getClip(prevLine) == null) {
			GameCode.getSoundPlayer().playSoundEffect(4F, newLine.linePath);
			prevLine = newLine.linePath;
			c.setChipSprite(newLine.emotion);
			
		}
		
	}
	
	public void levelUp () {
		if (AILevel > 0) {
			AILevel = AILevel -1;
		}
	}

}
