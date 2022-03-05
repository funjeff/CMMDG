package hazards;

import engine.Sprite;

public class Car extends Hazard {

	
	public Car () {
		this.setX(0);
	}
	
	public Car (boolean flip, boolean sprite) {
		this.setX(0);
		this.setY(160);
		if (sprite) {
			this.setSprite(new Sprite("resources/sprites/policeCar.txt"));
			this.getAnimationHandler().setFrameTime(100);
		} else {
			this.setSprite(new Sprite("resources/sprites/regularCar.txt"));
		}
		this.getAnimationHandler().setFlipHorizontal(true);
		if (flip) {
			this.setX(245);
			this.getAnimationHandler().setFlipHorizontal(false);
		}
	}
	
	@Override
	public void frameEvent () {
		if (!this.getAnimationHandler().flipHorizontal()) {
			this.setX(this.getX() - 20);
			if (this.getX() <  0) {
				forget();
			}
		} else {
			this.setX(this.getX() + 20);
			if (this.getX() >  245) {
				forget();
			}
		}
	}
	
	
}
