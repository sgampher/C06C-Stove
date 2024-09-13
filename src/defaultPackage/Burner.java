package defaultPackage;

public class Burner {
	
	enum Temperature {
		BLAZING,
		HOT,
		WARM,
		COLD;
	}
	
	private Temperature myTemperature = Temperature.COLD;
	private Setting mySetting;
	private int timer;
	public static final int TIME_DURATION = 2;
	
	public Temperature getTemperature() {
		return myTemperature;
	}
	
	public Burner() {
		mySetting = Setting.OFF;
		myTemperature = Temperature.COLD;
	}
	
	public void plusButton() {
		switch(mySetting) {
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				break;
		}
		
		timer = TIME_DURATION;
	}
	
	public void minusButton() {
		
		switch(mySetting) {
			case HIGH:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.OFF;
				break;
			case OFF:
				break;
		}
		
		timer = TIME_DURATION;
	}
	
	public void updateTemperature() {
		--timer;
		if (timer != 0) {
			return;
		}
		
		if (mySetting == Setting.OFF) {
			
			switch(myTemperature) {
				case COLD:
					break;
				case WARM:
					myTemperature = Temperature.COLD;
					timer = TIME_DURATION;
					break;
				case HOT:
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
					break;
				case BLAZING:
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
					break;
			}
		}
		
		//handles case when burner setting is LOW
		if(mySetting == Setting.LOW) {
			
			switch(myTemperature) {
				case COLD:
					myTemperature = Temperature.WARM;
					break;
				case WARM:
					break;
				case HOT:
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
					break;
				case BLAZING:
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
					break;
			}
		}
		
		//handles case when burner setting is MEDIUM
		if (mySetting == Setting.MEDIUM) {
			
			switch(myTemperature) {
				case COLD:
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
					break;
				case WARM:
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
					break;
				case HOT:
					break;
				case BLAZING:
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
					break;
			}
		}
		
		//handles case when burner setting is HIGH
		if (mySetting == Setting.HIGH) {
			
			switch(myTemperature) {
				case COLD:
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
					break;
				case WARM:
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
					break;
				case HOT:
					myTemperature = Temperature.BLAZING;
					break;
				case BLAZING:
					break;
			}
		}
		
		
		
	}
	
	public void display() {
		String comment;
		
		switch (myTemperature) {
			case COLD:
				comment = "coooool";
				break;
			case HOT:
				comment = "CAREFUL";
				break;
			case WARM:
				comment = "warm";
				break;
			case BLAZING:
				comment = "VERY HOT! DON'T TOUCH";
				break;
			default:
				comment = "I HATE THOSE UNNECCESSARY ERROR LINES";
		}
		
		System.out.println(mySetting.toString() + "....."  + comment);
	}
}
