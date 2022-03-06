package hazards;

import engine.GameCode;
import engine.GameObject;
import gameObjects.Warning;

public class Hazard extends GameObject {
	Warning warn;
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
