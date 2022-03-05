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
import gameObjects.Reporter;
import hazards.Car;
import hazards.Flood;
import hazards.Meteor;
import hazards.Shark;
import hazards.Tornado;
import map.Room;



public class GameCode {
	
	static int veiwX;
	static int veiwY;
	
	static long frameCount = 0;
	static long previousNewscast = 0;
	
	static Reporter playableR;
	static Chip chip;
	
	static GameController c;

	public static void testBitch () {
		
		
	}
	
	public static void beforeGameLogic () {
		
	}

	public static void afterGameLogic () {
		
	}

	public static void init () {
		Room.loadRoom("resources/maps/background.rmf");
		Reporter r = new Reporter ();
		r.setX(130);
		r.setY(120);
		r.declare();
		playableR = r;
		c = new GameController();
	}
		
	
	
	public static void gameLoopFunc () {
		frameCount = frameCount + 1;
		ObjectHandler.callAll();
		
		if (frameCount > previousNewscast + 60) {
			c.attemptNewscast();
			previousNewscast = frameCount;
		}
		
	}
	
	public static void renderFunc () {
		Room.render();
		ObjectHandler.renderAll();
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




	public static long getFrameNum() {
		// TODO Auto-generated method stub
		return frameCount;
	}	
	
	public static Reporter getReporter () {
		return playableR;
	}
	
}
