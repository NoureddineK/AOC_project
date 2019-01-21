package updateActiveObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

import generator.Generator;
import generator.GeneratorAsync;
import observer.ObsGenAsync;
import update.Update;
import view.Afficheur;

public class Canal implements ObsGenAsync, GeneratorAsync {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private ScheduledExecutorService s = Executors.newScheduledThreadPool(10);
	private Generator generator;

	@Override
	public void update(Generator g) {
		 
		 Update mi = new Update(g, new Afficheur());
			LOGGER.info("Calling schedule");
			s.schedule(mi, 10, TimeUnit.SECONDS);
			setGenerator(g);
		 
	}

	@Override
	public Future<Integer> getValue() {
		return executor.submit(() -> {
			Thread.sleep(1000);
			return generator.getValue();
		});
	}

	public Generator getGenerator() {
		return this.generator;
	}

	public void setGenerator(Generator generator) {
		this.generator = generator;
	}



}
