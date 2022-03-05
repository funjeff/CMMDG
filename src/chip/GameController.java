package chip;

import java.util.Random;

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
	
	Chip c;
	
	public GameController () {
		c = new Chip();
		c.declare();
		c.setX(270);
		c.setY(40);
		
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
		
		Random r = new Random ();
		int news = r.nextInt(6) + 1;
		switch (news) {
			case 1:
				Car c = new Car ();
				c.spawnHazard();
				break;
			case 2:
				Flood f = new Flood();
				f.declare();
				break;
			case 3:
				Meteor m = new Meteor ();
				m.spawnHazard();
				break;
			case 4:
				Pointer p = new Pointer ();
				p.declare();
				break;
			case 5:
				Shark s = new Shark (r.nextBoolean());
				s.declare();
				break;
			case 6:
				Tornado t = new Tornado (r.nextBoolean());
				t.declare();
				break;
			case 7:
				Drill d = new Drill();
				d.spawnHazard();
				break;
		}
	}
	
	public void levelUp () {
		if (AILevel > 0) {
			AILevel = AILevel -1;
		}
	}

}