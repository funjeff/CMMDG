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
import gameObjects.ChipCountdown;
import gameObjects.GameOverScreen;
import gameObjects.Jumpscare;
import gameObjects.Reporter;
import gameObjects.Timer;
import gameObjects.TitleScreen;
import gameObjects.Tutorial;
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
	static Timer t;
	static ScrollingText ticker;

	static boolean mainScreen = false;
	static boolean gameOverScreen = false;
	static boolean titleScreen = true;
	static boolean tutorialScreen = false;
	
	static boolean chipCountDown;
	
	
	static int bestTime = 0;
	static String bestTimeString = "";
	
	
	static boolean jumpscareMode = false;
	
	static GameOverScreen over;
	static TitleScreen title;
	static Tutorial tutorial;
	
	static ChipCountdown cCountDown;
	
	static Jumpscare jesus = new Jumpscare ();
	
	
	
	public static void testBitch () {
		
		
	}
	
	public static void beforeGameLogic () {
		
	}

	public static void afterGameLogic () {
		
	}
	
	public static void initTutorial() {
		tutorial = new Tutorial();
		tutorial.init();
		
	}

	public static void initTitle() {
		title = new TitleScreen();
		s = new SoundPlayer();
		title.init();
		
		
	}
	public static void initGameOver() {
		s.stopAll();
		if (s.getClip(c.getPrevLine()) != null) {
			s.getClip(c.getPrevLine()).stop();
		}
		over = new GameOverScreen ();
		if (t.getElapsedSeconds() > bestTime) {
			bestTime = t.getElapsedSeconds();
			bestTimeString = t.getTimeString ();
		}
		
		s.stop();
		
		over.init(t.getTimeString(),bestTimeString);
	}
	public static void initGame () {
		Room.loadRoom("resources/maps/background.rmf");
		Reporter r = new Reporter();
		r.setX(130);
		r.setY(120);
		r.declare();
		playableR = r;
		c = new GameController();
		s.play("resources/sounds/wintersSong.wav", 3F);
		t = null;
		textTicker = new Sprite ("resources/sprites/scrollingtextbox.png");
		ticker = new ScrollingText();
		ticker.fillText();
		chipCountDown = true;
		cCountDown = new ChipCountdown();
		cCountDown.init();
	}
		
	
	
	public static void gameLoopFunc () {
		
		if (mainScreen && !jumpscareMode && !chipCountDown) {
		
			frameCount = frameCount + 1;
			ObjectHandler.callAll();
			
			if (frameCount > previousNewscast + 60) {
				c.attemptNewscast();
				previousNewscast = frameCount;
			}
			ticker.incrementText();
			attemptJumpscare();
		}
		
		if (chipCountDown) {
			cCountDown.frameEvent();
			if (cCountDown.isDone()) {
				chipCountDown = false;
				t = new Timer ();
			}
		}
		
		if (tutorialScreen) {
			tutorial.frameEvent();
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
			if (t != null) {
				t.draw();
			}
		}
		if (jumpscareMode) {
			if (!jesus.isDone()) {
				jesus.draw();
			} else {
				jumpscareMode = false;
			}
		}
		if (tutorialScreen) {
			tutorial.draw();
		}
		
		if (chipCountDown) {
			if (cCountDown != null) {
				cCountDown.draw();
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
		tutorialScreen = false;
	}
	
	public static void enterTitleScreen () {
		initTitle();
		mainScreen = false;
		titleScreen = true;
		gameOverScreen = false;
		tutorialScreen = false;
	}
	
	public static void enterGameOverScreen () {
		initGameOver();
		mainScreen = false;
		titleScreen = false;
		gameOverScreen = true;
		tutorialScreen = false;
	}
	public static void enterTutorial() {
		initTutorial();
		mainScreen = false;
		gameOverScreen = false;
		titleScreen = false;
		tutorialScreen = true;
	}
	

	public static long getFrameNum() {
		// TODO Auto-generated method stub
		return frameCount;
	}	
	
	public static Reporter getReporter () {
		return playableR;
	}
	
}
