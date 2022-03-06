package gameObjects;

import engine.GameObject;
import engine.Textbox;

public class Timer extends GameObject {
	long startTime = 0;
	Textbox t;
	
	public Timer () {
		startTime = System.currentTimeMillis();
		t = new Textbox ("example");
		t.changeBoxVisability();
		t.setX(270);
		t.setY(20);
	}
	
	
	@Override
	public void draw (){
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		int elaspsedSeconds = (int)(elapsedTime/1000);
		
		int elapsedMinutes = (int)(elaspsedSeconds/60);
		
		elaspsedSeconds = elaspsedSeconds - (elapsedMinutes * 60);
		
		String text = "";
		
		if (elapsedMinutes >= 10) {
			text = text + elapsedMinutes;
		} else {
			text = text + "0" +elapsedMinutes;
		}
		
		text = text + ":";
		
		if (elaspsedSeconds >= 10) {
			text = text + elaspsedSeconds;
		} else {
			text = text + "0" +elaspsedSeconds;
		}
	
		t.changeText(text);
		
		t.draw();
		
	}
	
	
	public int getElapsedSeconds () {
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		int elaspsedSeconds = (int)(elapsedTime/1000);
		
		return elaspsedSeconds;
		
	}
	
	public String getTimeString() {
		long elapsedTime = System.currentTimeMillis() - startTime;
		
		int elaspsedSeconds = (int)(elapsedTime/1000);
		
		int elapsedMinutes = (int)(elaspsedSeconds/60);
		
		elaspsedSeconds = elaspsedSeconds - (elapsedMinutes * 60);
		
		String text = "";
		
		if (elapsedMinutes >= 10) {
			text = text + elapsedMinutes;
		} else {
			text = text + "0" +elapsedMinutes;
		}
		
		text = text + ":";
		
		if (elaspsedSeconds >= 10) {
			text = text + elaspsedSeconds;
		} else {
			text = text + "0" +elaspsedSeconds;
		}
		return text;
	}

}
