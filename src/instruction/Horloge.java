package instruction;

import java.util.Timer;
import java.util.TimerTask;

public class Horloge {
	private Instruction clickC;
	private Timer timer;
	private long periodActiveCmd = 200;

	public Horloge() {

		timer = new Timer();
	}

	public void startChrono() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				clickC.execute();
			}
		}, 0, periodActiveCmd);
	}

	public void stopChrono() {
		timer.cancel();
	}

	public void activerPeriodiquement(Instruction cmdClick, float periodEnMSecondes) {

		this.clickC = cmdClick;
		periodActiveCmd = (long) periodEnMSecondes;

	}

	public void update() {
		stopChrono();
		startChrono();
	}

}
