package hazards;

import engine.Sprite;

public class Flag extends Hazard
{
	int counter;
	public Flag(double d, double e)
	{
		this.setSprite(new Sprite("resources/sprites/Flag.png"));
		this.setHitbox(0,0,32,32);
		this.setX(d + 51);
		this.setY(e + 11);
		this.setDrawRotation(45);
	}
	public void draw()
	{
		super.draw();
	}
	public void frameEvent()
	{
		counter += 1;
		super.frameEvent();
		this.setDrawRotation(counter);
		this.setX(this.getX() + 10);
		this.setY(this.getY() + 4);
		if (this.getX() >= 230)
		{
			forget();
		}
	}
}
