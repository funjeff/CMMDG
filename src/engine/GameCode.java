package engine;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import chip.Chip;
import chip.GameController;
import chip.ScrollingText;
import gameObjects.GameOverScreen;
import gameObjects.Jumpscare;
import gameObjects.Reporter;
import gameObjects.TitleScreen;
import hazards.Car;
import hazards.Cats;
import hazards.Flood;
import hazards.FloridaMan;
import hazards.Meteor;
import hazards.Shark;
import hazards.Tornado;
import hazards.Drill;
import hazards.Gnome;
import map.Room;



public class GameCode {
	
	static int veiwX;
	static int veiwY;
	
	static long frameCount = 0;
	static long previousNewscast = 0;
	
	static Reporter playableR;
	static Chip chip;
	
	static GameController c;

	static SoundPlayer s;
	
	static Sprite textTicker;
	static ScrollingText ticker;

	static boolean mainScreen = false;
	static boolean gameOverScreen = false;
	static boolean titleScreen = true;
	
	static boolean jumpscareMode = false;
	
	static GameOverScreen over;
	static TitleScreen title;
	
	static Jumpscare jesus = new Jumpscare ();
	
	
	
	public static void testBitch () {
		
		
	}
	
	public static void beforeGameLogic () {
		
	}

	public static void afterGameLogic () {
		
	}

	public static void initTitle() {
		title = new TitleScreen();
		s = new SoundPlayer();
		title.init();
		
	}
	public static void initGameOver() {
		over = new GameOverScreen ();
		over.init();
	}
	public static void initGame () {
		Room.loadRoom("resources/maps/background.rmf");
		Reporter r = new Reporter();
		r.setX(130);
		r.setY(120);
		r.declare();
		playableR = r;
		c = new GameController();
	
		textTicker = new Sprite ("resources/sprites/scrollingtextbox.png");
		ticker = new ScrollingText();
		ticker.fillText();
	}
		
	
	
	public static void gameLoopFunc () {
		
		if (mainScreen && !jumpscareMode) {
		
			frameCount = frameCount + 1;
			ObjectHandler.callAll();
			
			if (frameCount > previousNewscast + 60) {
				c.attemptNewscast();
				previousNewscast = frameCount;
			}
			ticker.incrementText();
			attemptJumpscare();
		}
		
		
		if (titleScreen) {
			title.frameEvent();
		}
		if (gameOverScreen) {
			over.frameEvent();
		}
		
	}
	
	public static void renderFunc () {
		if (mainScreen) {
			Room.render();
			ObjectHandler.renderAll();
			textTicker.draw(0, 280);
			ticker.drawText();
			
		}
		if (jumpscareMode) {
			if (!jesus.isDone()) {
				jesus.draw();
			} else {
				jumpscareMode = false;
			}
		}
		
		if (titleScreen) {
			title.draw();
		}
		if (gameOverScreen) {
			over.draw();
		}
	}
	
	public static void beforeRender() {
		
	}
	
	public static void afterRender()
	{
		
	}
		
	
	public static int getViewX() {
		return veiwX;
	}



	public static void setViewX(int newVeiwX) {
		veiwX = newVeiwX;
	}



	public static int getViewY() {
		return veiwY;
	}



	public static void setViewY(int newVeiwY) {
		veiwY = newVeiwY;
	}



	public static SoundPlayer getSoundPlayer () {
		return s;
	}
	
	public static void attemptJumpscare () {
		Random r = new Random ();
		if (r.nextInt(10000) == 69) {
			doJumpscare();
		}
	}
	
	public static void doJumpscare() {
		jumpscareMode = true;
		jesus.init();
	}
	
	public static void startGame() {
		initGame();
		mainScreen = true;
		titleScreen = false;
		gameOverScreen = false;
	}
	
	public static void enterTitleScreen () {
		initTitle();
		mainScreen = false;
		titleScreen = true;
		gameOverScreen = false;
	}
	
	public static void enterGameOverScreen () {
		initGameOver();
		mainScreen = false;
		titleScreen = false;
		gameOverScreen = true;
	}
	

	public static long getFrameNum() {
		// TODO Auto-generated method stub
		return frameCount;
	}	
	
	public static Reporter getReporter () {
		return playableR;
	}
	
}
