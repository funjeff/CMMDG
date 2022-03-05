package hazards;

import java.util.Random;

import engine.GameCode;
import engine.Sprite;

public class Flood extends Hazard{
	int underwaterTime;
	boolean goingDown = false;
	public Flood () {
		this.setSprite(new Sprite ("resources/sprites/largeflood.png"));
		this.setY(280);
		Random r = new Random ();
		underwaterTime = r.nextInt(120) + 60;
	}
	
	@Override
	public void frameEvent () {
		if (!goingDown) {
			if (this.getY() > 0) {
				this.setY(this.getY() - 14);
			} else {
				GameCode.getReporter().setUnderwater(true);
				underwaterTime = underwaterTime - 1;
				if (underwaterTime < 0) {
					goingDown = true;
					
				}
			}
		} else {
			this.setY(this.getY() + 14);
			if (this.getY() > 280) {
				GameCode.getReporter().setUnderwater(false);
				forget();
			}
		}
		
	}
	
}
