package hazards;

import engine.GameCode;
import engine.GameObject;

public class Hazard extends GameObject {

	public Hazard() {
		
	}

	@Override
	public void frameEvent () {
		if (this.isColliding(GameCode.getReporter())) {
			GameCode.getReporter().getKilled();
		}
	}
	
	public void spawnHazard() {
		
	}
}
