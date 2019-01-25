package client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

import canal.Canal;
import diffusion.AtomiqueDiffusion;
import diffusion.SequentielDiffusion;
import generator.Generator;
import generator.GeneratorImp;
import observer.ObserverGenerator;
import view.Display;
import view.Ihm;

public class mainTest {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Generator capt = new GeneratorImp();
		Ihm ihm = new Ihm();
		ihm.setCapteur(capt);
    }
}
