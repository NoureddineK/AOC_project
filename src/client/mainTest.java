package client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

import diffusion.AtomiqueDiffusion;
import generator.GeneratorImp;
import observer.ObserverGenerator;
import updateActiveObject.Canal;
import view.Afficheur;

public class mainTest {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		GeneratorImp generator = new GeneratorImp(new AtomiqueDiffusion());
    	ObserverGenerator display1 = new Afficheur(1);
    	ObserverGenerator display2 = new Afficheur(3);
    	ObserverGenerator display3 = new Afficheur(2);
    	ObserverGenerator display4 = new Afficheur(4);
    	ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(8);
    	Canal canal1 = new Canal(scheduler);
    	canal1.attach(display1);
    	Canal canal2 = new Canal(scheduler);
    	canal2.attach(display2);
    	Canal canal3 = new Canal(scheduler);
    	canal3.attach(display3);
    	Canal canal4 = new Canal(scheduler);
    	canal4.attach(display4);
    	generator.attach(canal1);
    	generator.attach(canal2);
    	generator.attach(canal3);
    	generator.attach(canal4);
    	generator.run();
    }
}
