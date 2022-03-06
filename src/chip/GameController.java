package chip;

import java.util.ArrayList;
import java.util.Random;

import engine.GameCode;
import hazards.Car;
import hazards.Cats;
import hazards.Drill;
import hazards.Flood;
import hazards.Meteor;
import hazards.Pointer;
import hazards.Shark;
import hazards.Tornado;
import hazards.FloridaMan;

public class GameController {
	
	int AILevel = 12;
	int newsCasts = 0;
	
	
	String prevLine = "init";
	
	ArrayList <ArrayList <ChipLine>> hazardLines = new ArrayList <ArrayList <ChipLine>>();
	
	Chip c;
	
	public GameController () {
		c = new Chip();
		c.declare();
		c.setX(270);
		c.setY(40);
		initChipLines();
		
	}
	
	public void initChipLines() {
		//put car lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		hazardLines.get(0).add(new ChipLine("resources/sounds/Car Chase/Car Chase 2 Charles Scene.wav","Composed"));
		hazardLines.get(0).add(new ChipLine("Car Chase 3 Man Behind Slaughter.wav","Confused"));
		
		
		//put flood lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		hazardLines.get(1).add(new ChipLine("resources/sounds/Flood/Flood 1 Rapid Displace.wav","Relaxed"));
		hazardLines.get(1).add(new ChipLine("resources/sounds/Flood/Flood 2 Electrocute.wav","Happy"));
		hazardLines.get(1).add(new ChipLine("resources/sounds/Flood/Flood 3 Wet.wav","Angry"));
		
		
		//put meteor lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		hazardLines.get(2).add(new ChipLine("resources/sounds/Meteors/Meteors 1 Thoughts.wav","Angry"));
		hazardLines.get(2).add(new ChipLine("resources/sounds/Meteors/Meteors 2 Boned.wav","Confused"));
		hazardLines.get(2).add(new ChipLine("resources/sounds/Meteors/Meteors 3 Mom.wav","Excited"));
		hazardLines.get(2).add(new ChipLine("resources/sounds/Meteors/Meteors 4 End LIfe.wav","Excited"));
		
		
		//put pointer lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		
		
		//put shark lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		hazardLines.get(4).add(new ChipLine("resources/sounds/Shark/Shark 1 High Risk.wav","Composed"));
		hazardLines.get(4).add(new ChipLine("resources/sounds/Shark/Shark 2 Shark Week.wav","Excited"));
		hazardLines.get(4).add(new ChipLine("resources/sounds/Shark/Shark 3 Flying Sharks.wav","Confused"));
		
		
		
		//put tornado lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		hazardLines.get(5).add(new ChipLine("resources/sounds/Tornado/Tornado 1 on the scene.wav","Serious"));
		hazardLines.get(5).add(new ChipLine("resources/sounds/Tornado/Tornado 2 Approaching Publix.wav","Confused"));
		hazardLines.get(5).add(new ChipLine("resources/sounds/Tornado/Tornado 3 Not you Charles.wav","Relaxed"));
		hazardLines.get(5).add(new ChipLine("resources/sounds/Tornado/Tornado 4 200 miles per hour.wav","Confused"));
		
		
		
		//put drill lines here
		hazardLines.add(new ArrayList <ChipLine>());
		
		hazardLines.get(6).add(new ChipLine("resources/sounds/Gnome-Drill/Gnome-Drill 1 Grab Guns.wav","Angry"));
		hazardLines.get(6).add(new ChipLine("resources/sounds/Gnome-Drill/Gnome-Drill 2 Publix Gnomes.wav","any"));
		hazardLines.get(6).add(new ChipLine("resources/sounds/Gnome-Drill/Gnomes-Drill 3 Just Another Day.wav","Relaxed"));	
		
		
		//put florada man lines here
		
		hazardLines.add(new ArrayList <ChipLine>());
		
		
		//put cats lines here
		
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
//			case 4:
//				Pointer p = new Pointer ();
//				p.declare();
//				newLine = hazardLines.get(3).get(r.nextInt(hazardLines.get(3).size()));
//				break;
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
//			case 8:
//				FloridaMan florida = new FloridaMan();
//				florida.declare();
//				newLine = hazardLines.get(8).get(r.nextInt(hazardLines.get(8).size()));
//				break;
//			case 9:
//				Cats cats = new Cats();
//				cats.spawnHazard();
//				newLine = hazardLines.get(9).get(r.nextInt(hazardLines.get(9).size()));
//				break;
				
		}
		if ((GameCode.getSoundPlayer().getClip(prevLine) == null || prevLine.equals("init")) && newLine != null) {
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
