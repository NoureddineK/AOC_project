package main.instruction;

import java.util.Timer;
import java.util.TimerTask;
/**
 * 
 * @author Noureddine KADRI & Fahim MERZOUK
 *
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

	public void activeCycle(GenerateValue generateValue, float cycle) {
		this.generateValue = generateValue;
		activation = (long) cycle;
	}

	public void update() {
		stopDisplaying();
		startDisplaying();
	}

}
