package updateActiveObject;

import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import generator.Generator;
import generator.GeneratorAsync;
import observer.ObsGenAsync;

public class Canal implements ObsGenAsync, GeneratorAsync {
	private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private Generator generator;

	@Override
	public Future<Integer> update(Generator g) {
		return executor.submit(() -> {
			Thread.sleep(1000);
			setGenerator(g);
			return g.getValue();
		});
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
