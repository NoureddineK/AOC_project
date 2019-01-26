package client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

import diffusion.AtomiqueDiffusion;
import diffusion.SequentielDiffusion;
import generator.GeneratorImp;
import observer.ObserverGenerator;
import updateActiveObject.Canal;
import view.Display;

public class mainTest {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		GeneratorImp generator = new GeneratorImp(new AtomiqueDiffusion());
    	ObserverGenerator display1 = new Display(1);
    	ObserverGenerator display2 = new Display(3);
    	ObserverGenerator display3 = new Display(2);
    	ObserverGenerator display4 = new Display(4);
    	Canal canal1 = new Canal();
    	canal1.attach(display1);
    	Canal canal2 = new Canal();
    	canal2.attach(display2);
    	Canal canal3 = new Canal();
    	canal3.attach(display3);
    	Canal canal4 = new Canal();
    	canal4.attach(display4);
    	generator.attach(canal1);
    	generator.attach(canal2);
    	generator.attach(canal3);
    	generator.attach(canal4);
    	generator.run();
    }
}
