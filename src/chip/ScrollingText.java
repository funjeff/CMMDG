package chip;

import java.util.ArrayList;
import java.util.Random;

import engine.Textbox;

public class ScrollingText {

	Textbox t;
	
	String [] allTickerText = {
			"BREAKING: SEASONED REPORTER “CHIP MCDALE” FOUND GUILTY ON DOZENS OF COUNTS OF MURDER, ASSAULT, TAX EVASION, AND JAYWALKING.",
			"DEAR ALL WOMEN: POKEMON IS NOT A REAL GAME. ANIMAL CROSSING IS NOT A REAL GAME. THE SIMS IS NOT A REAL GAME. MARIO IS NOT A REAL GAME. STARDEW VALLEY IS NOT A REAL GAME. MOBILE GAMES ARE NOT.REAL.GAMES. ",
			"NEW LETTER ANNOUNCED: O 2. “A BREATH OF FRESH AIR,” SAYS LINGUIST. ",
			"MAN DECLINED LIVING IN AN APARTMENT COMPLEX. “WASN’T SIMPLE ENOUGH”, HE SAYS.",
			"SCIENTISTS STRUGGLE TO FIND THE ONE PERSON WHO ASKED",
			"CANDY: DANGEROUS OR DELICIOUS?",
			"ROBOTS ARE TAKING OUR JOBS",
			"JAGO TLALOC IS BACK FOR HIS SECOND TRIAL! WILL HE BE ABLE TO SKATE CIRCLES AROUND HIS NEWEST OPPONENT? OR WILL THE RUSSIAN CHAMPION SKATE CIRCLES AROUND HIM?",
			"AMAZON PLACES BET ON STREAMING, FAST-PACED MUSIC AWARDS SHOW",
			"FOR FAMILIES, $6B DEAL WITH OXYCONTIN MAKER IS JUST A START",
			"IDITAROD DOGS PACK ANCHORAGE FOR RACE'S CEREMONIAL START",
			"MAVERICKS OVERCOME 19-POINT DEFICIT TO BEAT KINGS 114-113",
			"JUST IN NEWS TICKER TAPE OPERATORS SALERY CUT BY 50 PERCE -- FUCK!!!",
			"UNITED STATES CONSTITUTION GONE MISSING?  COUNTRY FALLS INTO STATE OF LAWLESSNESS"
	};
	
	public ScrollingText() {
		t = new Textbox ("LOUD NOISES");
		t.changeBoxVisability();
		t.setX(200);
		t.setY(290);
		t.changeWidth(10000);
	
	}
	
	public void incrementText () {
		t.setX(t.getX() - 3);
	}
	public void fillText () {
		String message = "";
		ArrayList <Integer> indexesUsed = new ArrayList <Integer>();
		Random r = new Random ();
		for (int i = 0; i < allTickerText.length; i++) {
			int newIndex = r.nextInt(allTickerText.length);
			while (indexesUsed.contains(newIndex)) {
				newIndex = r.nextInt(allTickerText.length);
			}
			message = message + " " + allTickerText[newIndex];
			indexesUsed.add(newIndex);
			switch (r.nextInt(5)) {
			case 0:
				message = message + "~Cnormal~";
				break;
			case 1:
				message = message + "~Ctext (blue)~";
				break;
			case 2:
				message = message + "~Ctext (lime green)~";
				break;
			case 3:
				message = message + "~Ctext (purple)~";
				break;
			case 4:
				message = message + "~Ctext (red)~";
				break;
					
			}
		}
		
		message = message + " THIS JUST IN IVE BEEN FIRED BYE";
		t.changeText(message);
	}
	public void drawText() {
		t.draw();
	}
	
}
