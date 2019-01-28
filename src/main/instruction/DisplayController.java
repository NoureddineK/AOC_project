package main.instruction;

import java.util.Timer;
import java.util.TimerTask;
/**
 * @author Noureddine KADRI  
 * @author Fahim MERZOUK
 * Monitors Controller 
 */
public class DisplayController {
	private GenerateValue generateValue;
	private Timer timer;
	private long activation = 200;

	public DisplayController() {
		timer = new Timer();
	}

	public void startDisplaying() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				generateValue.execute();
			}
		}, 0, activation);
	}

	public void stopDisplaying() {
		timer.cancel();
	}

	/**
	 * Cycle Activation 
	 * @param generateValue
	 * @param cycle
	 */
	public void activeCycle(GenerateValue generateValue, float cycle) {
		this.generateValue = generateValue;
		activation = (long) cycle;
	}

	/**
	 * Update Displaying
	 */
	public void update() {
		stopDisplaying();
		startDisplaying();
	}

}
