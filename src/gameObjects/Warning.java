package gameObjects;

import engine.GameObject;
import engine.Sprite;

public class Warning extends GameObject {
<<<<<<< HEAD
	int timeLeft = 0;
	public Warning (int time) {
		time = timeLeft;
		this.setSprite(new Sprite ("resources/sprites/Warning.png"));
	}

=======

	
	
	public Warning(int xpos, int ypos)
	{
		this.setX(xpos);
		this.setY(ypos);
	}
	
>>>>>>> 5d35381f2ae950ac91681aa9b86f9ca82cdeb675
}
