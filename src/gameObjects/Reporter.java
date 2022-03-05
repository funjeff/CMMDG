package gameObjects;

import engine.GameObject;
import engine.Sprite;
import map.MapTile;
import map.Room;

public class Reporter extends GameObject {
	
	boolean isJumping = false;
	boolean isWalking = false;
	
	double vy = 0;
	double vx = 0;
	
	double ax = 0;

	public static final double TERMINAL_VELOCITY = 15;
	public static final double JUMP_VELOCITY = 12.15625;
	
	public Reporter() {
		this.setSprite(new Sprite ("resources/sprites/reporter.png"));
		this.setHitboxAttributes(4, 4, 7, 27);
	}
	
	
	@Override
	public void frameEvent () {
		if (keyDown(32) && !isJumping && vy == 0) {
			
			isJumping = true;
			vy = -JUMP_VELOCITY;
			//setSprite (walkSprite);
			//getAnimationHandler ().setFrameTime (0);
			//getAnimationHandler ().setAnimationFrame (3);
		}
		
		//moves left and right
		if ( keyDown ('A')) {
			vx = -4;
			this.getAnimationHandler().setFlipHorizontal (true);
			if (vy == 0 && !isWalking) {
				isWalking = true;
				//setSprite (walkSprite);
			}
		} else if (keyDown ('D')) {
			
			vx = 4;
			
			
			this.getAnimationHandler().setFlipHorizontal (false);
			
			if (vy == 0 && !isWalking) {
				isWalking = true;
				//setSprite (walkSprite);
			}
		} else {
			if (isWalking) {
				isWalking = false;
				//setSprite (standSprite);
			}
		}
		
		if (keyDown(32)) {
			vy += Room.getGravity ();
		} else {
			vy += (Room.getGravity ());
		}
	
		if (vy > TERMINAL_VELOCITY) {
			vy = TERMINAL_VELOCITY;
		}
		
		//actually does the falling
			setY (getY () + vy);
			
			//deals with friction and getting stuck in the floor
			if (Room.isColliding(this)) {
				vy = 0;
				double fc = .2; //Friction coefficient\
				if (vx > 0) {
					vx -= fc;
					if (vx < 0) {
						vx = 0;
					}
				} else if (vx < 0) {
					vx += fc;
					if (vx > 0) {
						vx = 0;
					}
				}
				MapTile[] collidingTiles = Room.getCollidingTiles (this);
				for (int i = 0; i < collidingTiles.length; i++) {
				    if (getY () + 32 >= collidingTiles [i].y && getY () + 32 <= collidingTiles [i].y + 16) {
				        this.setY (collidingTiles [i].y - 32);
				        this.vy = 0;
				    	getAnimationHandler ().setFrameTime (50);
				    	if (isJumping) {
				    		//this.setSprite(standSprite);
				    		isWalking = false;
				    	}
				        isJumping = false;
				        break;
				    }
				    if (getY () + this.getHitboxYOffset() >= collidingTiles [i].y && getY () + this.getHitboxYOffset() <= collidingTiles [i].y + 16) {
				        this.setY (collidingTiles [i].y + 16);
				        break;
				    }
				}
			}
			
			if (!this.goX (this.getX () + vx)) {
				vx = 0;
			}
	}
	
	public void getKilled () {
		
	}
	
}
